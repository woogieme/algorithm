package X_XTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13023_ABCDE {
	static int N;
	static int M;
	static boolean[] visited;
	static int[][] map;
	static int count;
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N][N];
		for (int i = 0; i < M; i++) {
			st =new StringTokenizer(br.readLine());
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			map[to][from]=map[from][to]=1;
		}
		count=0;
		DFS(0,new boolean[N]);
		if(ans>=4) {
			System.out.println(1);
		}
		else {
			System.out.println(0);
		}
		
	}

	private static void DFS(int current, boolean[] visit) {
		visit[current]=true;
		count++;
		if(count>=4) {
			ans=count;
		}
		for (int i = 0; i <N; i++) {
			if(map[current][i]==1 && !visit[i]) {
				DFS(i,visit);
			}
		}
		count--;
		
	}
}
