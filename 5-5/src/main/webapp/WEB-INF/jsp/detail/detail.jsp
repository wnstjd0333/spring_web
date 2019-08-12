<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��ǰ �� ����</title>
<link rel="stylesheet" type="text/css" href="css/5-5.css">
</head>
<body>
<%@ include file="/WEB-INF/jsp/menu_header.jsp" %>
<div align="center" class="body">
<h2>��ǰ �� ȭ��</h2>
<table>
	<tr>
		<td><img alt="" src="../img/${item.pictureUrl }"></td>
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
					<td colspan="2" align="center" width="230">
					<form action="../cart/cartAdd.html">
						<input type="hidden" name="itemId" value="${item.itemId }"/>
						<table>
							<tr><td><select name="quantity">
								<option>1</option><option>2</option>
								<option>3</option><option>4</option>
								<option>5</option><option>6</option>
							</select>&nbsp;��</td>
							<td><input type="submit" value="īƮ�� ���"/></td>
							</tr>
							</table>
						</form>
					</td>
					<td width="160">${item.description }</td>
				</tr>
				<tr>
					<td colspan="2" align="center" width="240">
						<a href="../index/index.html">�� ������� ���ư���</a>
					</td>
				</tr>	
			</table>
		</td>
	</tr>
</table>
</div>
</body>
</html>