<%@page import="model.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
BoardDto one = (BoardDto) request.getAttribute("boardOne");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<table border="1">
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
				<tr>
					<td><%=one.getBno() %></td>
					<td><%=one.getBtitle() %></td>
					<td><%=one.getBwriter() %></td>
					<td><%=one.getBwriteDate() %></td>
				</tr>
	</table>
</body>
</html>