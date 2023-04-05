package test;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_3055_탈출 {
	static int N;
	static int M;
	static char[][] map;
	//static boolean[][] checked;
	static boolean[][] visited;
	static int[] dx= {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int ans;
	static List<Point> arr = new LinkedList<>();
	public static void main(String[] args) throws IOException {
//		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st =new StringTokenizer(br.readLine());
		Scanner sc =new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new char [N][M];
		ans=0;
		for (int i = 0; i < N; i++) {
			char[] tmp = sc.next().toCharArray();
			for (int j = 0; j <M; j++) {
				map[i][j]=tmp[j];
			}
		}
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if(map[i][j]=='S') {
					BFS(i,j);
					if(ans==0) {
						System.out.println("KAKTUS");
					}else {
						System.out.println(ans);
					}
				}
			}
		}
		
	}

	private static void BFS(int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x,y));
		boolean[][] checked = new boolean[N][M];
		checked[x][y]=true;
		int count=0;
		boolean isFlag=false;
		while(!queue.isEmpty()) {
			int size =queue.size();
			for (int i = 0; i < size; i++) {
				Point now = queue.poll();
				if(map[now.x][now.y]=='D') {
					isFlag=true;
					break;
				}
				for (int d = 0; d < 4; d++) {
					int nexti = now.x+dx[d];
					int nextj = now.y+dy[d];
					if(nexti>=0 && nexti<N && nextj>=0 && nextj<M && map[nexti][nextj]!='*' && map[nexti][nextj]!='X' && !checked[nexti][nextj] && map[now.x][now.y]!='*') {
						queue.add(new Point(nexti,nextj));
						checked[nexti][nextj]=true;
					}
				}
			}
			waterFall();
			count++;
			if(isFlag) {
				ans=count-1;
				break;
			}
		}
		
		
		
	}
	private static void waterFall() {
		visited = new boolean [N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]=='*' && !visited[i][j]) {
					visited[i][j]=true;
					for (int d = 0; d < 4; d++) {
						int nexti = i+dx[d];
						int nextj = j+dy[d];
						if(nexti>=0 && nexti<N && nextj>=0 && nextj<M && map[nexti][nextj]=='.' &&!visited[nexti][nextj]) {
							map[nexti][nextj]='*';
							visited[nexti][nextj]=true;
						}
					}
				}
			}
		}
		
	}

	static void showA(boolean[][] tmp){
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(tmp[i][j]+" ");
			}
		System.out.println();
		}
		System.out.println("==========================");
	}
	
	static void showB(char[][] map){
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]+" ");
			}
		System.out.println();
		}
		System.out.println("==========================");
	}
	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}	
