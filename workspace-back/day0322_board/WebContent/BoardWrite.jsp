<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String root =request.getContextPath();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=root%>/board" method="POST">
		제목<input type="text" name="aaa"> <br>
		작성자 : <input type="text" name="bbb"> <br>
		내용<textarea rows="10" cols= "30" name="ccc"></textarea>
		<input type="hidden" name="action" value="write">
		<input type="submit" value="작성완료">
	</form>
</body>
</html>