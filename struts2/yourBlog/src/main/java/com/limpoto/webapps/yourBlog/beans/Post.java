package com.limpoto.webapps.yourBlog.beans;

import java.util.Date;

public class Post {
	
	//Attributs
	private int id;
	private String titre;
	private String corps;
	private Date dateCreation;
	
	// GET/SET
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getCorps() {
		return corps;
	}
	public void setCorps(String corps) {
		this.corps = corps;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	//Constructeur
	public Post(){this(0,"","",null);}
	public Post(int id, String titre, String corps, Date dateCreation) {
		this.id = id;
		this.titre = titre;
		this.corps = corps;
		this.dateCreation = dateCreation;
	}
	
	
}
