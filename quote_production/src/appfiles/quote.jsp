<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Random" %>
<%@ page import="java.util.Arrays" %>

<%
  //List of sayings
 	String[] quotes = {
 		"Before God we are all equally wise - and equally foolish", 
		"I never think of the future - it comes soon enough",
 		"Imagination is more important than knowledge...",
 		"Reality is merely an illusion, albeit a very persistent one",
 		"The important thing is not to stop questioning",
 		"The secret to creativity is knowing how to hide your sources",
 		"Science without religion is lame, religion without science is blind",
 		"Everything that is really great and inspiring is created by the individual who can labor in freedom"
  };
  ArrayList list = new ArrayList(Arrays.asList(quotes));	
	Random r = new Random();
	int x = r.nextInt(list.size());
	String saying = (String)list.get(x);    
	saying = saying + " -- Albert Einstein";
	pageContext.setAttribute("saying", saying);
%>

<html>
	<head>
  	<title>JBoss Notebook Chapter 2 Demo 1</title>
  </head>
  <body>
	<br>
	<c:set var="sessionCount" scope="session"
			value="${sessionCount + 1}" />
	<c:set var="applicationCount" scope="application"
			value="${applicationCount + 1}" />
	<h1>
		<font color="#1230cb">The Great Albert Einstein Quote Machine</font>
	</h1>
	<h3>
		<spacer size="32" type="horizontal">
		<font color="#a6a6a6">
			${saying}
		</font>
	</h3>
	<br><br>
	You've visited this application ${sessionCount} 
	times in this session 
	<br>
	and the application has been visited ${applicationCount} 
	times by you and others.
	</body>
</html>
