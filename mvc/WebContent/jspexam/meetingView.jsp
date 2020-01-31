<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.vo.MeetingVO, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	td {
		border-bottom : 1px dotted green;
	}
	tr:hover {
		background-color : pink;
		font-weight : bold;
	}
	td:nth-child(3) {
		width : 400px;
	}
</style>
</head>
<body>
<%
	List<MeetingVO> list = (List<MeetingVO>)request.getAttribute("list");
    if (list != null) {
%>
    	<h2>미팅 스케쥴</h2><hr>
    	<table>    
<%	
    	for(MeetingVO vo : list) { 	   
%>
			<tr>
				<td><%= vo.getName() %></td>
				<td><%= vo.getTitle() %></td>
				<td><%= vo.getMeetingDate() %></td>
				<td><a href="/mvc/meeting?action=delete&id=<%= vo.getId() %>">
				<img src="/mvc/images/delete.png" height="20"></a></td>
			</tr>
<%
    	}
%>
    	</table>
<%
    } else {
%>
		<h2>${msg}</h2>
<%
    }
%>
<hr>
<a href="/mvc/htmlexam/meetingForm.html ">미팅 홈 화면으로 가기</a>

</body>
</html>



