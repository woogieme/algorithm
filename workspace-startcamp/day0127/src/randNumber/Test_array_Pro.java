package randNumber;

import java.util.Arrays;
import java.util.Random;

public class Test_array_Pro {
	public static void main(String[] args) {
		Random rand = new Random();
		int[] lotto = new int[6];
		int idx = 0;//내가 배열에 현재 채우고자 하는 칸 번호
		while (true) { 
			int num = rand.nextInt(10) + 1; //숫자를 하나 뽑았다.
			boolean used = false;
			for (int i = 0; i < lotto.length; i++) {//현재 idx 앞에 뽑아진 숫자들과 num을 비교하기
				if (lotto[i] == num) { //만약 중복된 숫자가 있었다면
					used = true;		//사용중이라고 기록
					break;
				}
			} // end for i

			if (!used) { //위에서 for 검사를 통해 미사용 확인된 숫자만 현재 idx칸에 넣기
				lotto[idx] = num;
				idx++;
			}
			if (idx == 6)
				break;

		} // end for while
		System.out.println(Arrays.toString(lotto));
	}

}
