<%@page import="model.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글상세화면</title>
</head>
<body>
<%
	BoardDto boardDto = (BoardDto) request.getAttribute("boardDto");
%>
제목 : <%=boardDto.getBtitle()%><br>
작성자 : <%=boardDto.getBwriter()%><br>
작성일시 : <%=boardDto.getBwriteDate()%><br>
내용 : <%=boardDto.getBcontent()%><br>

<a href="<%=request.getContextPath()%>/board?action=list">목록으로</a>
<a href="<%=request.getContextPath()%>/board?action=modify">수정</a>
<a href="<%=request.getContextPath()%>/board?action=delete">삭제</a>
</body>
</html>