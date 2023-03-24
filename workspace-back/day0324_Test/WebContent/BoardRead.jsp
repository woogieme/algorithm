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
<%@include file="Header.jsp" %>

제목 : ${boardDto.btitle}<br>
작성자 :${boardDto.bwriter}<br>
작성일시 :${boardDto.bwriteDate}<br>
내용 : ${boardDto.bcontent}<br>

<a href="${contextPath}/board?action=list">목록으로</a>
<a href="${contextPath}/board?action=modify">수정</a>
<a href="${contextPath}/board?action=delete">삭제</a>
</body>
</html>