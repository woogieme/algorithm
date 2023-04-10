package X_Professor.day8;

import java.util.Arrays;
import java.util.Scanner;

public class MyTest {
	static int[] arr;
	static int N;
	static int M;
	static int[] brr;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		N = sc.nextInt();
		visited= new boolean[N];
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] =i+1;
		}
		System.out.println("몇개 뽑을래 ? : " );
		M= sc.nextInt();
		brr=new int[M];
		
		//perm(0);
		//comb(0,0);
		comb2(0,0);
	}
	private static void comb2(int idx, int start) {
		if(idx==M) {
			System.out.println(Arrays.toString(brr));
			return;
		}
		
		for (int i = start; i < N; i++) {
			brr[idx]=arr[i];
			comb2(idx+1,i+1);
			
		}
		
	}
	private static void comb(int idx, int cnt) {
		if(cnt==M) {
			System.out.println(Arrays.toString(visited));
			return;
		}
		if(idx==N) {
			return;
		}
		
		visited[idx]=true;
		comb(idx+1,cnt+1);
		visited[idx]=false;
		comb(idx+1,cnt);
		
	}
	private static void perm(int idx) {
		if(idx==M) {
			System.out.println(Arrays.toString(brr));
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(visited[i]) continue;
			visited[i]=true;
			brr[idx]=arr[i];
			perm(idx+1);
			visited[i]=false;
		}
		
	}
}
