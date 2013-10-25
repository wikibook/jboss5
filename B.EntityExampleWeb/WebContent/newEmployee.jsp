<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page
	import="javax.naming.*, org.hibernate.*, com.jbossnotebook.jpa.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form name="module" action="actionServlet?op=saveEmployee" method="POST">
<fieldset><legend> 사원을 입력하세요. </legend> <label>사원명</label> 
<input type="text" name="name" size="20"><br />
<label>월급</label> <input type="text" name="salary" size="20"><br />
<label>부서</label> <select name="departmentId">
	<c:forEach items="${departmentList}" var="dep">

		<option value="<c:out value="${dep.departmentId}"/>"><c:out
			value="${dep.departmentName}" /></option>
			
	</c:forEach>



</select></fieldset>

<input type="submit" value="저장"></form>
