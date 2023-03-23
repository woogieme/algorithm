<%@page import="model.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% String root = request.getContextPath(); %>
	<h1>SSAFY 대전5반 게시판</h1>
	<%
		MemberDto logInfo = (MemberDto) session.getAttribute("loginInfo");
		if(logInfo==null){ // 로그인 기록이 없을때 보여줄태그
	%>
	<form action="<%=root%>/member" method="POST">
		ID:<input type="text" name="userId">
		PW:<input type="password" name="userPw">
		<input type="hidden" name="action" value="login">
		<input type="submit"  value="LOGIN">
	
	</form>
	<%
		} else {
	%>
	
	로그인된 사용자군요 반갑습니다^^
	<%=logInfo.getUserName() %> (<%=logInfo.getUserId() %>)님 반갑습니다
	<a href="<%= root %>/member?action=logout">[로그아웃]</a>
	<%
		}
	%>
	<hr>
	
</body>
</html>