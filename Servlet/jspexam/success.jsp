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
%>에 당첨!! 추카추카~ </h1>
<img src ="/edu/images/sun.png">

</body>
</html>