package day0216;

import java.util.Arrays;

public class Test_수열2 {
	static int[] num= {1,2,3,4 ,5,6,7,8,9,10,11};
	static int[] arr = {0,0,0};
	static int N=num.length;
	static int R=arr.length;
	
	public static void main(String[] args) {
		//perm(0);
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
		if(idx==N) {
			return;
		}
		if(cnt==R) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		
		arr[idx]=num[cnt];
		comb(idx+1,cnt+1);
		comb(idx+1,cnt);
	}
}
