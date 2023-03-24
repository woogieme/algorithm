<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>
</head>
<body>
<%@ include file="Header.jsp" %>
<h3>서비스 실행 중 장애가 발생하였습니다.</h3>
잠시 후 다시 시도하거나 관리자에게 문의 바랍니다.<br>
에러메세지 : ${requestScope.errorMsg}<br>
<a href="${contextPath}/">[메인 페이지로 돌아가기]</a>
</body>
</html>