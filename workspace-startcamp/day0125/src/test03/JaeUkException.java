package test03;

//만약 extends RuntimeException이라고하면 비체크 예외가 되겄찌...
public class JaeUkException extends Exception{
	public JaeUkException() {
		super("물러왔습니다");
	}
}
