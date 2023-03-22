
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" %>
<%@page import="model.BoardDto"%>
<%
List<BoardDto> list = (List<BoardDto>)request.getAttribute("boardList");
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
		<%
			for(BoardDto b : list){
				%>
				
				<tr>
					<td><%= b.getBno() %></td>
					<td><%= b.getBtitle() %></td>
					<td><%= b.getBwriter() %></td>
					<td><%= b.getBwriteDate() %></td>
				</tr>
		<%
			}
		
		%>
	</table>
	<a href="<%=request.getContextPath() %>/board?action=wrtie">글쓰러 가기</a>
</body>
</html>