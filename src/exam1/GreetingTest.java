package exam1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetingTest {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("exam1/beans.xml");
		
		Greeting mor = (Greeting) factory.getBean("mor");
		Greeting aft = (Greeting) factory.getBean("aft");
		Greeting eve = (Greeting) factory.getBean("eve");
		Greeting nig = (Greeting) factory.getBean("nig");	
		Greeting time = (Greeting) factory.getBean("time");
		
		if(time >= 6 && time < 12) {
			System.out.println(mor);
		}
		else if(time >= 12 && time < 17 ) {
			System.out.println(aft);
		}
		else if(time >= 17 && time < 22 ) {
			System.out.println(eve);
		}
		else {
			System.out.println(nig);
		}
			
		((ClassPathXmlApplicationContext)factory).close();
	}
}
