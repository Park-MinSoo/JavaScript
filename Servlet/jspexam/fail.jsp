<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
java.time.LocalDateTime ctime = java.time.LocalDateTime.now();
java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("hh시 mm분");	
%>

<h1 style="color:red" > <%= 	
ctime.format(formatter)
%>에 당첨 실패!! 아쉽아쉽~ </h1>
<img src ="/edu/images/sad.gif">
<br>
<a href="/sedu/html/lottoForm.html">응모화면으로</a>
</body>
</html>