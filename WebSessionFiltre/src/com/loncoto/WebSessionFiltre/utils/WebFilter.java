package com.loncoto.WebSessionFiltre.utils;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class WebFilter
 */
public class WebFilter implements Filter {
	private String name;

    /**
     * Default constructor. 
     */
    public WebFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		System.out.println(name + " Appel de doFilter avant chain");
		System.out.println(name + " request -> " + request.getLocalAddr());
		// pass the request along the filter chain
		chain.doFilter(request, response);
		System.out.println(name + " Appel de doFilter après chain");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		name = fConfig.getFilterName();
		System.out.println("init du filtre" + name);
	}

}
