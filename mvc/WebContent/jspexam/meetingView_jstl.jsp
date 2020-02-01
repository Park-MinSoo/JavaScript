<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.vo.MeetingVO, java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<c:if test="${!empty requestScope.list}" >

    	<h2>미팅 스케쥴(JSTL)</h2><hr>
    	<table>    
	
<c:forEach var="vo" items="${requestScope.list}">
			<tr>
				<td>${ vo.name}</td>
				<td>${ vo.title}</td>
				<td>${ vo.meetingDate}</td>
				<td><a href="/mvc/meeting?action=delete&id=${ vo.id}">
				<img src="/mvc/images/delete.png" height="20"></a></td>
			</tr>
</c:forEach>
    	</table>
  </c:if>  	
<c:if test="${empty requestScope.list}">
		<h2>${msg}</h2>
</c:if>
<hr>
<a href="/mvc/htmlexam/meetingForm.html ">미팅 홈 화면으로 가기</a>

</body>
</html>



