package com.limpoto.webapps.StrutsDatabase.actions;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;

import com.limpoto.webapps.StrutsDatabase.beans.Client;
import com.limpoto.webapps.StrutsDatabase.utils.ClientDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ClientAction extends ActionSupport implements ServletContextAware {

	private static final long serialVersionUID = -1636152784443988949L;
	private ServletContext ctx;
	private ClientDAO clientDAO;
	private List<Client> clients;
	private int clientId;
	private String clientNom;
	private String clientEmail;
	private double clientSolde;
	
	/*
	 * GET/SET
	 */
	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getClientNom() {
		return clientNom;
	}

	public void setClientNom(String clientNom) {
		this.clientNom = clientNom;
	}

	public String getClientEmail() {
		return clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}

	public double getClientSolde() {
		return clientSolde;
	}

	public void setClientSolde(double clientSolde) {
		this.clientSolde = clientSolde;
	}
	
	/*
	 * ACTION
	 */
	@Override
	public void setServletContext(ServletContext arg0) {
		ctx = arg0;
		clientDAO=(ClientDAO)ctx.getAttribute("clientDAO");
	}
	
	public String liste(){
		clients= clientDAO.findAll();
		return SUCCESS;
	}
	
	public String edit(){
		Client c = clientDAO.findByID(getClientId());
		if (c == null) {
			return "notfound";
		}
		setClientNom(c.getNom());
		setClientEmail(c.getEmail());
		setClientSolde(c.getSolde());
		return SUCCESS;
	}
	
	public String save(){
		Client c = new Client(getClientId(),getClientNom(),getClientEmail(),getClientSolde());
		clientDAO.save(c);
		return SUCCESS;
	
	}
}
