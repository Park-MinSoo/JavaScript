# [ DAY 28 ]



## [ Canvas API ]

- Canvas API 란??
  - 웹 페이지에 그림을 그릴 수 있도록 지원하는 HTML5 API 이다.

  - <canvas> 엘리먼트를 사용하여 그림을 그리기 위한 영역을 정의하고 스크립트로 그림을 그린다.

  - 직선, 박스, 원, 베지에 곡선 등 다양한 그림을 직접 그릴 수 있으며 원하는 사이즈 그리고 칼라의 이미지 출력을 처리할 수 있다.

  - <canvas> 엘리먼트 작성 방법 : 그림을 그릴 수 있는 사각형 영역이 만들어진다.

```javascript
<canvas id = "draw" width="400" height = "300"></canvas>
```



- HTML Canvas Object 객체 접근

  - 웹 스크립트로 그림을 그리기 위해서는 <canvas> 태그를 DOM 객체로 접근해야 한다.

  - <canvas> 엘리먼트를 사용하여 그림을 그리기 위한 영역을 정의하고 스크립트(JavaScript 코드)로 그림을 그린다.

  ```javascript
  var area = document.getElementById("draw");
  var ctx = area.getContext("2d");
  ctx.fillStyle = "rgb(255,0,0)";
  ctx.fillRect (10, 10, 100, 100);	// 앞에 10,10은 x,y의 좌표를 뜻한다.
  ```

  

- 그리기 기능을 지원하는 메서드들

  - fillRect(x, y, width, height) 

    - 색이 칠해질 사각형을 그린다.

      

  - strokeRect(x, y, width, height)

    - 테두리만 있는 사각형을 그린다.

      

  - clearRect(x, y, width, height) 

    - 특정 영역을 지우고 완전히 투명하게 만든다.

      

  - beginPath()

    - 경로를 시작한다.

      

  - closePath()

    - 경로를 종료한다.

      

  - stroke() 

    - 경로를 따라서 테두리 선을 그린다.

      

  - fill()

    - 설정된 스타일로 도형을 채운다.

      

  - moveto(x,y)

    - (x,y) 위치로 시작점을 옮긴다.

      

  - lineto(x,y)

    - x에서 y까지 직선을 그린다.

    - 끝난 후 꼭 stroke()를 호출하여 테두리를 그려줘야한다. (lineto는 투명색으로 그려지기 때문)

    - 안을 채우고 싶을 때에는 fill 까지 호출해 주어야 한다.

      

  - strokeText(msg, x, y) 

    - (x,y) 위치에 텍스트를 테두리선만 그린다.

      

  - fillText(msg, x, y)

    - (x,y) 위치에 텍스트를 색을 채워서 그린다.

      

  - measureText(msg) 

    - 측정된 문자열의 길이정보를 저장한 TextMetrics 객체를 리턴한다.

      

  - arc(x, y, r, startAngle, endAngle, anticlockwise)

    - (x,y)에서 시작하여 반시계방향(anticlockwise)으로 반지름(r)만큼의 원을 그린다.

    - 각도는 라디안 값으로 주어야한다. ex) 0pi, 1/2pi 등 (Math.PI를 활용한다.)

    - 3시 방향이 0도이다. 

    - anticlockwise는 ture, false로 지정한다.

      

  - quardraticCurveTo(cp1x, cp1y, x, y) 

    - **한 개의 조절점**(cp1x,cp1y)을 이용해 (x,y)까지의 곡선을 그린다.

      ![image-20200113114024487](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200113114024487.png)

    

  - bezierCurveTo(cp1x, cp1y, cp2x, cp2y, x, y)

    - **두 개의 조절점**(cp1x,cp1y)와 (cp2x,cp2y)를 이용해 (x,y)까지의 곡선을 그린다.

      ![image-20200113114031560](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200113114031560.png)![image-20200113114038313](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200113114038313.png)

  - drawImage(image, sx, sy)

  - drawImage(image, sx, sy, sWidth, sHeight)

  - drawImage(image, sx, sy, sWidth, sHeight, dx, dy, dWidth, dHeight)
    이미지 파일을 읽어서 주어진 위치에 주어진 크기로 또는 슬라이스하여 그린다.



- 그라디언트와 패턴

  - 그라디언트 : CanvasGradient 객체를 생성한다.

    - createLinearGradient(x1, y1, x2, y2) : 선형그라디언트 객체를 생성한다.

    - createRadialGradient(x1, y1, r1, x2, y2, r2) : 원형그라디언트 객체를 생성한다.

    - CanvasGradient 객체의 메서드
      addColorStop(position, color) : position(0.0~1.0) 위치에 color 를 설정한다.

      

  - 패턴 : CanvasPattern 객체를 생성한다.

    - createPattern(image, type) : image 와 type 에 알맞은 패턴 객체를 생성한다.
      image 에는 CanvasImageSource 객체를 지정하며 type 는 repeat, repeat-x, repeat-y, no-repeat 중
      한 개를 설정한다.

      

  - save ()

    - 캔버스의 상태정보를 스택에 저장
    - 스택에 저장되는 정보
      - 회전이나 크기 조절과 같이 캔버스에 적용된 변형 내용
        

  - restore()

    - 스택에 저장된 상태 정보를 읽어온다.

      

