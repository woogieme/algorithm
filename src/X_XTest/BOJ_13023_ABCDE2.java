import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13023_ABCDE2 {
	static int N;
	static int M;
	static boolean[] visited;
	static int[][] map;
	
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
			map[to][from]=1;
		}
		boolean isFlage=true;
		for (int i = 0; i < map.length; i++) {
			int count=0;
			for (int j = 0; j < map[i].length; j++) {
				if(map[i][j]==1) {
					count++;
				}
			}
			if(count==N-1) {
				isFlage=false;
				break;
			}
		}
		if(isFlage) {
			System.out.println(1);
		}
		else {
			System.out.println(0);
		}
		
	}
//
//	private static void DFS(int current, boolean[] visit) {
//		visit[current]=true;
//		for (int i = 0; i <N; i++) {
//			if(map[current][i]==1 && !visit[i]) {
//				System.out.println(current+" : "+ i);
//				DFS(i,visit);
//			}
//		}
//		
//	}
}
