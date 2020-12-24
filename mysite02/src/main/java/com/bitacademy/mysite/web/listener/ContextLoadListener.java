package com.bitacademy.mysite.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class ContextLoadListener
 *
 */
public class ContextLoadListener implements ServletContextListener {



    public void contextInitialized(ServletContextEvent arg0)  { 
    	System.out.println("Application Starts.......");
    }
	
    public void contextDestroyed(ServletContextEvent arg0)  { 

    }


	
}
