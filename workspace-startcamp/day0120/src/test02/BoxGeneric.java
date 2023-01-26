package test02;

//method T 라는 타입이름을 사용
//class E 라는 타입이름을 사용
public class BoxGeneric<T> {
	private T data;
	
	public void setData(T data) {
		this.data = data;
	}
	public T getData() {
		return data;
	}
}
