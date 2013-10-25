package com.jbossnotebook.webserviceclient;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class actionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public actionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action=request.getParameter("op");

		System.out.println("Action is "+action);
		String forward = "/addDouble.jsp";
		
		if (action.equals("addDouble")) {
			forward = addDouble(request);
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(forward);
		dispatcher.forward(request,response);
	}
	
	private String addDouble(HttpServletRequest request) {
		double first = Double.parseDouble(request.getParameter("first"));
		double second = Double.parseDouble(request.getParameter("second"));
		
		MathService webServiceClient = new MathService();
		MathWebService webService = webServiceClient.getMathWebServicePort();
		
		double addresult = webService.addDouble(first, second);
		
		request.setAttribute("addresult", String.valueOf(addresult));
		
		return "/addDouble.jsp";
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
