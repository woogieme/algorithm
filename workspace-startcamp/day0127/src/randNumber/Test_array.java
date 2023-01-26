package randNumber;

import java.util.Random;

public class Test_array {
	public static void main(String[] args) {
		Random rand= new Random();
		int[] balls = new int[6];
		int i=0;
		while (i<balls.length) {
			boolean isFalse=true;
			int num = rand.nextInt(10)+1;
			for (int j = 0; j < balls.length; j++) {
				if(num==balls[j]) {
					isFalse=false;
					break;
				}
			}
			if(isFalse) {
				balls[i]=num;
				i+=1;
			}
			isFalse=true;
		}
		for (int answer : balls) {
			System.out.print(answer+" ");
		}
		
	}

}
