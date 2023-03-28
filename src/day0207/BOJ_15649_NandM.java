package day0207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15649_NandM {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int[] numbers = new int[N];
		boolean[] used = new boolean[N];
		int[] result = new int[M];
		for(int i =0; i<N; i++) {
			numbers[i]=i+1;
		}
		perm(0,numbers,result,used);
		
	}

	private static void perm(int idx, int[] numbers, int[] result, boolean[] used) {
		// TODO Auto-generated method stub
		if(idx==result.length) {
			for (int i = 0; i < result.length; i++) {
				System.out.print(result[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i =0 ; i<numbers.length; i++) {
			if(used[i])continue;
			used[i]=true;
			result[idx]=numbers[i];
			perm(idx+1,numbers,result,used);
			used[i]=false;
		}
		
	}

	
}
