package sample3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class myApp {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("sample3/beans.xml");
		MessageBean bean = (MessageBean)ctx.getBean("proxy");
		bean.sayHello();

	}

}
