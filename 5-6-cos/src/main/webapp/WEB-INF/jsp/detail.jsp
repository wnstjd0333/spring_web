<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title><spring:message code="itemDelete.title"/></title>
</head>
<body>
<form:form modelAttribute="item" action="delete.html">
<form:hidden path="itemId"/>
<div align="center" class="body">
<h2><font color="green"><spring:message code="itemDelete.title"/>
</font></h2>
	<table>
		<tr height="40px"><td>��ǰ��</td><td><form:input path="itemName" cssClass="itemName" disabled="true"/></td>
		</tr>
		<tr height="40px"><td>��ǰ����</td><td><form:input path="price" cssClass="price" disabled="true"/>&nbsp;��</td>
		</tr>
		<tr height="40px"><td>����</td><td><img alt="" 
		src="${pageContext.request.contextPath }/upload/${imageName }" width="210" height="240"><c:url value='image.html'><c:param name='itemId' value='${item.itemId }'></c:param></c:url>" width="210" height="240">
		</tr>
		<tr height="40px"><td>��ǰ����</td><td><form:textarea path="description" cssClass="description" disabled="true"/></td>
		</tr>
	</table><br/>
	<input type="submit" value="����"/><br/>
</div>
</form:form>
<a href="index.html">���ư���</a>
</body>
</html>