package dayTest;

public class SingletonClassTest {
	public static void main(String[] args) {
		SingletonClass sc1 = SingletonClass.getInstance();
		SingletonClass sc2 = SingletonClass.getInstance();
		
		System.out.println(sc1==sc2);
	}
	
}
