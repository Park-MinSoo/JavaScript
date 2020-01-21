# [ DAY 34 ]





## [ 파일 업로드 ]

- Query 문자열에 서버에 올리려는 파일의 내용을 포함시켜서 웹서버 프로그램을 요청

  

- 사용자가 업로드할 파일을 선택할 수 있게 화면을 제시해야 한다.

  

1. ```javascript
   <form> 태그의 자식태그중 <imput type="file">
   HTML5 이전에는 파일을 한 개만 선택 가능했음. <input type = "file" multiple>을 사용해서
   멀티 파일을 2개 이상의 파일을 업로드할 수 있다.
   ```

   - 기본적인 Query 문자열의 인코딩 규칙:

   ​	name=value&name=value&.....

   ​	영문, 숫자, 일부 특수문자를 제외하고 % 기호와 함께 16진수 코드값으로 변환

   

   - 업로드 되는 파일도 Query 문자열로 서버에 전송되어야 하지만 Query 문자열의 인코딩 규칙으로 그대로 인코딩 되면 안된다.

   ```javascript
   <form method="post" action="" enctype="multipart/form-data">
   ```

   

2. 파일에 대한 Drag & Drop 기능을 이용해서 업로드할 파일을 윈도우즈 탐색기에서 선택하여 서버에 올릴 수 있다.  (Ajax 기술과 연계하여)