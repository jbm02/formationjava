package com.loncoto.webCustomTag.utils;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Hello2Tag extends SimpleTagSupport {
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();
		PageContext pc = (PageContext) getJspContext();
		JspWriter writer = pc.getOut();
		
		writer.print("<h2>" + message + "</h2>");
	}

}
