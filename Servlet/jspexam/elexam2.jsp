<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 테스트</title>
</head>
<body>
<h2>EL의 Query 문자열 추출</h2>
<hr>
전달된 메시지의 존재 여부 : ${ !empty param.message }<hr><!-- empty 연산자는 비어있으면~ 이라는 뜻이다. 즉 null이면~ -->
전달된 메시지의 내용은 ${param.message} 입니다.<br><!--  EL은 null 값이면 아무것도 표현이 안된다. -->
전달된 메시지의 내용은 ${param["message"]} 입니다.<br>
전달된 메시지의 내용은 <%= request.getParameter("message") %>입니다.<br>
</body>
</html>