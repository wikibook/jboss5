<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
GET<br/>
<form action="testUTF8_proc.jsp" method="get">
이름<input type="text" name="sname" /><br/>
전화번호<input type="text" name="stel" /><br/>
<input type="submit" value="OK" />
</form>
<br/><br/>
POST<br/>
<form action="testUTF8_proc.jsp" method="post">
이름<input type="text" name="sname" /><br/>
전화번호<input type="text" name="stel" /><br/>
<input type="submit" value="OK" />
</form>

<ul>
	<li>العربية</li>
	<li>Català</li>
	<li>Česky</li>
	<li>Español</li>
	<li>Français</li>
	<li>한국어</li>
	<li>עברית</li>
	<li>フリー百科事典</li>
	<li>bokmål</li>
	<li>Português</li>
	<li>Русский</li>
	<li>Română</li>
	<li>Slovenčina</li>
	<li>Српски</li>
	<li>Türkçe</li>
	<li>Українська</li>
	<li>Tiếng Việt</li>
	<li>Volapük</li>
	<li>中文</li>
</ul>

</body>
</html>