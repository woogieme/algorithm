package randNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test_list {
	public static void main(String[] args) {
		Random rand= new Random();
		List<Integer> balls = new ArrayList<Integer>();
		while (balls.size()!=6) {
			boolean isFalse=true;
			int num = rand.nextInt(10)+1;
			for (int j = 0; j < balls.size(); j++) {
				if(num==balls.get(j)) {
					isFalse=false;
					break;
				}
			}
			if(isFalse) {
				balls.add(num);
			}
			isFalse=true;
		}
		System.out.println(balls);
	}
}
