<%@page import="model.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<c:set var="contextPath" value="<%=request.getContextPath() %>"/>
	<h1>SSAFY 대전5반 게시판</h1>
	
	<c:if test="${empty sessionScope.loginInfo}">
			<form action="${contextPath}/member" method="post">
				ID:<input type="text" name="userId"> 
				PW:<input type="password" name="userPw"> 
				<input type="hidden" name="action" value="login">
				<input type="submit" value="LOGIN">
			</form>
	</c:if>
	
	<c:if test="${not empty sessionScope.loginInfo}">
			로그인된 사용자군요! 
			${sessionScope.loginInfo.userName} (${sessionScope.loginInfo.userId})님 반갑습니당*^^*
			<a href="${contextPath}/member?action=logout">[로그아웃]</a>
	</c:if>
	<hr>
