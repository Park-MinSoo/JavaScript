# [ DAY 37 ]



## [ 객체 공유 ]

- 객체의 스코프란 객체가 생성되어 유지되는 기간을 의미하며 Page Scope, Request Scope, Session Scope 그리고 Application Scope로 구성된다.

  

- Page Scope

  - Servlet 또는 JSP가 수행된느 동안만 유효한 객체가 된다.

    

- Request Scope

  - Web 클라이언트로 부터의 요청이 끝날 때까지 유효한 객체가 된다.

  - HttpServletRequest 객체에 객체를 보관한다.

    

- Session Scope

  - 요청을 보내온 Web 클라이언트가 기동되어 있는 동안 유효한 객체가 된다.

  - HttpSession 객체에 객체를 보관한다.

    

- Application Scope

  - 서버가 기동되어 있는 동안 유효한 객체가 된다.
  - ServletContext 객체에 객체를 보관한다.



## [ 모델 ]

- 다양한 비즈니스 로직(SERVICE, BIZ), DB 연동 로직(DAO) 그리고 처리 결과를 저장(VO, DTO)하는 기능을 지원하는 Java 객체로서 도메인 모델과 서비스 모델로 구성된다.

ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

(1) mvc 라는 새로운 Dynamic Web Project 생성

(2) 이 프로젝트에서 생성되는 소스(텍스트)들의 인코딩 정보를 utf-8 로 설정

(3) mvc 프로젝트를 톰캣 서버에 컨텍스트로 등록

(4) src 폴더에 controller, model 패키지 생성

(5) WebContent 폴더에 images, jspexam 폴더 생성

(6) 강사컴퓨터 교육자료 폴더에서 htmlexam폴더를 복사하여 WebContent에 붙인다

​	브라우저에서 /mvc/htmlexam/visitorForm.html을 요청해 본다.