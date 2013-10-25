<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<script language="JavaScript">
 function doSubmit(url)  { 
   document.module.action = url;
   document.module.submit();
 }
</script>

<body>
<table border="1">
	<TR>
		<TH>사원명</TH>
		<TH>월급</TH>
		<TH>부서</TH>
	</TR>
	<c:forEach items="${employee}" var="emp">
		<tr>
			<td><c:out value="${emp.employeeName}" /></td>
			<td><c:out value="${emp.employeeSalary}" /></td>
			<td><c:out value="${emp.department.departmentName}" /></td>
		</tr>
	</c:forEach>
</table>

<form name="module" method="POST">
<input type="button" value="사원등록" onClick="doSubmit('actionServlet?op=newEmployee')">
<input type="button" value="부서등록" onClick="doSubmit('actionServlet?op=newDepartment')">
</form>

</body>
</html>