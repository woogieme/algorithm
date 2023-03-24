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
	<%@include file="Header.jsp"%>
	<table border="1">
		<tr>
			<th>삭제여부</th>
			<th>no.</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
		<c:if test="${not empty requestScope.boardList}">
			<form action="${contextPath}/board" method="post">
				<input type="submit" value="체크 모두 삭제">
				<input type="hidden" name="action" value="deleteBoards">
			<c:forEach items="${requestScope.boardList}" var="b">
				<tr>
					<td><input type="checkbox" name="bnos" value="${b.bno}"/></td>
					<td>${b.bno}</td>
					<td><a href="${contextPath}/board?action=read&bno=${b.bno}">${b.btitle}</a></td>
					<td>${b.bwriter}</td>
					<td>${b.bwriteDate}</td>
				</tr>
			</c:forEach>
			</form>
		</c:if>

		<c:if test="${empty requestScope.boardList}">
			<tr>
				<td colspan="5">작성된 게시글이 없습니다.</td>
			</tr>
		</c:if>
	</table>
	<a href="${contextPath}/board?action=write">글쓰러 가기</a>
</body>
</html>








