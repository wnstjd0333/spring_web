<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title><spring:message code="itemAdd.title"/></title>
<!-- 						properties�� Ű�̸�  -->
</head>
<body>
<form:form modelAttribute="item" action="register.html"
	enctype="multipart/form-data" method="post">
<!-- 	�̹������� enctype�� �־���Ѵ�, �޼ҵ�� post -->
<div align="center" class="body">
	<h2><font color="green"><spring:message code="itemAdd.title"/>
	</font></h2>
	<table>
		<tr height="40px"><td>��ǰ��ȣ</td>
		<td><form:input path="itemId" cssClass="itemId" maxlength="20"/></td>
		<td><font color="red"><form:errors path="itemId"/></font></td>
		</tr>
		<tr height="40px"><td>��ǰ�̸�</td>
		<td><form:input path="itemName" cssClass="itemName"
			maxlength="20"/></td>
		<td><font color="red"><form:errors path="itemName"/>
		</font></td>
		</tr>
		<tr height="40px"><td>��ǰ����</td>
		<td><form:input path="price" cssClass="price" maxlength="6"/>&nbsp;��</td>
		<td><font color="red"><form:errors path="price"/></font></td>
		</tr>
		<tr height="40px"><td>����</td>
		<td><input type="file" name="picture"/></td>
		<td></td>
		</tr>
		<tr height="40px"><td>��ǰ����</td>
		<td><form:textarea path="description" cssClass="description"/></td>
		<td><font color="red"><form:errors path="description"/></font></td>
		</tr>
	</table><br/>
	<input type="submit" value="���"/>
	<input type="reset" value="����"/><br/><br/>
</div>
</form:form>
<a href="index.html">���ư���</a>
</body>
</html>