<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="spring" 
		uri="http://www.springframework.org/tags" %>    
<%@ taglib prefix="form" 
		uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
function validate(form){
	if(form.password.value == ""){
		alert("��ȣ�� �Է��ϼ���."); return false;
	}
	var result = confirm("������ �����Ͻðڽ��ϱ�?");
	if(result == false) return false;
}
</script>
<form:form modelAttribute="writing" action="../write/deleteDo.html" method="post" onSubmit="return validate(this)">
<form:hidden path="writing_id" value="${writing.writing_id }"/>
<table width="100%" border="1">
	<tr><td>������</td><td>${writing.title }</td></tr>
	<tr><td>�ۼ���</td><td>${writing.writer_name }</td></tr>
	<tr><td>�̸���</td><td>${writing.email }</td></tr>
	<tr><td>��ȣ</td><td><form:password path="password" size="20"/></td></tr>
	<tr><td>�̹���</td><td><img alt="" width="350" border="0" src="${pageContext.request.contextPath }/upload/${writing.image_name}"></td></tr>
	<tr><td colspan="2"><input type="submit" value="�� ��"/>
	<input type="button" value="�� ��" onClick="javascript:history.go(-1)"/></td></tr>
	</table>
</form:form>
</body>
</html>