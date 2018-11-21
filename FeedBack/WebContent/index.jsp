<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>index</title>
</head>

<body>
	<form:form action="./GetTeacherInServlet" method="post">
		<button type="submit">开始</button>
	</form:form>
	
	<form:form action="./StudentInfoInputServlet" method="post" enctype="multipart/form-data">
		<input id="upteainput"  name="file" type="file" value="导入文件" />
		<button type="submit">导入</button>
	</form:form>
	
	<br>
</body>
</html>