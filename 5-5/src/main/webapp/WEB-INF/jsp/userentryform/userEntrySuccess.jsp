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
<title>������ ��� �Ϸ� ȭ��</title>
</head>
<body>
<%@ include file="/WEB-INF/jsp/menu_header.jsp" %>
<h2>������ ��� �Ϸ�</h2>
<div align="center" class="body">
<b><font color="red">����� �Ϸ�Ǿ����ϴ�.</font></b>
<table>
	<tr height="40px"><td>�����ID</td><td>${user.userId }</td>
	</tr>
	<tr height="40px"><td>�н�����</td><td>${user.password }</td>
	</tr>
	<tr height="40px"><td>�̸�</td><td>${user.userName }</td>
	</tr>
	<tr height="40px"><td>�����ȣ</td><td>${user.postCode }</td>
	</tr>
	<tr height="40px"><td>�ּ�</td><td>${user.address }</td>
	</tr>
	<tr height="40px"><td>E-MAIL</td><td>${user.email }</td>
	</tr>
	<tr height="40px"><td>����</td><td>${user.job }</td>
	</tr>
	<tr height="40px"><td>�������</td><td>${user.birthday }</td>
	</tr>
</table>
<br/>
<a href="../index/index.html">�� ������� ���ư���</a>
<a href="../checkout/checkout.html">�� ����Ϸ� ����</a>
</div>
</body>
</html>