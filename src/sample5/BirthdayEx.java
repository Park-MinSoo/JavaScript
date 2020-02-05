package sample5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BirthdayEx { 
	public static void main(String[] args) {
		ApplicationContext factory = 
			       new ClassPathXmlApplicationContext("sample5/date.xml");
		
		//DateVo ob1=(DateVo)factory.getBean("hong");	// 밑에 방법과 결과는 동일하다.
		DateVo ob1 = factory.getBean("hong", DateVo.class);//형변환 연산말고 2번째 아규먼트로 변환하고자하는것과 확장자까지 주는 방법이다.
		System.out.println(ob1.toString());
			
		DateVo  ob2=factory.getBean("lee", DateVo.class);
		System.out.println(ob2.toString());
		
		((ClassPathXmlApplicationContext)factory).close();
	}
}






