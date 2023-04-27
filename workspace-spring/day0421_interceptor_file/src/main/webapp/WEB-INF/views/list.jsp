<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
</head>
<body>
	<%@include file="header.jsp" %>
	<table>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
		<c:forEach items="${boardList}" var="b">
			<tr>
				<td>${b.bno}</td>
				<td>${b.btitle}</td>
				<td>${b.bwriter}</td>
				<td>${b.bwriteDate}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>