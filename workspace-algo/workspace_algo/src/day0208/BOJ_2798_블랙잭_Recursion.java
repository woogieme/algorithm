package day0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2798_블랙잭_Recursion {
	static int value=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int[] arr= new int[N];
		int[] brr= new int[3];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		perm1(arr,brr,0,0,M);
		System.out.println(value);
		
	}

	private static void perm1(int[] arr, int[] brr,int tmp, int j,int M) {
		// TODO Auto-generated method stub
		if(tmp==brr.length) {
			int k=0;
			for (int i = 0; i < brr.length; i++) {
				k+=brr[i];
			}
			if(k<=M) {
				if(value<k) {
					value=k;
				}
		}
			return;
		}
		for (int x = j; x < arr.length; x++) {
			brr[tmp]=arr[x];
			perm1(arr,brr,tmp+1,x+1,M);
		}
		
	}
}
