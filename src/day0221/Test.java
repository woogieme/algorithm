package day0221;

import java.util.Arrays;

public class Test {
	static int[] arr= {1,2,3,4,5,6};
	static int[] brr = {0,0,0};
	static boolean[] checked= {false,false,false,false,false};
	public static void main(String[] args) {
		checkperm(0);
		//perm(0);
		//comb(0,0);
	}
	private static void checkperm(int idx) {
		if(idx==brr.length ) {
			
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			brr[idx]=i;
			checkperm(idx+1);
		}
		
	}
	private static void perm(int idx) {
		if(idx==brr.length) {
			System.out.println(Arrays.toString(brr));
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if(checked[i]) continue;
			checked[i]=true;
			brr[idx]=i+1;
			perm(idx+1);
			checked[i]=false;
		}
	}
	private static void comb(int idx, int cnt) {
		if(idx==brr.length) {
			System.out.println(Arrays.toString(brr));
			return;
		}
		if(cnt==arr.length) {
			return;
		}
		
		brr[idx]=arr[cnt];
		comb(idx+1,cnt+1);
		comb(idx,cnt+1);
		
		
	}
}
