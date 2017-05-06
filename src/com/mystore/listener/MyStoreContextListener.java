package com.mystore.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.mystore.dao.service.SchemaDao;
import com.mystore.dao.service.impl.SchemaDaoImpl;
import com.mystore.dao.service.util.LoadProperty;

/**
 * Application Lifecycle Listener implementation class MyStoreContextListener
 *
 */
@WebListener
public class MyStoreContextListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public MyStoreContextListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("I'm running.");
    	ServletContext servletContext = arg0.getServletContext();
    	String createTables = servletContext.getInitParameter("createTables");
    	String dropTables = servletContext.getInitParameter("dropTables");
    	
    	String dbPropertiesFilepath = servletContext.getRealPath("WEB-INF//db//properties//db.properties");
    	LoadProperty.load(dbPropertiesFilepath);
    	
    	String getTablesScriptPath = servletContext.getRealPath("WEB-INF//db//schema//tables.sql");
    	
    	if("yes".equalsIgnoreCase(dropTables)){
    		System.out.println("Yes drop tables now!");
    		SchemaDao schemaDao = new SchemaDaoImpl();
    		schemaDao.dropTables(getTablesScriptPath);
    	}
    	
    	if("yEs".equalsIgnoreCase(createTables)){
    		System.out.println("Yes create tables now!");
    		SchemaDao schemaDao = new SchemaDaoImpl();
    		schemaDao.createTables(getTablesScriptPath);
    	}
    }
	
}
