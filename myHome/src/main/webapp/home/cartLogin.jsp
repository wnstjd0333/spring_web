<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
				prefix="c" %>
<%@ taglib prefix="spring" 
		uri="http://www.springframework.org/tags" %>    
<%@ taglib prefix="form" 
		uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${RESULT == 'nologin' }">
		<h3 align="center">��ǰ�� �����÷��� �α����� �ؾ��մϴ�.</h3>
	</c:when>
</c:choose>
<form:form modelAttribute="user" action="../cart/login.html"
	method="post">
���̵� : <form:input path="id" size="12"/>
<font color="red"><form:errors path="id"/></font><br/>
�н����� : <form:password path="password" size="12"/>
<font color="red"><form:errors path="password"/></font><br/>
<input type="submit" value="�α���"/>
</form:form>
<div align="right"><a href="../home/userentry.html">�����ϱ�</a></div><br/>
</body>
</html>

















