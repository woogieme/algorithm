<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
	alert(<%=request.getAttribute("deleteResult")%> "개의 게시물이 삭제되었습니다.");
	location.href="<%= root %>/board?action=list";
	</script>
</body>
</html>