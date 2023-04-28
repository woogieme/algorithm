<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="header_my.jsp" %>
<br>
제목 : ${board.btitle }<br>
작성자 : ${board.bwriter }<br>
내용 : ${board.bcontent}<br>


<form action= "${root }/comment-register?bno=${board.bno}" method="post">
	댓글쓸 사람 : ${loginInfo.userName}<br>
	내용 : <input type="text" name="ccontent">
	<input type="submit" value="댓글작성">
</form>
<div>
<c:forEach items="${commentList}" var="item" >
	${item.cwriter}<br>
	${item.ccontent }<br>

</c:forEach>
</div>
</body>
</html>