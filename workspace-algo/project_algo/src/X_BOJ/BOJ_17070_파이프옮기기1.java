package X_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17070_파이프옮기기1 {
	static int N;
	static int[][] map;
	static int ans;
	static boolean isdiago;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map= new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		ans=0;
		isdiago=false;
		dfs(0,0,0,1);
		System.out.println(ans);
		
		
		
	}
	private static void dfs(int fi, int fj, int bi, int bj) {
		if(bi==N || bj==N ||bi<0 || bj<0 || map[bi][bj]==1 ) {
			return;
		}
		if(isdiago==true && (map[fi][fj+1]==1 || map[fi+1][fj]==1)) {
			return;
		}
		if(bi==N-1&&bj==N-1) {
			ans+=1;
			return;
		}
		isdiago=false;
		if(fi==bi && fj+1==bj) {

			dfs(fi,fj+1,bi,bj+1);
			isdiago=true;
			dfs(fi,fj+1,bi+1,bj+1);
		}
		if(fi+1==bi && fj==bj) {
			dfs(fi+1,fj,bi+1,bj);
			isdiago=true;
			dfs(fi+1,fj,bi+1,bj+1);
		}
		
		if(fi+1==bi && fj+1==bj) {			
			dfs(fi+1,fj+1,bi,bj+1);
			dfs(fi+1,fj+1,bi+1,bj);
			isdiago=true;
			dfs(fi+1,fj+1,bi+1,bj+1);
		}
		
	}
	
}
