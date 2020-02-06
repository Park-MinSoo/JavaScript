package exam1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.time.LocalDateTime;

public class GreetingTest {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("exam1/beans.xml");
		
		Greeting mor = (Greeting) factory.getBean("mor");
		Greeting aft = (Greeting) factory.getBean("aft");
		Greeting eve = (Greeting) factory.getBean("eve");
		Greeting nig = (Greeting) factory.getBean("nig");	
		LocalDateTime time = factory.getBean("time",LocalDateTime.class);
		
		if(time.getHour() >= 6 && time.getHour() < 12) {
			mor.greet();
		}
		else if(time.getHour() >= 12 && time.getHour() < 17 ) {
			aft.greet();
		}
		else if(time.getHour() >= 17 && time.getHour() < 22 ) {
			eve.greet();
		}
		else {
			nig.greet();
		}
			
		((ClassPathXmlApplicationContext)factory).close();
	}
}
