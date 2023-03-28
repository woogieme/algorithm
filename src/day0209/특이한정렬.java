package day0209;

import java.util.Arrays;

public class 특이한정렬 {
	public static void main(String[] args) {
		int[] numlist= {600, 400, 300, 200, 700, 800, 100, 900};
		int n=500;
		int[] result= new int[numlist.length];
		int[] cp= new int[numlist.length];
		
		for (int i = 0; i < cp.length; i++) {
			cp[i]=Math.abs(n-numlist[i]);
		}
		
		
		for (int i = 0; i < cp.length; i++) {
			int min=cp[0];
			int k=0;
			for (int j = 0; j < cp.length; j++) {
				if(min>=cp[j]) {
					min=cp[j];
					k=j;
				}
			}
			result[i]=numlist[k];
			cp[k]=Integer.MAX_VALUE;
		}
		System.out.println(Arrays.toString(result));
	}
}
