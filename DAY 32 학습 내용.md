# [ DAY 32 ]

```html
name=duke&passwd=1234&age=&gender=female

request.getParameter("name") --> "duke"
request.getParameter("passwd") --> "1234"
request.getParameter("age") --> ""
request.getParameter("hobby") --> null
```



## [ 웹의 처리 구조 ]

- HTTP는 웹 상에서 정보를 주고 받을 수 있는 프로토콜이다 . HTTP 는 웹 클라이언트와 웹 서버 사이에 이루어지는 요청 과 응답 (request/response)에 대한 프로토콜로서 클라이언트인 웹 브라우저가 HTTP 를 통하여 서버로부터 웹 페이지 나 그림 정보를 요청하면, 서버는 이 요청에 응답하여 필요한 정보를 해당 사용자에게 전달하게 된다.

  

- HTTP 프로토콜은 ***Connection Oriented 와 Stateless 방식*** 으로 동작하는 프로토콜로서 신뢰성 있는 통신을 하면서도 처리 효율이라는 부분을 강조하였으므로 인터넷 환경에 가장 적합한 통신구조로 인정 받았다.
  - 접속상태를 계속 유지하는 것이 아니기 때문에 Stateless 방식을 채택 하는 것이다.



## [ HTTP 1.1에서 지원되는 요청 방식들 ]
|  요청방식  |                            설 명                             |
| :--------: | :----------------------------------------------------------: |
| ***GET***  | URI에 지정된 파일을 얻고자 할 때 사용되는 요청 방식으로 디폴트 방식이다. name=value로 구성되는 간단한 데이터(Query 문자열)를 URI 뒤에 추가하여 전달하면서 요청하고자 하는 경우에도 사용된다. http://localhost:8080/test.jsp?productid=00001 |
|    HEAD    | GET과 동일하나 바디 내용은 받지 않고 HTTP 헤더 정보만 받는다. |
| ***POST*** | 원하는 방식으로 인코딩 된 데이터를 요청 바디에 포함하여 전송하면서 파일을 요청하고자 하는 경우 사용된다. Query 문자열 전달시의 GET 방식을 보완한 요청 방식이다. |
|  OPTIONS   | 요청 URI에 대하여 허용되는 통신 옵션을 알고자 할 때 사용된다. |
|   DELETE   |       서버에서 요청 URI에 지정된 자원을 지울 수 있다.        |
|    PUT     | 파일을 업로드할 때 사용된다. 그러나 일반적으로 사용되는 파일 업로드는 POST 방식을 사용하고 있고, PUT은 아직 많이 사용되지 않는다. |



## [ Servlet 프로그래밍 ]

- 이 기술은 1998 년에 발표된 기술로서 이 기술 이전에 CGI 라는 기술이 사용되고 있었다 . CGI 는 요청이 있을 때마다 새로운 프로세스가 생성되어 응답하는 데 비해 , Java Servlet은 요청마다 프로세스보다 가벼운 스레드 기반으로 응답하므로 보다 가볍게 클라이언트 요청 처리할 수 있다. 또한, Java Servlet 은 Java 로 구현되므로 다양한 플랫폼에서 동작 가능하다.

  

- 웹 클라이언트로부터의 수행 요청으로 생성된 Servlet 의 객체는 수행이 종료되어 응답된 후에도 객체 상태를 계속 유지하면서 다음 요청에 대하여 바로 수행될 수 있는 상태를 유지한다 .

  

- 하나의 Servlet 을 여러 클라이언트가 동시 요청했을 때 하나의 Servlet 객체를 공유하여 다중 스레드 기반에서 처리되므로 응답 성능을 향상시킬 수 있다.



- Servlet의 등록과 매핑

```java
<servlet>
	<servlet-name>abc</servlet-name>
	<servlet-class>FirstServlet</servlet-class>
</servlet>
<servlet-mapping>
	<servlet-name>abc</servlet-name>
	<url-pattern>/hello</url-pattern>
</servlet-mapping>
```



- 요청 및 응답 객체 생성

  - 웹클라이언트 로부터 Servlet 수행 요청이 전달되면, Servlet 컨테이너는 클라이언트로부터 전달된 요청 정보를 가지고 HttpServletRequest 객체와 HttpServletResponse 객체를 생성하여 Servlet 의 doGet() 또는 doPost() 메서드 호출시 아규먼트로 전달한다.

    

  - HttpServletRequest 객체는 클라이언트에서 전달되는 다양한 요청 정보를 Servlet에 전달하는 기능으로 사용되며, HttpServletResponse 객체는 클라이언트로의 응답에 사용되는 객체이다.

![image-20200117173112465](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200117173112465.png)

![image-20200117173115790](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200117173115790.png)