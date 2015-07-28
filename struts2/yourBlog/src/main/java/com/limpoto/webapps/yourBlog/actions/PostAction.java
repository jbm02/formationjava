package com.limpoto.webapps.yourBlog.actions;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;

import com.limpoto.webapps.yourBlog.beans.Post;
import com.limpoto.webapps.yourBlog.utils.PostDAO;
import com.opensymphony.xwork2.ActionSupport;

public class PostAction extends ActionSupport implements ServletContextAware {

	private static final long serialVersionUID = 1980869589949708269L;
	
	private ServletContext ctx;
	private PostDAO postDAO;
	private List<Post> posts;
	private int postId;
	private String postTitre;
	private String postCorps;
	private Date postDate;
	
	
	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public PostDAO getPostDAO() {
		return postDAO;
	}

	public void setPostDAO(PostDAO postDAO) {
		this.postDAO = postDAO;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getPostTitre() {
		return postTitre;
	}

	public void setPostTitre(String postTitre) {
		this.postTitre = postTitre;
	}

	public String getPostCorps() {
		return postCorps;
	}

	public void setPostCorps(String postCorps) {
		this.postCorps = postCorps;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}


	@Override
	public void setServletContext(ServletContext arg0) {
		ctx = arg0;
		postDAO = (PostDAO)ctx.getAttribute("postDAO");
	}
	
	public String liste() {
		posts = postDAO.findAll();
		return SUCCESS;
	}
	
	public String create(){
		setPostId(0);
		setPostTitre("nouveau titre...");
		setPostCorps("nouveau post...");
		setPostDate(new Date());
		return SUCCESS;
	}
	
	public String edit() {
		Post p = postDAO.findByID(getPostId());
		if (p == null) {
			return "notfound";
		}
		setPostTitre(p.getTitre());
		setPostCorps(p.getCorps());
		setPostDate(p.getDateCreation());
		return SUCCESS;
	}
	
	public String save() {
		Post p = new Post(getPostId(), getPostTitre(), getPostCorps(), getPostDate());
		postDAO.save(p);
		return SUCCESS;
	}
}
