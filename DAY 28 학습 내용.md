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