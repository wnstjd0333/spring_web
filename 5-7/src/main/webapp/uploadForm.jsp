<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	if(form.title.value=="") {
		alert("������ �Է��ϼ���.");		return false;
	}	
	if(form.writer_name.value==""){
		alert("�г����� �Է��ϼ���.");	return false;
	}
	if(form.password.value==""){
		alert("��ȣ�� �Է��ϼ���.");		return false;
	}
	if(form.imagename.value==""){
		alert("�̹����� �����ϼ���.");	return false;
	}
	if(form.content.value==""){
		alert("�� ������ �Է��ϼ���.");	return false;
	}
	var result = confirm("������ �����Ͻðڽ��ϱ�?");
	if(result == false)		return false;
}
</script>
<form:form modelAttribute="writing" action="../upload/write.html"
	method="post" enctype="multipart/form-data">
<table border="1" width="100%">
<tr><td>������</td><td><form:input path="title" size="40"/>
</td></tr>
<tr><td>�г���</td><td><form:input path="writer_name" size="20"/>
</td></tr>
<tr><td>�̸���</td><td><form:input path="email" size="20"/>
</td></tr>
<tr><td>��ȣ</td><td><form:password path="password" size="20"/>
</td></tr>
<tr><td>�̹���</td><td><input type="file" name="image">
</td></tr>
<tr><td>�۳���</td><td><form:textarea rows="8" cols="40" 
						path="content"></form:textarea>
</td></tr>
<tr><td colspan="2"><input type="submit" value="�� ��"/></td></tr>
</table>
</form:form>
</body>
</html>
















