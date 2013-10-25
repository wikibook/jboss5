<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<c:choose>
    <c:when test="${x}">
        X
    </c:when>
    <c:otherwise>
        Y
    </c:otherwise>
</c:choose>
