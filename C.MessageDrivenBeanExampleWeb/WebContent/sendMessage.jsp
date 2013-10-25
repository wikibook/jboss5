<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>

<form action="actionServlet?op=sendMessage" method="post">
<fieldset><legend> 메시지를 입력하세요. </legend>
<input type="text" name="myMessage" size="100"><br />
</fieldset>
<input type="submit" value="전송"></form>
</html>