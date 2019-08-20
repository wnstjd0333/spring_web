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
��ǰ�� �˻�<input type="text" name="itemName"/>
<input type="submit" value="�˻�"/><a href="create.html">��ǰ ���</a>
<table border="1">
	<tr class="header"><th align="center" width="80">��ǰID</th>
	<th align="center" width="320">��ǰ��</th>
	<th align="center" width="100">��ǰ����</th>
	<th align="center" width="80">����</th>
	<th align="center" width="80">����</th>
	</tr>
	<c:forEach items="${itemList }" var="item">
	<tr class="record">
		<td align="center">${item.itemId }</td>
		<td align="left">${item.itemName }</td>
		<td align="right"><f:formatNumber type="currency" 
		currencySymbol="" value="${item.price }" minFractionDigits="0"/>��</td>
<!-- 										currency�� �ش籹���� ��ȭȭ�� -->
<!-- 												�Ҽ��� ������ �Ⱦ��� ��� -->
		<td align="center"><a href="<c:url value='edit.html'>
		<c:param name='itemId' value='${item.itemId }'></c:param></c:url>"> ��ǰ����</a></td>
		<td align="center"><a href="<c:url value='confirm.html'><c:param name='itemId' value='${item.itemId }'>
		</c:param></c:url>">��ǰ����</a></td>
	</c:forEach>
</table>
</div>
</form:form>
</body>
</html>