package exception;

public class CartEmptyException extends RuntimeException {
	//unchecked exception : 컴파일 전 예측이 불가
	//RuntimeException는 catch 문으로 잡거나 throws로 선언하지 않아도 된다, 강제성이 없다.

	public CartEmptyException(String msg) {
		super(msg);
	}
}
