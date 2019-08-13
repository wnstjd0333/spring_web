<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
				prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
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
</head>
<body>
<div id="header">
	<img alt="" src="../imgs/logo.gif">
</div>
<div id="wrap">
	<div id="aside">
		<fieldset>
			<c:choose>
				<c:when test="${sessionScope.loginUser != null }">
					<jsp:include page="logoutForm.jsp"/>
				</c:when>
		<%-- 유효성 검사 실패시 LoginController의 새로운 유저 생성(new User)전 parameter검사  --%>
				<c:when test="${HEADER != null }">
					<jsp:include page="${HEADER }"/>
				</c:when>
				<c:otherwise>
					<jsp:include page="../login/login.html"/>
				</c:otherwise>
			</c:choose>
			<p><a href="../home/intro.html?BODY=intro.jsp">소개</a><br/>
			<a href="">공지사항</a><br/>
			<a href="../home/bbsTemplate.html">자유게시판 쓰기</a><br/>
			<a href="../read/read.html">자유게시판 읽기</a><br/>
			<input type="button" value="게시판 읽기"
			onClick="location.href='../read/read.html'"/><br/>
			<a href="../product/open.html">상품정보 등록</a><br/>
			<a href="../read/product.html">상품목록 보기</a><br/>
			<a href="../cart/show.html">장바구니 보기</a><br/>
			<a href="../write/writeForm.html">이미지 게시판 쓰기/답글</a><br/>
			<%-- up로드에서는 라이브러리, 스프링객체 쓰는방법이 있다. --%>
			<a href="../write/writeList.html">이미지 게시판 읽기</a>
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
</body>
</html>
