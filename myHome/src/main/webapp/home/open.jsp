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
<form:form modelAttribute="item" action="../product/open.html"
		method="post" onSubmit="return validate(this)">
<h4>��ǰ �̸� :<input type="text" name="TITLE"/></h4>
<h4>��ǰ ���� :<input type="text" name="PRICE"/></h4>
<h4>������ : <input type="radio" name="ORIGIN" value="KOR"/>�ѱ��� <input type="radio" name="ORIGIN" value="FOR"/>�ܱ���</h4>
<h4>��ǰ ���� : (�Ʒ�)</h4>
<textarea cols="80" rows="5" name="CONTENT"></textarea><br/>
<input type="submit" value="��ǰ �ø���"/>
<input type="reset" value="�� ��"/>
</form:form>
</body>
</html>