<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="header_my.jsp"%>

	<form action="${root}/write" method="post">
		제목 : <input type="text" name="btitle"><br>
		내용 : <textarea rows="10" cols="10" name="bcontent"></textarea>
		<input type="submit" value="작성완료">
	</form>
	
</body>
</html>