<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3 align="center">�Խñ� ���</h3>
<table border="1">
	<tr><td width="40">�۹�ȣ</td><td width="300">������</td>
		<td width="80">�ۼ���</td><td width="90">�ۼ���</td></tr>
	<c:forEach var="cnt" items="${BBS_LIST }">
	<tr><td>${cnt.seqno }</td>
		<td><a href="../read/readDetail.html?SEQNO=${cnt.seqno}">${cnt.title }</a></td>
		<td>${cnt.id }</td>
		<td>${cnt.bbs_date }</td></tr>
	</c:forEach>
</table>
<c:forEach var="page" begin="1" end="${COUNT }">
<a href="../read/read.html?pageNo=${page }">${page }</a>
</c:forEach>
</body>
</html>
