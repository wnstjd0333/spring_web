<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��ǰ �� ����</title>
<link rel="stylesheet" type="text/css" href="css/5-2.css">
</head>
<body>
<div align="center" class="body">
<h2>��ǰ �� ȭ��</h2>
<table>
	<tr>
		<td><img alt="" src="img/${item.pictureUrl }"></td>
		<td align="center">
			<table>
				<tr height="50">
					<td width="80">��ǰ��</td>
					<td width="160">${item.itemName }</td>
				</tr>
				<tr height="50">
					<td width="80">����</td>
					<td width="160">${item.price }��</td>
				</tr>
				<tr height="50">
					<td width="80">����</td>
					<td width="160">${item.description }</td>
				</tr>
				<tr>
					<td colspan="2" align="center" width="240">
						<a href="index.html">�� ������� ���ư���</a>
					</td>
				</tr>	
			</table>
		</td>
	</tr>
</table>
</div>
</body>
</html>