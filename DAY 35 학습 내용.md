# [ DAY 35 ]



## [ Servlet 에서의 DB 연동 ]

1. JDBC 드라이버 로딩(Class.forName())

2. DB 서버 접속(DriverManager.getConnection("jdbcurl", "계정", "암호"))

3. SQL 문을 수행하기 위한 Statement, PreparedStatement 객체를 생성

4. SELECT - executeQuery() : ResultSet(next(), getXXX())

   INSERT, DELETE, UPDATE, CREATE TABLE, DROP TABLE...

   -executeUpdate() : int(SQL 명령에 의해 변화된 행의 갯수)



visitorMain.html - 방명록 리스트 보기 ---> /visitordb(GET)

​								방명록 작성하기 ---> visitorForm.html ---> /visitordb(POST)



VisitorDBServlet(/visitordb)

GET - visitor 테이블의 데이터들을 모두 읽어 와서 테이블 형식으로 브라우저에 출력

POST - 전송되는 Query 문자열을 가지고 visitor 테이블에 저장



## [ JSP : JavaServer Pages ]

- jsp는 기본적으로 get과 post를 구분하지 않는다.

  - 기본적으로 service를 오버라이딩 하기 때문.

  

CGI -----> ASP, PHP

Servlet -----> JSP (실행시 Servlet으로 변경됨)

|                Servlet                 |                Jsp                |
| :------------------------------------: | :-------------------------------: |
|              1998년 출시               |            1999년 출시            |
| 문자열("") 내부에 오타는 찾아내기 힘듬 |      실행시 Servlet으로 변경      |
|              자바 + HTML               | HTML + JSP태그 + 약간의 Java 코드 |

--------------------------------------------------------------------------> MVC 개발패턴

​																							Servlet(요청) + JSP(응답)

​                                          

1. 내장 객체 - 9개

   - request, response, session, out, application, config, exception(예외가 발생해야지만 사용가능), page,  pageContext

     

2. JSP 태그

   ```jsp
   <%@ @> ----- 지시자 태그
      
   <%! %> ----- 선언문 태그
   
   <%= %> ----- 표현식 태그     
   
   <% %> ----- 수행문 태그
   
   <%-- --%> ----- 주석 태그
   
   ```

   

3. 액션 태그

   ```jsp
   <jsp:include />, <jsp:forward />, <jsp:param />,....
   ```

   

4. 커스텀 태그

   JSTL