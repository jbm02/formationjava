package com.limpoto.webapps.StrutsForms.action;

import java.util.ArrayList;
import java.util.List;

import com.limpoto.webapps.StrutsForms.beans.Article;
import com.opensymphony.xwork2.ActionSupport;

public class FormAction extends ActionSupport {

	private static final long serialVersionUID = -1365150114969466627L;
	private String libelle;
	private double prix;
	private double poids;
	private int articleID;
	
	private List<Article> articles;

	/**
	 * ---------------- GET/SET ------------------
	 */
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public double getPoids() {
		return poids;
	}

	public int getArticleID() {
		return articleID;
	}

	public void setArticleID(int articleID) {
		this.articleID = articleID;
	}

	public void setPoids(double poids) {
		this.poids = poids;
	}

	public List<Article> getArticles() {
		return articles;
	}

	/*
	 * ---------------- ACTION ------------------
	 */
	public String index() {
		return SUCCESS;
	}

	public String enregistrer() {
		System.out.println("recu un article de libelle " + getLibelle()
				+ " prix = " + getPrix() + " poids = " + getPoids());
		return SUCCESS;
	}
	
	public String liste(){
		articles = new ArrayList<Article>();
		articles.add(new Article(1, "table tek", 15.5, 2.5));
		articles.add(new Article(2, "fauteuil comfort", 150.5, 12.5));
		articles.add(new Article(3, "chaise design", 45.5, 5.5));
		articleID = 2;
		return SUCCESS;
	}
}
