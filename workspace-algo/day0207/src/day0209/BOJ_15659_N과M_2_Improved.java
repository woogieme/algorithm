package day0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15659_N과M_2_Improved {
	static int N;
	static int M;
	static int[] numbers;
	static int [] result;
	static StringBuilder sb;
	static boolean[] used;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N =Integer.parseInt(st.nextToken());
		M =Integer.parseInt(st.nextToken());
		numbers=new int[N];
		sb =new StringBuilder();
		used = new boolean[N];
		for (int i = 0; i < N; i++) {
			numbers[i]=i+1;
		}

		result = new int[M];
		comb(0,0);
		
	}
	private static void comb(int idx, int start) {
		// TODO Auto-generated method stub
		if(idx==M) {
			for (int i = 0; i < result.length; i++) {
				System.out.print(result[i]+" ");
			}
			System.out.println();
			return;
		}
		for (int i = start; i < numbers.length; i++) {
			result[idx]=numbers[i];
			comb(idx+1,i+1);
		}
	}
}