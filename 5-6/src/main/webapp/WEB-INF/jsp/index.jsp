<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ include file="/WEB-INF/jsp/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title><spring:message code="itemMenu.title"/></title>
</head>
<body>
<form:form method="post" action="search.html">
<div align="center" class="body">
<h2><spring:message code="itemMenu.title"/></h2>
상품명 검색<input type="text" name="itemName"/>
<input type="submit" value="검색"/><a href="create.html">상품 등록</a>
<table border="1">
	<tr class="header"><th align="center" width="80">상품ID</th>
	<th align="center" width="320">상품명</th>
	<th align="center" width="100">상품가격</th>
	<th align="center" width="80">편집</th>
	<th align="center" width="80">삭제</th>
	</tr>
	<c:forEach items="${itemList }" var="item">
	<tr class="record">
		<td align="center">${item.itemId }</td>
		<td align="left">${item.itemName }</td>
		<td align="right"><f:formatNumber type="currency" 
		currencySymbol="" value="${item.price }" minFractionDigits="0"/>원</td>
<!-- 										currency는 해당국가의 통화화폐 -->
<!-- 												소수점 단위를 안쓰는 경우 -->
		<td align="center"><a href="<c:url value='edit.html'>
		<c:param name='itemId' value='${item.itemId }'></c:param></c:url>"> 상품편집</a></td>
		<td align="center"><a href="<c:url value='confirm.html'><c:param name='itemId' value='${item.itemId }'>
		</c:param></c:url>">상품삭제</a></td>
	</c:forEach>
</table>
</div>
</form:form>
</body>
</html>