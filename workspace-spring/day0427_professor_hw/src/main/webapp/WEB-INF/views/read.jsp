<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="header_my.jsp" %>
제목 : ${board.btitle }<br>
작성자 : ${board.bwriter }<br>
내용 : ${board.bcontent}<br>
</body>
</html>