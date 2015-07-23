package com.AnnotationWeb.util;

import java.io.IOException;
import java.lang.reflect.Field;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;


public class Myform extends SimpleTagSupport {

	private String action;
	private String item;
	
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();
		PageContext pc = (PageContext)getJspContext();
		ServletRequest req = pc.getRequest();
		JspWriter writer = pc.getOut();
		
		Object obj = req.getAttribute(getItem());
		if (obj == null) {
			return;
		}
		
		@SuppressWarnings("rawtypes")
		Class cls = obj.getClass();
		
		writer.println("<form action'" + getAction() + "'method='post' >");
		
		Field[] champ = cls.getDeclaredFields();
		for (Field field : champ) {
			ChampFormulaire cf = field.getAnnotation(ChampFormulaire.class);
			if (cf != null) {
				writer.println("<span>" + cf.label() +"</span>");
				writer.println("<input type='text' name='" + cf.name() + "' /><br />");
			}
		}
		writer.println("<input type ='submit' /></form>");
		
	}


}
