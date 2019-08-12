<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>상품 목록 화면</title>
<link rel="stylesheet" type="text/css" href="../css/5-5.css">
<%-- 링크는 헤드와 헤드 사이 stylesheet는 rel의 속성값으로 스타일 시트로 연결할때. --%>
</head>
<body>
<%@ include file="/WEB-INF/jsp/menu_header.jsp" %>
<div align="center" class="body"> <%-- div : 웹사이트의 레이아웃을 만들 때 사용--%>
	<h2>상품 목록 화면</h2>
	<table border="1">
		<tr class="header">
			<th align="center" width="80">상품ID</th>
			<th align="center" width="320">상품명</th>
			<th align="center" width="100">가격</th>
		</tr>
		<c:forEach items="${itemList }" var="item">
			<tr class="record">
				<td align="center">${item.itemId }</td>
				<td align="center"><a href="../detail/detail.html?itemId=${item.itemId }">${item.itemName }</a></td>
				<td align="center">${item.price }</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>




