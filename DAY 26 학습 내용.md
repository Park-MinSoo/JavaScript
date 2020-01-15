# [ DAY 26 ]



## [ 객체의 생성과 활용 ]

- 객체 리터럴 방식과 생성자 함수 방식의 비교

|                       객체리터럴 방식                        |                       생성자 함수 방식                       |
| :----------------------------------------------------------: | :----------------------------------------------------------: |
| - 객체 리터럴 방식은 하나의 객체만을 만들 수 있게 된다. (싱글톤 객체) | - 동일한 속성 사양을 갖는 객체들을 여러개 생성하는 것이 가능하다. |
|              - prototype 속성 사용이 불가하다.               |              - prototype 속성 사용이 가능하다.               |
|                                                              |                - 정적 멤버를 정의할 수 있다.                 |

- this 객체
  - this 객체는 함수가 어떻게 실행되느냐에 따라 결정된다.
  - 함수가 객체의 메서드로서 불리게 되면, this는 메소드를 부른 객체로 설정된다.
  - new 연산자를 통해 인스턴스(객체)를 생성해 함수를 부를 때도 같은 원리다. 이런 방법으로 부르게 되면 함수 스코프 내에서 this의 값은 새로 만들어진 객체로 설정된다.
  - 함수가 단독으로 호출되면, this는 기본적으로 브라우저의 window 객체가 된다.
  - 함수명으로 호출 가능한 call() 과 apply() 메서드를 사용해도 함수 호출이 가능하며 이 때는 함수가 어떤 컨텍스트로 실행할지 즉 함수내에서 사용되는 this 가 어떠한 객체를 참조하게 될지 자유롭게 설정해줄 수 있다.

## [ BOM - (Browser Object Model)]

- 객체

  - window

    

  - document

    

  - location - 위치 기능을 조절한다.

    - ***location.href*** - 페이지 이동을 구현하고자 할 때 사용한다. 

      ​							(현재 보여지는 URL이 보여진다. 즉, 바뀌면 자동으로 페이지가 바뀌는 것이다.)

    - ***location.reload()*** - 현재 페이지를 서버한테 재요청한다.

      

  - history - 브라우저가 방문된 정보가 담겨있다.

    

  - navigator - 정보를 추출한다. 어떤 정보인지.

    - ***navigator.userAgent*** - 이 페이지를 랜더링하고 있는 클라이언트 머신과 

      ​										브라우저 정보를 하나의 문자열로 추출

  - screen - 화면 크기를 조절한다.

    

## [ DOM - (Document Object Model) ]

- 브라우저의 HTML 파서가 서버로 부터 전달받은 HTML 문서의 내용을 파싱하고 랜더링 할 때

  인식된 HTML 태그, 속성 그리고 텍스트로 구성된 컨텐츠를 하나하나 JavaScript 객체로 생성한다.

  이 때 만들어지는 DOM 객체들(Element 객체, Text 객체) 부모 자식 관계를 유지해서 트리 구조를 형성한다.

  

-----> WHY?? 

JavaScript 코드로 HTML 태그나 속성 그리고 컨텐츠를 읽거나 변경할 수 있게 지원하여 ***동적인 웹 페이지를 생성***



- 공부할 내용

1. 필요한 태그를 찾는 방법

   ```javascript
   document.getElementsByTagName("태그명")	// NodeList
   document.getElementById("태그의 id속성의 값")	// Node // Elemet에 s 가 빠진것을 주의할것!
   document.getElementsByClassName("태그의 class 속성값") // NodeList
   
   document.querySelector("CSS선택자")	// Node
   document.querySelector("CSS선택자")	// Node List
   ```

   

2. 태그의 내용이나 속성을 읽고 변경하는 방법, 및 삭제하는 방법

   ```javascript
   찾은 Element객체.innerHTML
   
   찾은 Element객체.textContent
   
   찾은 Element객체.getAttribute("속성명")
   
   찾은 Element객체.setAttribute("속성명", 속성값)
   
   찾은 Element객체.removeAttribute("속성명")
   
   찾은 Element객체.속성명
   
   찾은 Element객체.속성명 = 속성값
   ```



3. 태그에서 발생하는 이벤트 or 브라우저 객체에서 발생하는 이벤트(window)에 대한 이벤트 핸들러 구현 방법

   (1) 인라인 이벤트 모델

   ```javascript
   <button onclick = "코드">1<button>
   ```

   

   (2) 전역적 이벤트 모델(고전 이벤트 모델)

   ```javascript
   <button>2<button>
      
   var dom = document.getElementsByTagName("button")[0];
   dom.onclick = function() {코드};
   
   ```

dom.onclick = null; 		// 이벤트 해제 하는 방법
   ```

   

   (3) 표준 이벤트 모델
   
   ```javascript
   <button>3<button>
   
   var dom = document.getElementsByTagName("button")[0];
   dom.addEventListener("click", function() {코드});
   
   dom.removeEventListener("click", function() {코드});	// 이벤트 삭제 하는 방법
   ```
