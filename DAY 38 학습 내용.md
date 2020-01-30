# [ DAY 38 ]

```jsp
${header.referer}

${header.user-agent} --> ${header["user-agent"]}
```



## [ EL 에서의 . 연산자]



- **변수명 .xxx**
  1. 변수의 참조 대상이 일반 Java 객체이면 getXxx()를 호출한 결과가 된다.
  2. 변수의 참조 대상이 Map 객체이면 get("xxx")를 호출한 결과가 된다.