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

    <h:form>
        <h:panelGrid columns="2">
             <f:verbatim>Task Name:</f:verbatim>
             <h:outputText value="#{currentTask.name}" />
             <f:verbatim>Start Date:</f:verbatim>
             <h:outputText value="#{currentTask.startedDate}" />
             <f:verbatim>Completed Date:</f:verbatim>
             <h:outputText value="#{currentTask.completedDate}" />
             <f:verbatim>Comments:</f:verbatim>

                 <h:dataTable value="#{currentTask.comments}" var="comment">
                     <h:column>
                          <h:outputText value="#{comment.date}" />
                     </h:column>
                     <h:column>
                          <h:outputText value="#{comment.commentText}" />
                     </h:column>
                 </h:dataTable>

        </h:panelGrid>

        <f:verbatim>New Comment:</f:verbatim>
        <h:inputText value="#{taskmgr.comment}" />
        <h:commandButton action="#{taskmgr.addComment}" value="add comment"/>
        
        <br />

        <h:commandLink action="front" value="all tasks" />
    </h:form>

</body>
</html>
</f:view>
