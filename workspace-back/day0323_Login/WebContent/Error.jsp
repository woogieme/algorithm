<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/header.jsp" %>
글쓰기 에러났댄다 근데 이 페이지가 뜰일이 있을까 없을거 같은데 왜만들지 그래도 그냥 따라하는거지 뭐<br>
잠시후 다시 시도하거나 관리자에게 문의바랍니다</br>
</br>
<a href="<%=request.getAttribute("errorMsg")%>">실패</a></br>

<a href="<%= root%>">[메인 페이지로 돌아가기]</a>
</body>
</html>