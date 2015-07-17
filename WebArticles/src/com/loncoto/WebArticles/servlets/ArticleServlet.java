package com.loncoto.WebArticles.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loncoto.WebArticles.beans.Article;
import com.loncoto.WebArticles.utils.ArticleDAO;

/**
 * Servlet implementation class ArticleServlet
 */
public class ArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ArticleDAO articleDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		articleDAO = (ArticleDAO) getServletContext().getAttribute("articleDAO");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Article> articles = articleDAO.findAll();
		request.setAttribute("articles", articles);
		getServletContext().getRequestDispatcher("/liste.jsp").forward(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		switch (action) {
		case "editer":
			int id = Integer.parseInt(request.getParameter("id"));
			Article a = articleDAO.findByID(id);
			request.setAttribute("article", a);
			getServletContext().getRequestDispatcher("/edit.jsp").forward(
					request, response);
			break;
			
		case "creer":
			Article a2 = new Article(0, "Libelle", 0.0, 0.0);
			request.setAttribute("article", a2);
			getServletContext().getRequestDispatcher("/edit.jsp").forward(
					request, response);
			break;	
		case "sauver":
			Article a3 = new Article(
					Integer.parseInt(request.getParameter("id")),
					request.getParameter("libelle"), Double.parseDouble(request.getParameter("prix")),
					Double.parseDouble(request.getParameter("poids")));
			articleDAO.save(a3);
			response.sendRedirect("ArticleServlet");
			break;
		case "supprimer":
			int cid = Integer.parseInt(request.getParameter("id"));
			articleDAO.delete(cid);
			response.sendRedirect("ArticleServlet");
			break;	

		default:
			break;
		}
	}

}
