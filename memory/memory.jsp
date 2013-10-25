<%@ page import="java.util.*" %>

<h1> Memory Eater </h1>
<%! int count; %>
<% 
   try {
       ArrayList list = new ArrayList();
       while (true) {
           list.add(new Object()); 
           count++;
       }

    } catch (Throwable t) {
    }

%>

Created <%= count %> objects...
