<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
</head>
<body>
	<%@include file="header_my.jsp" %>
	<table>
	<tr>
		<th>num</th>
		<th>title</th>
		<th>who</th>
	</tr>
		<c:forEach items="${boardList}" var="c">
		<tr>
			<td>${c.bno} </td>
			<td><a href="${root }/read?bno=${c.bno}">${c.btitle }</a>
			<td>${c.btitle } </td>
			<td>${c.bwriter } </td>
		</tr>
		</c:forEach>
		
	</table>
</body>
</html>