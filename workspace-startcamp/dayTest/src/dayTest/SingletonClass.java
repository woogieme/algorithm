package dayTest;

public class SingletonClass {
	private static SingletonClass intsatnce = new SingletonClass();
	private SingletonClass() {}
	
	public static SingletonClass getInstance(){
		return intsatnce;
	}
}
