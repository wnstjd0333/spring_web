package sample2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		//환경설정파일을 접근하는 객체 ApplicationContext
		ApplicationContext ctx = new ClassPathXmlApplicationContext("sample2/beans.xml");
		MyMessage mm = (MyMessage)ctx.getBean("myMessageKr");
		mm.sayHello("홍길동");
		mm = (MyMessage)ctx.getBean("myMessageEn");
		mm.sayHello("홍길동");
	}

}
