package X_Professor.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_1987_알파벳 {
	static int N;
	static int M;
	static int[] dx= {0,1,0,-1};
	static int[] dy= {1,0,-1,0}	;
	static char[][] arr;
	static int[] alpha;
	static int ans;
	public static void main(String[] args) throws IOException {
		Scanner sc =new Scanner(System.in);
		
		N=sc.nextInt();
		M=sc.nextInt();
		alpha=new int[26];
		arr =new char[N][M];
		ans =1;
		for (int i = 0; i < N; i++) {
			char[] tmp = sc.next().toCharArray();
			for (int j = 0; j < M; j++) {
				arr[i][j]=tmp[j];
			}
		}
		DFS(0,0,1);
		System.out.println('Z'-'A');
		System.out.println(ans);
	}
	private static void DFS(int si, int sj, int cnt) {
		int a=arr[si][sj]-'A';
		if(alpha[a]!=0) {
			return;
		}
		alpha[a]++;
		
		for (int d = 0; d < 4; d++) {
			int nexti = si+dx[d];
			int nextj = sj+dy[d];
			if(nexti>=0 && nexti<N && nextj>=0 && nextj<M && alpha[arr[nexti][nextj]-'A']==0) {
				int tmp = cnt+1;
				DFS(nexti,nextj,tmp);
				alpha[arr[nexti][nextj]-'A']-=1;
				ans = Math.max(ans, tmp);
			}
		}
		
	}
}
