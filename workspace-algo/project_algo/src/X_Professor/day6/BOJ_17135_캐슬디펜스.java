package X_Professor.day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//1.
//궁수 3명 조합돌리기 

//2.	 
//궁수가 화살쏘기 
//가장가까운 거리에있는애 맞추기 [가장 왼쪽에있는애부터]
//하지만 바로죽이지말고 값 저장해놓기

//3.
//적들 한칸씩 내려오기

public class BOJ_17135_캐슬디펜스 {
	static int N;
	static int M;
	static int D;
	static int[][] tmpMap;
	static int[][] map;
	static int[][] saveMap;
	static int ans=0;
	static boolean[]  archer;
	static int count;
	static boolean[][] visited;
	static int [] dx = {0,-1,0 };
	static int [] dy = {-1,0,1 };
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		D= Integer.parseInt(st.nextToken());
		ans=Integer.MIN_VALUE;
		archer=new boolean[M];
		map = new int[N][M];
		
		
		 for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}

		//1.
		//궁수 3명 조합돌리기 

		 comb(0,0);
		 System.out.println(ans);
	}
	private static void comb(int idx, int cnt) {
		
		if(cnt==3) {
			//System.out.println("바뀌었어요~~~~~");
			tmpMap = new int[N][M];
			saveMap = new int[N][M];
			copy(map);
			count=0;
			
			
			while(true) {
				//2.	 
				//궁수가 화살쏘기 
				//가장가까운 거리에있는애 맞추기 [가장 왼쪽에있는애부터]
				//하지만 바로죽이지말고 값 저장해놓기
				for (int t = 0; t < archer.length; t++) {
					if(archer[t]) {
						BFS(N,t);
						//print(saveMap);
					}
				}//end for t						true인것 확인하기 
				//print(saveMap);
				kill(saveMap);
				//print(saveMap);
				//4.
				//적들 한칸씩 내려오기
				if(allDead(tmpMap)) {
					 break;
				 }
				downEnemy();
				//print(tmpMap);
				for (int i = 0; i < tmpMap.length; i++) {
					for (int j = 0; j < tmpMap[i].length; j++) {
						saveMap[i][j]=tmpMap[i][j];
					}
				}
				
			}
			ans=Math.max(ans,count);
			//System.out.println("SubAnwser: "+ ans);
			return;
		}
		if(idx==archer.length) {
			return;
		}
		archer[idx]=true;
		comb(idx+1,cnt+1);
		archer[idx]=false;
		comb(idx+1,cnt);
		
	}
	
	private static void BFS(int x, int y) {
		int value=y;
		boolean isFlag=false;
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x,y));
		boolean[][] checked = new boolean[N][M];
		while(!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Point now = queue.poll();
				if(now.x>=0 && now.x<N && now.y>=0 && now.y<M && tmpMap[now.x][now.y]==1 && (Math.abs(now.x-N) + Math.abs(now.y-value))<=D && (Math.abs(now.x-N) + Math.abs(now.y-value))>=1 ) {
					notkill(now.x,now.y);
					isFlag=true;
					break;
				}
				for (int d = 0; d < 3; d++) {
					int nexti = now.x+dx[d];
					int nextj = now.y+dy[d];
					if(nexti>=0 && nexti<N && nextj>=0 && nextj<M && !checked[nexti][nextj]) {
						queue.add(new Point(nexti,nextj));
						checked[nexti][nextj]=true;
					}
					
				}
			}
			if(isFlag) {
				break;
			}
			
			
		}
		
	}
	//모든칸이 0인지 확인하는 메소드 
	private static boolean allDead(int[][] tmp) {
		int value=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <M; j++) {
				value+=tmpMap[i][j];
			}
		}
		if(value==0) {
			return true;
		}
		return false;
	}
	
	//적들이 한칸 내려가는 메소드
	private static void downEnemy() {
		for (int i = N-2; i >=0; i--) {
			for (int j = 0; j <M; j++) {
				tmpMap[i+1][j]=tmpMap[i][j];
			}
		}
		int start=0;
		for (int j = 0; j < M; j++) {
			tmpMap[start][j]=0;
		}
		
	}
	
	//진짜 적을 죽이는 메소드 
	private static void kill(int[][] tmp) {
		for (int i = 0; i < tmp.length; i++) {
			for (int j = 0; j < tmp[i].length; j++) {
				tmpMap[i][j]=tmp[i][j];
			}
		}
		
	}
	
	//아직 죽이진않았지만 곧 죽일것들 
	private static void notkill(int x,int y) {
		if(saveMap[x][y]!=0) {
			saveMap[x][y]=0;
			count++;
		}
		else {
			saveMap[x][y]=0;
		}
		
		return;
		
	}
	
	//map을 전체적으로 복사하는 메소드 
	private static void copy(int[][] tmp) {
		for (int i = 0; i < tmp.length; i++) {
			for (int j = 0; j < tmp[i].length; j++) {
				saveMap[i][j]=map[i][j];
				tmpMap[i][j]=map[i][j];
			}
		}
		
	}
	
	//출력하는 메소드
	private static void print(int[][] tmp) {
		for (int i = 0; i < tmp.length; i++) {
			for (int j = 0; j < tmp[i].length; j++) {
				System.out.print(tmp[i][j]+" ");
			}
			System.out.println();
		}
		///System.out.println("=============================");
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
