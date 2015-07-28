package com.limpoto.webapps.yourBlog.utils;

import java.sql.*;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


/**
 * Application Lifecycle Listener implementation class DatabaseManager
 *
 */
public class DatabaseManager implements ServletContextListener {
	
	private Connection base;

    /**
     * Default constructor. 
     */
    public DatabaseManager() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
        try {
			base.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
        String driverclass = arg0.getServletContext().getInitParameter("driverclass");
        String databaseurl = arg0.getServletContext().getInitParameter("databaseurl");
        String login = arg0.getServletContext().getInitParameter("login");
        String password = arg0.getServletContext().getInitParameter("password");
        
        try {
       	 // Chargement du driver mysql
            Class.forName(driverclass);
            base = DriverManager.getConnection(databaseurl, login, password);
            // Création du DAO
            PostDAO postDAO = new PostDAO(base);
            // Met le DAO à disposition des servlets
            arg0.getServletContext().setAttribute("postDAO", postDAO);
            
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
}
