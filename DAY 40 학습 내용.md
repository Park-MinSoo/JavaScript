# [ DAY 40 ]



- JSP(자바)** -> 실행될때 서블릿으로 바뀐다. 필요한 만큼의 자바코드를 넣으면 돼서 진입장벽이 낮다.
  - sun 사는 ASP , PHP와 구별하기 위해 아래와 같은 기능을 추가했다.
    - Custom Tag : 필요한 기능의 태그를 직접 만들 수 있는 기능
      - Apache Open Group : JSTL(JavaServer Pages Standard Tag Library)을 만들었다.
      - 만들어진 태그들의 표준
      - core library , xml library(xml파싱을 하려면 복잡하지만 이것이 있으면 해준다.), sql library, fmt library
    - Action Tag : JSP가 제공하는 태그로 기능, 구현방법이 정해져 있는 태그



- **ASP(비주얼베이직), PHP** -> 실행될때 CGI으로 바뀐다(요청시마다 프로그램이 내렸다가 올렸다가 하고, 요청한만큼 메모리에 오른다는 단점이 있다.)



- JSTL은 HTML안에 필요한 만큼의 동적으로 처리해주는 언어인데. 서버라면 다른 프로그래밍 언어,  클라이언트라면 자바스크립트로 하면 된다.

  

JSP -----> 웹 페이지 -----> HTML + JSP 태그 + Java

​				규격화된 문서 -----> XML + JSP 태그 + Java

​													JSON + JSP 태그 + Java 

```jsp
오류 발생
<h1>
<form>
<br>
<%= %>	----> 표현식 태그 (out.println)
<%  %>	----> 수행문 태그 
<jsp:forward	/>,<forward	/>
<jsp:useBean	/>
<c:if />
```