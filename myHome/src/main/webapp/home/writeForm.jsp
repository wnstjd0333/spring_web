<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
table { width:100%; height:300px;}
</style>
</head>
<body>
<form:form modelAttribute="writing" action="../write/write.html" id="fileupload" method="post" enctype="multipart/form-data">
<table border="1">
	<tr>
		<td>글제목</td><td><form:input path="title" size="40"/>
		<font color="red"><form:errors path="title"/></font></td>
	</tr>
	<tr>
		<td>닉네임</td><td><form:input path="writer_name" size="20"/>
		<font color="red"><form:errors path="writer_name"/></font></td>
	</tr>
	<tr>
		<td>이메일</td><td><form:input path="email" size="40"/>
		<font color="red"><form:errors path="email"/></font></td>
	</tr>
	<tr>
		<td>암호</td><td><form:input path="password" size="20"/>
		<font color="red"><form:errors path="password"/></font></td>
	</tr>
	<tr>
		<td>이미지</td><td><input type="file" name="image" size="20"/></td>
	</tr>
	<tr>
		<td>글내용</td><td><form:textarea path="content" rows="10" cols="40"
			style="width:100%; height:285px"></form:textarea></td>		
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="등 록"/></td>
	</tr>	
</table>
</form:form>
</body>
</html>