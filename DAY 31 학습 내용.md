# [ DAY 31 ]



- Web Client : HTML5, CSS3, JavaScript	-----> edu

- Web Server : Servlet, JSP, (JDBC), Spring FW, Mybatis FW

  ​						(Junit FW, Log4J) - Java	-----> sedu



[http://localhost:8000/sedu/first.jsp?gname=%EB%98%90%EC%B9%98](http://localhost:8000/sedu/first.jsp?gname=또치)

[http://localhost:8000/sedu/first.jsp?gname=%EB%93%80%ED%81%AC](http://localhost:8000/sedu/first.jsp?gname=듀크)

http://localhost:8000/sedu/firstone

http://localhost:8000/sedu/firstone?gname=고길동

http://localhost:8000/sedu/firstone?gname=둘리



## [ Servlet ]

- 1998년 가을에 발표된 기술

  CGI(Common Gateway Interface) - 웹의 표준, 구현언어 투명성

------> Fast CGI

------> Servlet



- Server Side Applet(Applet : 웹 브라우저에서 실행되는 Java 프로그램)

  

- 구현상의 특징

  1. HttpServlet 상속해야 한다.

     

  2. main() 구현하지 않는다. (main() 메서드를 담고 있는 메인 클래스는 톰캣이 내장)

     

  3. 수행하는 동안 호출되는 메서드가 정해져 있는데

     - 이 때 호출되는 메서드는 init(), service(), destroy(), doGet(), doPost() 등이다.

     - 하여 이 메서드들을 선택적으로 오버라이딩해서 구현한다.

       

  4. 서블릿에서 수행 결과를 출력 할 때

     - 요청해온 브라우저로의 출력(응답)

       - HttpServletResponse의 getWriter()를 호출해서 클라이언트로의 출력 스트링 객체 생성 해서 출력

     - 표준 출력 : System.out.println() 

       - 톰캣 서버의 콘솔창에 출력

         

  5. 서블릿이 수행하는데 필요한 데이터를 요청 보내오는 클라이언트로 부터 전달받을 수 있다.

     - 이 때 전달받는 데이터를 쿼리 문자열이라 한다.
     - HttpServletRequest 의 getParameter() /// String (값이 1개가 오기 때문)
     - 또는 getParameterValues() /// String[]를 사용한다. (값이 여러개가 오기 때문)



- 수행상의 특징

1. 서블릿을 요청할 때는 "/컨택스루트명/서블릿의매핑명" 형식의 URI를 사용한다.

   

2. 서블릿의 요청 방법

   - 서블릿을 요청하는 URL 문자열을 브러우저의 주소 필드에 입력해서 직접 요청 // GET방식

   - <a> 태그로 요청 // GET방식

   - ```
     <form> 태그를 통해서 요청 // GET방식이나 POST방식 사용가능
     ```



3. 서블릿 객체는 한 번 생성되면 서버가 종료되거나 컨택스트가 리로드 될 때까지 객체 상태를 유지한다.

   - 이것이 바로 서블릿이 속도가 빠른 이유이다.

     

4. 여러 클라이언트가 동일한 서블릿을 동시에 요청하면 하나의 서블릿 객체를 공유해서 수행한다.

   

5. 최초 요청시의 수행 흐름

   ```java
   init() -> service() -> doGet(), destroy()
       				-> doPost()
   ```

   

core 패키지 : FlowServlet(/flow)

​						MemberLocalServlet(/memberlocal) - GET



## [ Web Server ]

- Web 통신에서 서버역할을 수행하는 프로그램(Http Server)

- Web Server + Application Server = Web Application Server = WAS
- TOMCAT = WAS = COYOTE (웹서버) + Catalina (어플리케이션 서버)
  - 톰캣은 대표적인 무료 WAS이다.

[http://localhost:8000/sedu/query?p1=%EB%93%80%ED%81%AC&p2=24&p3=%EB%98%90%EC%B9%98&p3=%ED%9D%AC%EB%8F%99&p3=%EB%8F%84%EC%9A%B0%EB%84%88](http://localhost:8000/sedu/query?p1=듀크&p2=24&p3=또치&p3=희동&p3=도우너)



[http://localhost:8000/sedu/querytest?stname=%EB%93%80%ED%81%AC&pwd=12345&age=11&gender=%EB%82%A8%EC%9E%90&hobby=%EB%8F%85%EC%84%9C&color=%ED%8C%8C%EB%9E%91%EC%83%89&food=%EC%A7%9C%EC%9E%A5%EB%A9%B4&food=%ED%96%84%EB%B2%84%EA%B1%B0&food=%EB%8B%AD%EA%B0%95%EC%A0%95&op=%E3%84%B1%E3%84%B1%E3%84%B1&h_1=-%E3%85%85-&h_2=%3D%E3%85%85%3D](http://localhost:8000/sedu/querytest?stname=듀크&pwd=12345&age=11&gender=남자&hobby=독서&color=파랑색&food=짜장면&food=햄버거&food=닭강정&op=ㄱㄱㄱ&h_1=-ㅅ-&h_2=%3Dㅅ%3D)