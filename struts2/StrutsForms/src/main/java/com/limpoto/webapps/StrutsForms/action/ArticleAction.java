package com.limpoto.webapps.StrutsForms.action;

import com.limpoto.webapps.StrutsForms.beans.Article;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ArticleAction extends ActionSupport implements ModelDriven<Article>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Article model;
	
	@Override
	public Article getModel() {
		System.out.println("appel de getModel");
		if(model==null){
			model = new Article();
		}
		return model;
	}
	
	public String edit(){
		getModel().setId(1);
		getModel().setLibelle("chaise longue");
		getModel().setPoids(45.5);
		getModel().setPrix(15.5);
		return SUCCESS;
	}

}
