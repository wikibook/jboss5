package com.jbossnotebook.jms;

import java.io.IOException;
import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
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
		String forward = "/sendMessage.jsp";
		
		if (action.equals("sendMessage")) {
			forward = sendMessage(request);
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(forward);
		dispatcher.forward(request,response);
	}

	private String sendMessage(HttpServletRequest request) {
		
		String myMessage = request.getParameter("myMessage");
		String destinationName = "queue/exampleQueue";

		Context ic = null;
		ConnectionFactory cf = null;
		Connection connection =  null;

		try {
			
			Properties p = new Properties( );
			p.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
			p.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
			p.put(Context.PROVIDER_URL, "jnp://localhost:1099");
			ic = new javax.naming.InitialContext(p);  

			cf = (ConnectionFactory)ic.lookup("/ConnectionFactory");  
			Queue queue = (Queue)ic.lookup(destinationName);

			connection = cf.createConnection();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);  
			MessageProducer sender = session.createProducer(queue);

			TextMessage message = session.createTextMessage(myMessage);   
			sender.send(message); 

			System.out.println("The message was successfully sent to the " + queue.getQueueName() + " queue");


		}catch(Exception e){
			e.printStackTrace();

		}finally{

			if(ic != null) {
				try {
					ic.close();
				}catch(Exception ignore){ }
			}

			try {
				if (connection != null) {
					connection.close();
				}

			}catch(JMSException jmse) {
				System.out.println("Could not close connection " + connection +" exception was " +jmse);
			}

		}
		return "/sendMessage.jsp";
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
