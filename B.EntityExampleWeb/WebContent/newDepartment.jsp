<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>

<form action="actionServlet?op=saveDepartment" method="post">
<fieldset><legend> 부서를 입력하세요. </legend> <label>부서명</label>
<input type="text" name="depName" size="20"><br />
</fieldset>
<input type="submit" value="저장"></form>
</html>