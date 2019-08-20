package sample5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("sample5/beans.xml");
		
		MessageBean bean = (MessageBean)ctx.getBean("messageBean");
		bean.sayHello();

	}

}
