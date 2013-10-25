<%
   //Object o = this.getClass().getResourceAsStream("/com/oreillly/jbossnotebook/todo/messages.properties");

   Object o =  java.util.ResourceBundle.getBundle("com.oreilly.jbossnotebook.todo.messages");

     
%>


oo: <%= o %>
