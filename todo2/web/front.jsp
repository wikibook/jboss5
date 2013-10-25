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
    <h1><h:outputText value="#{msgs.tasksForUser}" /> <h:outputText value="#{user.name}" /></h1>
    <h:form>
        <h:dataTable value="#{taskmgr.tasks}" var="task"
                     styleClass="tasks" headerClass="tasksHeader"
                     rowClasses="tasksRow1,TasksRow2">

            <h:column rendered="#{debug.debugMode}">
                <f:facet  name="header">
                    <h:outputText value="#{msgs.idColumn}" />
                </f:facet>
                <h:outputText value="#{task.id}" />
            </h:column>

            <h:column>
                <f:facet  name="header">
                    <h:outputText value="#{msgs.nameColumn}" />
                </f:facet>
                
                    <h:commandLink action="#{taskmgr.viewTask}">
                         <h:outputText value="#{task.name}" />
                    </h:commandLink>

            </h:column>

            <h:column>
                <f:facet  name="header">
                    <h:outputText value="#{msgs.startColumn}" />
                </f:facet>
                <h:outputText value="#{task.startedDate}" />
            </h:column>


            <h:column>
                <f:facet  name="header">
                    <h:outputText value="#{msgs.endColumn}" />
                </f:facet>
                <c:choose>
                     <c:when test="${task.completed}">
                         <h:outputText value="#{task.completedDate}" />
                     </c:when>
                     <c:otherwise>
                         <h:commandButton action="#{taskmgr.complete}" value="Complete Task" />
                     </c:otherwise>
                </c:choose>

            </h:column>
        </h:dataTable>
    </h:form>

    <h:form>
        <h:inputText value="#{createtask.name}" />
        <h:commandButton action="#{createtask.create}"  value="#{msgs.createAction}" />
    </h:form>
</body>
</html>
</f:view>
