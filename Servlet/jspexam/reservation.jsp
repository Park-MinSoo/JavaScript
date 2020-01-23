<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDate, java.time.LocalDateTime, java.time.format.DateTimeFormatter" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
		request.setCharacterEncoding("UTF-8"); 
		String reservateDay = request.getParameter("gdate");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");	
		String option = request.getParameter("sub");
%>		

<h1><%= request.getParameter("gname")%>님의 예약내용</h1>
<hr>
<ul>
	<li>룸 : <%=request.getParameter("groom")%></li>

	<li>추가 요청 사항: 
<% 		if (option == null){
	out.print("없음");

	}
	else	
	out.print(request.getParameter("sub"));
%>
</li>
	
	<li>예약날짜 : <%=LocalDate.parse(reservateDay).format(formatter)%></li>
</ul>
<a href='/sedu/html/reservation.html'>예약입력화면으로</a>
</body>
</html>