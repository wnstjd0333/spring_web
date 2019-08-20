package sample2;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class BeforeMyAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		String methodName = method.getName(); //메서드 이름 획득
		System.out.println("Before 어드바이스 입니다.");
		System.out.println(methodName+"전에 실행됩니다.");

	}

}
