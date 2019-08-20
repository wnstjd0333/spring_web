package sample3;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class AfterMyAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		String methodName=method.getName();
		System.out.println("After 어드바이스 입니다.");
		System.out.println(methodName+"후에 실행됩니다.");

	}

}
