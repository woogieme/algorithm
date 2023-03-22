<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	String root = request.getContextPath();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인화면</title>
</head>
<body>
	<a href="<%= root %>/board?action=list">[게시판 입장]</a>
	<a href="<%= root %>/board">[게시판 입장]</a>
	<a href="<%= root %>/board?action=one">[게시판 입장]</a>
	<a href="<%= root %>/board?action=write">[글 쓰기]</a>
	
</body>
</html>