<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
<h3 align="center">�Խ��� �۾���</h3>
<form:form modelAttribute="bbs" action="../home/write.html"
		method="post" onSubmit="return validate(this)">
<h4>���� : <form:input path="title" cssClass="title"/></h4>
<font color="red"><form:errors path="title"/></font><br/>
<textarea rows="5" cols="80" name="content"></textarea><br/>
<font color="red"><form:errors path="content"/></font><br/>
<input type="submit" value="�� �ø���"/>&nbsp;
<input type="reset" value="���"/>
</form:form>
</body>
</html>













