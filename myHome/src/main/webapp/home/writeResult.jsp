<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
alert("새로운 이미지가 등록되었습니다.");
location.href="../write/writeList.html?SEQNO="+${param.SEQNO};
</script>
</body>
</html>