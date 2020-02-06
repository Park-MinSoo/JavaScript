# [ DAY 45 ]



## [ Autowired ]

- autowired="byType"  : setter

  1. 타입으로 찾아서 1개이면 해당 객체 주입

  2.  타입으로 찾아서 2개 이상이면 NoUniqueBeanDefinitionException 발생

  3.  없으면 null 주입

     

- autowired="byName"  : setter

  1. 프로퍼티명과 동일한 명칭의 빈을 찾아서 해당 객체 주입
  2. 없으면 null 주입

  

- autowired="constructor"  : constructor
  1. 타입으로 찾아서 1개이면 해당 객체 주입
  2.  타입으로 찾아서 2개 이상이면 매개변수명과 동일한 id 값을 갖는 객체 주입
  3.  없으면 null 주입



- 필드에 설정된 @Autowired  - Spring FW 전용

  1. 타입으로 찾아서 1개이면 해당 객체 주입
  2.  타입으로 찾아서 2개 이상이면 변수명과 동일한 id 값을 갖는 객체 주입
  3.  없으면 NoSuchBeanDefinitionException 발생
     - (required = false 속성을 사용하여 없으면 null 이 되게 지정 가능)
  4.  @Qualifier(value="xxx")를 추가로 사용해서 변수명이 아닌 다른 이름 지정 가능

  

- 필드에 설정된 @Resource  - Java
  1. 변수명과 동일한 id 값을 갖는 빈을 찾아서 해당 객체 주입
  2. 타입으로 찾아서 1개이면 객체 주입
  3. 타입으로 찾아서 2개이상 이면 NoUniqueBeanDefinitionException 발생
     - (Unique한 Bean이 없다는 에러가 발생하게 된다.)
  4. 없으면 NoSuchBeanDefinitionException 발생