# [ DAY 30 ]



## [ Geolocation API ]

- window.navigator.geolocation 객체
  - 위치 요청에 대해 사용자가 동의하면 브라우저의 위치정보가 반환된다.

  - 지오로케이션을 지원하는 브라우저가 데스크탑이나 휴대전화 같은 디바이스에서 IP주소 또는 GPS 그리고 WiFi 기지국, 스마트폰 기지국을 이용해 위치 정보를 브라우저에 전달한다.

  - 위치 정보는 추가적인 메타데이터와 함께 위도와 경도 좌표로 전달된다.

    

  -  getCurrentPosition()

    - 현재 위치정보를 추출한다.

      getCurrentPosition(successCallback[, errorCallback, options])

    - successCallback : 위치정보를 성공적으로 추출했을 때 호출되는 콜백 함수이다.

    - errorCallback : 위치정보를 추출하는데 실패했을 때 호출되는 콜백 함수이다.

      

  - watchPosition()

  - 주기적으로 반복해서 위치정보를 구하는 작업을 수행한다.
    watchCurrentPosition(successCallback[, errorCallback, options])



## [ XML ]

- XML(Extensible Markup Language)
- 즉, 확장가능한 마크업 언어이다.
- XML 선언부를 제외하고는 기존 HTML5의 기본 구조와 사용 방법이 거의 유사하다.
- 속성의 값을 할당할 때 반드시 인용부호( ' or " )를 주어야한다.
- 반드시 맨 앞에 명세, XML 문서 유형을 지정해야 한다.
- DTD나 Schema로 XML 문서 구조를 선언해야 한다.

![image-20200115093859948](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200115093859948.png)



## [ JSON ]

- JSON(제이슨, JavaScript Object Notation)은, 인터넷에서 자료를 주고 받을 때 그 자료를 표현하는 방법이다.
- 자료의 종류에 큰 제한은 없으며, 특히 컴퓨터 프로그램의 변수값을 표현하는 데 적합하다.
- 형식은 자바스크립트의 구문 형식을 따르지만, 프로그래밍 언어나 플랫폼에 독립적이므로 C, C++, C#, 자바, 자바스크립트, 펄, 파이썬 등 많은 언어에서 이용할 수 있다.



## [ AJAX ]

- AJAX = Asynchronous JavaScript and XML
- 고전적인 웹의 통신 방법은 웹페이지의 일부분을 갱신하기 위해서는 페이지 전체를 다시 로드 해야 했다.
- AJAX 의 핵심은 재로드(refresh 재갱신)하지 않고 웹페이지의 일부만을 갱신하여 웹서버와 데이터를 교환하는 방법이다.
- 즉, 빠르게 동적 웹페이지를 생성하는 기술이다.
- AJAX는 브라우저 안에 엔진이 있다.

![image-20200115093121397](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200115093121397.png)



- XML과 JSON 비교

  ![image-20200115101516620](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200115101516620.png)



- XMLHttpRequest 객체

  - 서버 측과의 비동기 통신을 제어하는 것은 XMLHttpRequest 객체의 역할이다.

  - XMLHttpRequest 객체를 이용함으로써 지금까지 브라우저가 실행해 온 서버와의 통신 부분을 JavaScript가 제어할 수 있게 된다.

  - XMLHttpRequest 객체 생성

    - **new XMLHttpRequest()**

      

- 프로퍼티

  - onreadystatechange

    - 통신 상태가 변화된 타이밍에 호출되는 이벤트 핸들러

      

- 메서드

  - open(...)
    - HTTP 요청을 초기화
  - send([body])
    - HTTP 요청을 송신 (인수 body는 요청 본체)



## [ Query String  (쿼리 문자열) ]

- 웹 클라이언트에서 웹 서버에 정보를 **요청할 때 추가로 전달하는 문자열**
- 이 문자열을 정해 규칙으로 구성되어 전달되어야 하는데 이 규칙을 url encoding 또는 query string encoding 규칙 이라고 한다.



1. 모든 데이터들은 name = value 형식이어야 한다.
2. 여러개의 name = value 쌍을 전달할 때는 & 기호로 구분한다.
3. 공백은 + 문자로 변환되어 전달된다.
   1. 영문과 숫자 그리고 일부 특수문자를 제외하고 % 기호와 함께 16진수 코드값으로 전달되어야 한다.

