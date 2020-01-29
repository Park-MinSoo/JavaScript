<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.vo.LottoVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	LottoVO vo = (LottoVO)request.getAttribute("lotto");
%>
<h1><%= vo.getMsg() %></h1>
<%
	if(vo.getImgUrl() != null) {
%>
	<img src="<%= vo.getImgUrl() %> "width="100"><br><br>
<%
	}
%>
<%
	if(vo.isLinkDisplay() == true) {
%>
	<a href="<%= request.getHeader("referer") %> ">로또응모</a>
<%
	}
%>
</body>
</html>