- 스타일

  [ 색상 ]

  - fillStyle

    - 채워질 색상 지정

    - 칼라, CanvasGradient 객체, CanvasPattern 객체를 지정할 수 있다.

      

  - strokeStyle

    - 테두리 색상 지정

    - 칼라, CanvasGradient 객체, CanvasPattern 객체를 지정할 수 있다.

      

  - globalAlpha
    - 투명도 지정한다. 0(완전투명)에서 1(완전불투명)사이 값을 가짐

  

  [ 선 ]

  - lineWidth

    - 선의 두께 , 1픽셀이 기본값

  - lineCap

    - 선의 끝모양을 결정한다.

    - butt 

      - 기본값으로 아무런 효과 없음

    - round

      - 선 너비의 1/2을 반지름으로 하는 반원이 선 양쪽 끝에 그려서 표시

    - square

      - 선 양쪽 끝에 사각형을 그려서 표시

        

    ![image-20200113131654558](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200113131654558.png)

  - lineJoin

    - 두 개의 선이 만날 때 선의 교차점 표시한다.
    - round
      - 선과 선이 만나는 부분이 둥글게 처리
    - bevel
      - 두 선 연결 부분에 단면으로 표시
    - miter
      - 연결한 흔적이 남지 않고 마치 처음부터 하나의 선이었던
        것처럼 연결. 기본값.

![image-20200113131705443](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200113131705443.png)



- 그림자 효과

  - shadowOffsetX

    - 객체로부터 그림자가 x축 방향으로 얼마나 떨어져 있는지 표시한다. (기본값은 0, 음수이면 왼쪽)

    

  - shadowOffsetY

    - 객체로부터 그림자가 y축 방향으로 얼마나 떨어져 있는지 표시한다.(기본값은 0, 음수이면 위쪽)

      

  - shadowBlur : 그림자가 얼마나 흐릿한지 나타낸다. (기본값은 0)

  - shadowColor : 그림자 색상을 지정한다. 기본값은 완전히 투명한 검정색이다.

    

- 도형 변형

  - scale(x, y) : 도형의 크기를 조정한다.

  - rotate(angle) : 주어진 각도만큼 도형을 회전한다.

  - translate(x, y) : 도형을 그리는 기준 위치를 이동한다.

    

- 도형 합성

  - globalCompositeOperation : 원본(먼저 그린 도형) 도형과 대상(나중에 그린 도형) 도형의 겹쳐진 형태에 따른 표시 방법을 정의한다.

    

- 비트맵이미지 관리와 HTMLObjectCanvas 객체 저장

  - 비트맵이미지 관리
    - createImageData(sw, sh)

    - createImageData(ImageData 객체)

      - 비트맵 이미지 객체(ImageData)를 생성한다.

      

  - getImageData(sx, sy, sw, sh)

  	<canvas>객체의 주어진 영역의 데이터를 비트맵 이미지 객체(ImageData)로 추출한다.
  

  - putImageData(ImageData 객체, dx, dy)

  	<canvas>객체의 (dx, dy) 위치에 비트맵 이미지 객체(ImageData)의 데이터를 출력한다.

  ​    

- HTMLObjectCanvas 객체 저장
  toDataURL() : <canvas> 태그 영역의 모든 내용을 png 형식의 URI 문자열로 변환하여 리턴한다.



## [ 웹 스토리지 ]

- 웹 스토리지란?
  - 웹 브라우저에 자료를 저장하기 위한 기능으로 로컬스토리지와 세션스토리지로 나뉜다.
  - 기존의 쿠키와 비슷한 기술이지만 일부 기능에서 차이를 가지고 있다.
  - 저장하려는 데이터마다 유일한 이름(키)을 같이 저장한다.
  - 저장하려는 데이터의 종류에는 제한이 없으며 저장시에는 문자열로 저장된다.
  - 로컬 스토리지
    - 영구 보관한다.
  - 세션 스토리지 
    - 브라우저가 종료될 때 까지 보관한다.
  - W3C는 Same Origin Policy에 따라 도메인당 5MB를 권장하고 있으며 추가 용량이 필요할 경우 사용자의 동의를 얻어 용량을 확장할 수 있다.
    - 초과시 QUOTA_EXCEEDED-ERR 발생
  - Same Orign Policy 정책이 적용된다.



- window.localStorage 와 window.sessionStorage 의 주요 멤버

  - length 

    - 스토리지에 저장된 key/value 쌍의 개수를 추출하는 속성이다.

      

  - key(index)

    - 숫자형 인덱스에 해당하는 key를 리턴한다.

      

  - getItem(key)

    - 스토리지로 부터 key 에 해당하는 **value 를 추출**한다.

      

  - setItem(key, value)

    - 스토리지에 key 에 해당하는 **value 를 저장**한다.

      

  - removeItem(string key)

    - 스토리지에 key 에 해당하는 **value 를 제거**한다.

      

  - clear() 

    - 현재 스토리지의 모든 데이터를 제거한다.

      

  - onstorage 

    - 로컬 스토리지의 내용이 변경될 때마다 발생되는 이벤트로 로컬 스토리지의 변경 사항을 모니터링 하는 것이 가능하다. StorageEvent 객체가 생성된다.
    - 스토리지 이벤트(데이터 삭제, 추가, 대체) 발생시 핸들러

    

- 로컬 스토리지의 데이터 관리

```javascript
저장
localStorage.mykey = "myvalue";
localStorage["mykey"] = "myvalue";
localStorage.setItem("mykey", "myvalue");

인기
var mydata = localStorage.mykey;
var mydata = localStorage["mykey"];
var mydata = localStorage.getItem("mykey”);
                                  
삭제
delete localStorage.mykey;
delete localStorage["mykey"];
localStorage.removeItem("mykey");
```