package randNumber;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Test_set {
	public static void main(String[] args) {
		Random rand= new Random();
		Set<Integer> balls = new HashSet<Integer>();
		while(balls.size()!=6) {
			balls.add(rand.nextInt(10)+1);
		}
		System.out.println(balls);
	}
	
}
