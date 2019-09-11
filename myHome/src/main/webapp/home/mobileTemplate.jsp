<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
				prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<meta name="viewport" 
	content="width=device-width,initial-scale=1">
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>	
<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<link rel="stylesheet" 
href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">

<style type="text/css">
body {
	font-family: 'HYHeadLine', 'HY견고딕', 'HYPost';
	font-size : 18px;
}
#join {
	padding-left : 30px;
	font-size : 12px;
}
#header {
	width:800px;	margin:0 auto; background:red;
}
#wrap {
	width:800px; height:500px; margin:a auto;
}
#aside {
	width:200px; height:500px; float:left; 
	
}
#content{
	width:600px; height:500px; float:right;
	background-image:url(imgs/5.jpg);
	background-size:600px 330px;
}
fieldset {
	height:90%; background:orange;
}
</style>
<script type="text/javascript">
function workingClock(){
	var days=["일","월","화","수","목","금","토"];
	var today = new Date();
	var year = today.getFullYear();
	var month = today.getMonth()+1;
	if(month < 10) month="0"+month;
	var date = today.getDate();
	if(date<10) date="0"+date;
	var index = today.getDay();
	var day = days[index];
	var hour = today.getHours();
	var min = today.getMinutes();
	if(min < 10) min="0"+min;
	var sec = today.getSeconds();
	if(sec < 10) sec="0"+sec;
	var str=year+"-"+month+"-"+date+" "+day+" "+hour+
		":"+min+":"+sec;
	document.getElementById("clock").innerHTML=str;
}
function startClock(){
	setInterval(workingClock, 1000);
}
</script>
</head>
<body onload="startClock()">
<div data-role="page">
<div data-role="header">
	<div id="header">
		<img alt="" src="../imgs/logo.gif">
	</div>
</div>
<div data-role="content">
<div id="wrap">
	<div id="aside">
		<fieldset>
			<c:choose>
				<c:when test="${sessionScope.loginUser != null }">
					<jsp:include page="logoutForm.jsp"/>
				</c:when>
				<c:when test="${HEADER != null }">
					<jsp:include page="${HEADER }"/>
				</c:when>
				<c:otherwise>
					<jsp:include page="../login/login.html"/>
				</c:otherwise>
			</c:choose>
		<ul data-role="listview" data-inset="true">
			<li data-theme="b"><a href="../home/intro.html?BODY=intro.jsp">소개</a>
			</li>
			<li data-theme="b"><a href="">공지사항</a></li>
			<li data-theme="b"><a href="../home/bbsTemplate.html">자유게시판 쓰기</a></li>
			<li data-theme="b"><a href="../read/read.html">자유게시판 읽기</a></li>
			<li data-theme="b"><input type="button" value="게시판 읽기"
			onClick="location.href='../read/read.html'"/></li>
			<li data-theme="b"><a href="../product/open.html">상품정보 등록</a></li>
			<li data-theme="b"><a href="../read/product.html">상품목록 보기</a></li>
			<li data-theme="b"><a href="../cart/show.html">장바구니 보기</a></li>
			<li data-theme="b"><a href="../write/writeForm.html">이미지 게시판 쓰기/답글</a></li>
			<li data-theme="b"><a href="../write/writeList.html">이미지 게시판 읽기</a></li>
		</ul>
		</fieldset>
	</div>
	<div id="content">
		<c:choose>
			<c:when test="${BODY != null }">
				<jsp:include page="${BODY }"/>
			</c:when>
			<c:otherwise>
				<jsp:include page="front.jsp"/>
			</c:otherwise>
		</c:choose>
	</div>
</div>
</div>
<div data-role="footer">
	<div id="clock"></div>
</div>
</div>
</body>
</html>









