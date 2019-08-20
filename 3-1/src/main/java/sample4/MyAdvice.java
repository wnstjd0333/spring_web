package sample4;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

@Aspect
public class MyAdvice {
	
	@Around("execution (* sayHello())") //포인트컷이 들어간다.
	//포인트 컷을 찾는 매핑 사용법 execution(1 2 3) 
	//1:public,private 등 접근제어자(생략가능), 2:메서드의 리턴타입 3:패키지이름, 클래스이름, 메서드이름(매개변수)
	//예1) execution(* name()) 
	//의미 : 이름이 name이고 매개변수가 없는 메서드
	//예2) execution(* name(..))
	//의미 : 이름이 name이고 매개변수가 있거나 없는 메서드, 점 두개(..)는 0개 이상을 의미한다.
	//예3) execution(public void name*())
	//의미 : public이고 void이고 name으로 시작하는 이름의 메서드, 매개변수가 없다.
	//예4) execution(public * sample.*.*(..))
	//의미 : public이고 모든 리턴타입이며 sample패키지에 속한 모든 메서드
	//예5) execution(* sample.*.*(..))
	//의미 : 모든 return타입이며 sample및 그 하위패키지에 속한 모든 메서드
	public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
		StopWatch sw = new StopWatch();
		String methodName = pjp.getSignature().getName();
		System.out.println("어라운드 어드바이스 실행");
		sw.start(methodName);//시간 측정
		Object obj = pjp.proceed();
		sw.stop();//시간측정 정지
		System.out.println("어라운드 어드바이스 재실행");
		System.out.println("포인트 컷 실행시간 : "+sw.getTotalTimeMillis()/1000+"초");
		return obj;
	}
}
//sample1의 어드바이스 : 포인트 컷 전, 후로 동작
//sample2의 어드바이스 : 포인트 컷 전에 동작
//sample3의 어드바이스 : 포인트 컷 후에 동작
//sample4의 어드바이스 : 포인트 컷 전, 후로 동작
//	@around : 포인트 컷 전,후로 동작
//	@Before : 포인트 컷 전에 동작
//	@After : 포인트 컷 후에 동작