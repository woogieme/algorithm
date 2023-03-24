<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<%@include file="Header.jsp" %>
	<script type="text/javascript">
		alert('${deleteResult}개의 게시물이 삭제되었습니다.');
		location.href="${contextPath}/board?action=list";
	</script>
</body>
</html>