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
	font-family: 'HYHeadLine', 'HY�߰��', 'HYPost';
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
		<%-- ��ȿ�� �˻� ���н� LoginController�� ���ο� ���� ����(new User)�� parameter�˻�  --%>
				<c:when test="${HEADER != null }">
					<jsp:include page="${HEADER }"/>
				</c:when>
				<c:otherwise>
					<jsp:include page="../login/login.html"/>
				</c:otherwise>
			</c:choose>
			<p><a href="../home/intro.html?BODY=intro.jsp">�Ұ�</a><br/>
			<a href="">��������</a><br/>
			<a href="../home/bbsTemplate.html">�����Խ��� ����</a><br/>
			<a href="../read/read.html">�����Խ��� �б�</a><br/>
			<input type="button" value="�Խ��� �б�"
			onClick="location.href='../read/read.html'"/><br/>
			<a href="../product/open.html">��ǰ���� ���</a><br/>
			<a href="../read/product.html">��ǰ��� ����</a><br/>
			<a href="../cart/show.html">��ٱ��� ����</a><br/>
			<a href="../write/writeForm.html">�̹��� �Խ��� ����/���</a><br/>
			<%-- up�ε忡���� ���̺귯��, ��������ü ���¹���� �ִ�. --%>
			<a href="../write/writeList.html">�̹��� �Խ��� �б�</a>
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
