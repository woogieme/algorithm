<%@page import="model.BoardDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="/header.jsp" %>
	<table border="1">
		<tr>
			<th>no.</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
		<form action="<%=root %>/board" method="post">
			<input type= "hidden" name="action" value="deleteBoards">
			<%
				List<BoardDto> boardList = (List<BoardDto>) request.getAttribute("boardList");
				if (boardList != null && boardList.size()>0) {
					for (BoardDto b : boardList) {
						
			%>
			<tr>
				<td><%=b.getBno()%></td>
				<td><a href="<%=request.getContextPath()%>/board?action=read&bno=<%=b.getBno()%>"><%=b.getBtitle()%></a></td>
				<td><%=b.getBwriter()%></td>
				<td><%=b.getBwriteDate()%></td>
				<td><input type="checkbox" name="bnos" value="<%=b.getBno()%>"></td>
				
				
			</tr>
			<%
					}
			%>
			<input type="submit" value="삭제시작">
		</form>
		<%
				
			}else{
		%>
			<tr>
				<td colspan="5">작성된 게시글이 없습니다.</td>
			</tr>
		<%	} %>
	</table>
	<a href="<%=request.getContextPath()%>/board?action=write">글쓰러 가기</a>
</body>
</html>








