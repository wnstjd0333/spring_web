<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
function idOk(){
	opener.document.frm.id.value=document.frm.ID.value;
	opener.document.frm.idChecked.value="yes";
	self.close();
}
</script>
</head>
<body>
<h2 align="center">ID �ߺ� Ȯ��</h2>
<form action="../idcheck/idcheck.html" method="get" name="frm">
���̵� : <input type="text" name="ID" value="${ID }"/>
<input type="submit" value="�ߺ� �˻�"/><br/>
<c:if test="${DUP == 'YES' }">
	<script type="text/javascript">
		opener.document.frm.id.value="";
	</script>
	${ID }�� �̹� ��� ���Դϴ�.
</c:if>
<c:if test="${DUP != 'YES' }">
	${ID }�� ��� �����մϴ�.
	<input type="button" value="���" onClick="idOk()"/>
</c:if>
</form>
</body>
</html>








