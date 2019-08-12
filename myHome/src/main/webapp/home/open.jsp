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
<h4>상품 이름 :<input type="text" name="TITLE"/></h4>
<h4>상품 가격 :<input type="text" name="PRICE"/></h4>
<h4>원산지 : <input type="radio" name="ORIGIN" value="KOR"/>한국산 <input type="radio" name="ORIGIN" value="FOR"/>외국산</h4>
<h4>상품 설명 : (아래)</h4>
<textarea cols="80" rows="5" name="CONTENT"></textarea><br/>
<input type="submit" value="상품 올리기"/>
<input type="reset" value="취 소"/>
</form:form>
</body>
</html>