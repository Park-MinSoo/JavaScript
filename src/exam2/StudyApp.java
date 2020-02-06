package exam2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudyApp {
	public static void main(String[] args) {
		ApplicationContext factory =
				   new ClassPathXmlApplicationContext("exam2/bean2.xml");
		
		Student st1 = factory.getBean("st1", Student.class);
		System.out.println(st1.getName() + "는 " + st1.getMyHomework().getHomeworkName() +"를 학습합니다.");
		
		Student st2 = factory.getBean("st2", Student.class);
		System.out.println(st2.getName() + "는 " + st2.getMyHomework().getHomeworkName() +"를 학습합니다.");
		
		Student st3 = factory.getBean("st3", Student.class);
		System.out.println(st3.getName() + "는 " + st3.getMyHomework().getHomeworkName() +"를 학습합니다.");
		
		((ClassPathXmlApplicationContext)factory).close();
	}
}
