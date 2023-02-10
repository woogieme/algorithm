package day0208;

import java.util.Arrays;

public class Solution_Recursion {
	static int N= 5, R=3;
	static String[] cards= {"A","B","C","D","E"};
	static String[] result = new String[R];
	
	public static void main(String[] args) {
		comb(0,0);
	}

	private static void comb(int tmp, int count) {
		// TODO Auto-generated method stub
		if(tmp==R) {
			System.out.println(Arrays.toString(result));
		}
		for (int i = count; i < cards.length; i++) {
			result[tmp]=cards[i];
			comb(tmp+1,count+=1);
		}
	}

}
