# [ DAY 33 ]



## [ 요청 재지정 ]

- 요청 재지정이란 클라이언트에서 요청한 페이지 대신 다른 페이지를 클라이언트가 보게 되는 기능으로서 redirect 방법과 forward 방법으로 나뉜다.

  - redirect : HttpServletResponse 의 sendRedirect() 메서드를 사용한다.

    - 동일한 요청상에서 다른 자원에 요청을 넘겨서 대신 응답하게 함
    - 동일한 서버의 동일 웹 어플리케이션에 존재하는 대상만 가능
    - 브라우저의 주소필드의 URL이 바뀌지 않음
    - 두 자원이 HttpServletRequest 객체 공유

    ![image-20200120092540931](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200120092540931.png)

  - forward : RequestDispatcher 의 forward() 메서드를 사용한다.

    - 다른 자원을 다시 요청하여 응답하게 함
    - Web 상의 모든 페이지로 요청재지정 가능
    - 브라우저의 주소필드의 URL이 바뀜
    - 재지정 대상에 대한 요청 자체를 브라우저가 하게 됨
    - 두 자원이 HttpServletRequest 객체를 공유하지 않음

    ![image-20200120092555885](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200120092555885.png)



## [ 용어 정리 ]

- edu 나 sedu
  - OS 한테는 : 그냥 폴더
  - Eclipse 한테는 : Web Project
  - Tomcat 한테는 : Context(Context Path : /edu, /sedu, /ContextName)
  - Developer 한테는 : Web Application





## [ 상태정보 유지 기술 ]

- 웹 브라우저에서 웹 서버에 정보를 요청할 때 이전 접속시의 결과물(상태정보)를 일정시간 동안 유지하는 것을 상태정보 유지라고 한다. 상태정보 유지 방법은 여러가지가 있다.

  

  - Cookie를 이용한 방법

    - Cookie란 웹서버가 저장하는 네임벨류쌍의 데이터

    - 장점 : 각종 클라이언트 안에 보관하기에 서버가 부담이 없다.

    - 단점 : 클라이언트가 보관하는것 이기 때문에 보안성이나, 변질 위험이있다.

    - 저장 가능한 크기나, 갯수, 유지시간(최대 3년) 등 제한적이다.

      

  - HttpSession 객체를 이용한 방법

    - 상태 정보는 객체로 만들어서 서버에 보관한다.
    - 서버에 보관하기 때문에 OverHead 가능성이 있다.
    - 기본적으로 설정되어 있는 Inactive Interval Time은 30분이다.
    - 상태 정보가 더 이상 필요 없으면 삭제 가능하다.
    - session.invalidate()를 이용하여 HttpSession 객체 자체를 강제로 삭제하는 방법도 있다.

    

  - URL 문자열 뒤에 추가하는 방법

    

  - ```javascript
    <form> 태그의 hidden 타입을 사용하는 방법
    ```

    

