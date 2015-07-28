package com.loncoto.webstruts.firstStruts.actions;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {
	
	
	private static final long serialVersionUID = 1L;

	private String message;
	private String login;
	private String password;
	
	/*
	 * GET/SET
	 */
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	/*
	 * ACTION
	 */
	
	public String index() {
		message = "bonjour depuis index le " + new Date();
		return SUCCESS;
	}
	
	public String pwd(){
		if (password.length() < 3) {
			setMessage("Mot de passe incorrect !");
			return ERROR;
		}
		setMessage("Bienvenue " + login + "!");
		return SUCCESS;
	}

}
