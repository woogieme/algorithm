package day0214;

import java.util.Arrays;

public class Test_수열 {
	static int[] num= {1,1,1,1 };
	static int[] arr = {0,0,0,0,0};
	public static void main(String[] args) {
		perm(0);
		comb(0,0);
	}
	private static void perm(int idx) {
		if(idx==arr.length) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		// TODO Auto-generated method stub
		for(int i= 0; i<4;i++) {
			 if(num[i]==0) continue;
			 num[i]--;
			 arr[idx]=i;
			 perm(idx+1);
			 num[i]++;
		}
	}
	private static void comb(int idx, int cnt) {
		// TODO Auto-generated method stub
		if(idx==arr.length) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		if(cnt==num.length) {
			return;
		}
		
		num[idx]-=0;
		
		
	}
}
