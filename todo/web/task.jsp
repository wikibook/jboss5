<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<f:view>
<html>
    <head>
        <link href="style.css" rel="stylesheet" type="text/css" />
        <f:loadBundle basename="com.oreilly.jbossnotebook.todo.messages" var="msgs" />
        <title><h:outputText value="#{msgs.frontTitle}" /></title>        
    </head>
<body>

    <h1><h:outputText value="#{msgs.taskName}" /> <h:outputText value="#{currentTask.name}" /></h1>

    <h:form>
        <h:panelGrid styleClass="task" columns="2">
             <h:outputText value="#{msgs.startedDate}" />
             <h:outputText value="#{currentTask.startedDate}" />
             <h:outputText value="#{msgs.completedDate}" />


             <h:panelGroup>
                 <h:outputText value="#{currentTask.completedDate}" 
                               rendered="#{currentTask.completedDate!=null}" />
                 <h:commandButton action="#{taskmgr.completeCurrent}" 
                                  value="#{msgs.completeTask}"
                                  rendered="#{currentTask.completedDate==null}" />
             </h:panelGroup>
             

             <h:outputText value="#{msgs.comments}" />
             <h:panelGroup>
                 <h:dataTable value="#{currentTask.comments}" 
                              var="comment"
                              styleClass="comments" 
                              rowClasses="commentsRow1,commentsRow2">                     
                     <h:column>
                         <h:outputText value="#{comment.date}" />
                     </h:column>
                     <h:column>
                         <h:outputText value="#{comment.commentText}" />
                     </h:column>
                 </h:dataTable>

                 <h:commandButton action="#{taskmgr.addComment}" 
                                  value="#{msgs.addComment}"/>
                 <h:inputText value="#{taskmgr.comment}" />

             </h:panelGroup>
        </h:panelGrid>
        
        <br />

        <h:commandLink action="front" value="#{msgs.allTasks}" />
    </h:form>

</body>
</html>
</f:view>
