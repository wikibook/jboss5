<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page
	import="javax.naming.*, org.hibernate.* "%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form name="module" action="actionServlet?op=addDouble" method="POST">
<fieldset><legend> Double 값을 입력하세요. </legend> 
<label>First</label> 
<input type="text" name="first" value=<%= request.getParameter("first") %> size="20">
<label>Second</label> 
<input type="text" name="second" value=<%= request.getParameter("second") %> size="20">
<label>=</label>
<input type="text" name="addresult" value="${addresult}" size="20">
<br />
</fieldset>

<input type="submit" value="계산"></form>
