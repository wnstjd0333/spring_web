package sample5;

import org.springframework.beans.factory.annotation.Autowired;

public class MessageBeanImpl implements MessageBean {
	private String name;
	private String greeting;
	private Outputter outputter;
	public MessageBeanImpl(String name) {
		this.name = name;
	}
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	@Autowired
	public void setOutputter(Outputter outputter) {
		this.outputter = outputter;
	}
	@Override
	public void sayHello() {
		String msg = greeting + name + "~";
		try {
			outputter.output(msg);//파일에 출력
		} catch(Exception e) {}
	}

}
