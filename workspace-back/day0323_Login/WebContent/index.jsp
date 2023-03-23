<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인화면</title>
</head>
<body>
<%@include file="/header.jsp" %>
	<a href="<%=request.getContextPath()%>/board?action=list">[게시판 입장]</a>
	<a href="<%=request.getContextPath()%>/board">[게시판 입장]</a>
</body>
</html>