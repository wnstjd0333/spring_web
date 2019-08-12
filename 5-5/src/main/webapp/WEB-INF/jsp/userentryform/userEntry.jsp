<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" 
	prefix="spring" %>    
<%@ taglib uri="http://www.springframework.org/tags/form" 
	prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>����� ��� ȭ��</title>
</head>
<body>
<%@ include file="/WEB-INF/jsp/menu_header.jsp" %>
<h2>����� ��� ȭ��</h2>
<div align="center" class="body">
<form:form modelAttribute="user" method="post" 
			action="../userentryform/userEntry.html">
<spring:hasBindErrors name="user">
	<font color="red">
		<c:forEach var="error" items="${errors.globalErrors }">
			<spring:message code="${error.code }"/>
		</c:forEach>
	</font>
</spring:hasBindErrors>
<table>
	<tr height="40px">
		<td>�����ID</td>
		<td><form:input path="userId" maxLength="20"
			cssClass="userId"/>
			<font color="red"><form:errors path="userId"/></font>
		</td>
	</tr>
	<tr height="40px">
		<td>�н�����</td>
		<td><form:password path="password" maxLength="20"
			cssClass="password"/>
			<font color="red"><form:errors path="password"/></font>
		</td>
	</tr>
	<tr height="40px">
		<td>�̸�</td>
		<td><form:input path="userName" maxLength="20"
			cssClass="userName"/>
			<font color="red"><form:errors path="userName"/></font>
		</td>
	</tr>
	<tr height="40px">
		<td>�����ȣ</td>
		<td><form:input path="postCode" maxLength="8"
			cssClass="postCode"/>
			<font color="red"><form:errors path="postCode"/></font>
		</td>
	</tr>
	<tr height="40px">
		<td>�ּ�</td>
		<td><form:input path="address" maxLength="50"
			cssClass="address"/>
			<font color="red"><form:errors path="address"/></font>
		</td>
	</tr>
	<tr height="40px">
		<td>E-MAIL</td>
		<td><form:input path="email" maxLength="50"
			cssClass="email"/>
			<font color="red"><form:errors path="email"/></font>
		</td>
	</tr>
	<tr height="40px">
		<td>����</td>
		<td><form:select path="job" cssClass="jobs">
			<form:option value="ȸ���" label="ȸ���"/>
			<form:option value="�ֺ�" label="�ֺ�"/>
			<form:option value="�л�" label="�л�"/>
			<form:option value="��Ÿ" label="��Ÿ"/>
		</form:select>
		</td>
	</tr>
	<tr height="40px">
		<td>�������</td>
		<td><form:input path="birthday" maxLength="10"
			cssClass="birthday"/>
			<font color="red"><form:errors path="birthday"/></font>
		</td>
	</tr>
</table>
<table>
	<tr>
		<td height="40px" align="center">
		<input type="submit" value="���" name="btnSubmit"/>
		</td>
		<td height="40px" align="center">
		<input type="reset" value="����" name="btnReset"/>
		</td>
	</tr>
</table>
</form:form>
<a href="../index/index.html">�� ������� ���ư���</a>
</div>
</body>
</html>










