<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="root" value="<%=request.getContextPath()%>"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>여기는 나만의 게시판입니</h1>
	<c:if test="${empty loginInfo }">
<form action="${root }/user/login" method="post">
	ID : <input type="text" name="userId">
	PW : <input type="text" name="userPw">
	<input type="submit" value="LOGIN">

</form>
</c:if>
	<c:if test="${not empty loginInfo }">
	회원님 반갑습니다 ${loginInfo.userName}(${loginInfo.userId})님 반갑습니다.
	<a href="${root}/user/logout">[로그아웃]</a>
	</c:if>
	
	<a href="${root }/write">게시글 작</a>
	<a href="${root }/list">게시글 리스트 </a>
</body>
</html>