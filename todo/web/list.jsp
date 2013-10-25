<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>Tasks for ${user}</h1>

<table border="1">
    <tr><td>id</td><td>name</td></tr>
    <c:forEach items="${tasks}" var="task">
        <tr>
            <td>${task.id}</td>
            <c:url var="view" value="/view">
                <c:param name="id" value="${task.id}" />
            </c:url>
            <td><a href="${view}">${task.name}</a></td>
        </tr>
    </c:forEach>
</table>

<form action="<c:url value="/create" />">
    <input type="text" name="name" value="" />
    <input type="submit" value="create" />
</form>


