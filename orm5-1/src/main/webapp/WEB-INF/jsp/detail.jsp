<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>상품 상세 정보</title>
<link rel="stylesheet" type="text/css" href="css/5-2.css">
</head>
<body>
<div align="center" class="body">
<h2>상품 상세 화면</h2>
<table>
	<tr>
		<td><img alt="" src="img/${item.picture_url }"></td>
		<td align="center">
			<table>
				<tr height="50">
					<td width="80">상품명</td>
					<td width="160">${item.item_name }</td>
				</tr>
				<tr height="50">
					<td width="80">가격</td>
					<td width="160">${item.price }원</td>
				</tr>
				<tr height="50">
					<td width="80">설명</td>
					<td width="160">${item.description }</td>
				</tr>
				<tr>
					<td colspan="2" align="center" width="240">
						<a href="index.html">■ 목록으로 돌아가기</a>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</div>
</body>
</html>









