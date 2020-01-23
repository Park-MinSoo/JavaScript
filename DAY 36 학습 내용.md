# [ DAY 36 ]



Day35 이어서...

```jsp
<%@ page 속성명="속성값" ......%> : page 지시자 태그
	language, comtentType, page Encoding, errorPage, isErrorPage, import, session, buffer, isELIgored .....

<%@ include file="포함하려는 대상 파일의 로컬 URL"%> : include 지시자 태그
포함하는 위치 : 이 지시자 태그가 사용된 위치
포함하는 시기 : JSP를 Servlet으로 변환하기 전
포함하는 대상 : html, jsp, jspf (여기서 f는 fragment 즉, 조각)
ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
 <%-- include는 수행 시키고 결과를 포함하라는 뜻이다. include는 변환시 일어나게 된다.
    
	a.jsp	b.jsp
    
   include action 태그로 : 2개의 서블릿 ---> 동적 포함 include 왜냐면 요청시마다 일어나게 되니까,
										  수행자체는 개별적으로 해서  수행 결과를 포함시키 겠다.
                                         ★ 즉, 수행결과만 포함을 시킨다!!
                                              
   include 지시자 태그로 : 1개의 서블릿 ---> 정적 포함 incluede 
       									★ 즉, 소스를 그대로 가져와서 표현한다!!

```



- xxxVO

  - Value Object 

  - 값을 보관하는 용도의 객체

    

- xxxDAO

  - Data Access Object

  - DB 연동기능(JDBC)을 지원하는 객체

    

- xxxService(xxxBiz)

  - Service Object
  - 이런 저런 서비스 로직을 지원하는 객체