<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
글쓰기 완료되었습니다.<br>
<a href="<%=request.getContextPath()%>/board">[목록으로]</a>
<script type="text/javascript">
	alert('글쓰기가 완료되었습니다. 게시판으로 이동합니다.');
	location.href="<%=request.getContextPath()%>/board?action=list";
</script>
</body>
</html>