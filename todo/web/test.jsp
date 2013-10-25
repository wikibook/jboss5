<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<h1>Users: </h1>

<table border="1">
    <tr><td>id</td><td>name</td><td>password</td></tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.password}</td>
        </tr>
    </c:forEach>
</table>


