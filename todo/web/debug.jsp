<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<html>
    <head>
        <title>JSP test page</title>
    </head
<body>

<f:view>
    <h:form>
            <f:verbatim>Debug Mode:</f:verbatim>
            <h:selectBooleanCheckbox value="#{debug.debugMode}" />
            <h:commandButton action="#{debug.doNothing}"  value="change" />
    </h:form>

</f:view>

</body>

</html>
