package sample3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("sample3/beans.xml");
		MrHong mrHong = (MrHong)ctx.getBean("mrHong");
		mrHong.has();
		mrHong = (MrHong)ctx.getBean("mrHongComputer");
		mrHong.has();
		MrPark mrPark = (MrPark)ctx.getBean("mrPark");
		mrPark.has();
		mrPark = (MrPark)ctx.getBean("mrParkComputer");
		mrPark.has();

	}

}
