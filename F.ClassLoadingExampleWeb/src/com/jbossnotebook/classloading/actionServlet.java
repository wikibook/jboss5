package com.jbossnotebook.classloading;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class actionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Log log = LogFactory.getLog(actionServlet.class);
	
    public actionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletOutputStream out = response.getOutputStream();
	    response.setContentType("text/plain");
	    out.println("You called me. Look at the log file.");
	    
		log.info("...this is info log...");
		
		out.println(log.toString());
		out.println(getClassLoaderList(log));
		
	}
	
	private String getClassLoaderList(Object object) {
		
		ClassLoader loader = object.getClass().getClassLoader();
		String suffix = "class = " + object.getClass().getName() + "\r\n";
		
		while(loader != null){
			suffix = suffix + "class loader = " + loader.getClass().getName() + "\r\n";
			loader = loader.getParent();
		}
		
		return suffix;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
