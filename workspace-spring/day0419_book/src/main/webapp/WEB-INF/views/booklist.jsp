<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책목록</title>
</head>
<body>
	<form action="${root}/deleteAll" method="post">
		<table>
			<tr>
				<th>no</th>
				<th>제목</th>
				<th>저자</th>
				<th>가격</th>
				<th>삭제</th>
				<th>멀티 삭제</th>
			</tr>
			<c:forEach var="b" items="${books}">
				<tr>
					<td>${b.bno}</td>
					<td>${b.title}</td>
					<td>${b.writer}</td>
					<td>${b.price}</td>
					<td><a href="${root}/delete?bno=${b.bno}">[삭제]</a></td>
					<td><input type="checkbox" name="bno" value="${b.bno}"></td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="멀티삭제">
	</form>
	<a href="${root}/write">[글쓰기]</a>
</body>
</html>


