package day0221;

import java.util.Scanner;

public class BOJ_14503_로봇청소기 {
	static int N,M; //지도 세로, 가로 
	static int nowi, nowj , dir ; //청소기의 좌표와 방향 
	static int[] di= {-1,0,1,0}; //0인 경우 북쪽, 1인경우 동쪽, 2인경우 남쪽, 3인 경우 서쪽
	static int[] dj= {0,1,0,-1}; 
	static int[][] map;
	static boolean[][] visit; //어떤 칸을 청소했는지 기록해서 또 청소하는건 카운트 안해야지
	static int ans ;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		
		nowi=sc.nextInt();// 청소기 시작 좌표 및 방향
		nowj=sc.nextInt();
		map = new int[N][M];
		visit = new boolean[N][M];
		dir=sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}//end input
		
		while(true) {
			//1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다
			if(!visit[nowi][nowj]) {
				visit[nowi][nowj]= true;
				ans++;
			}
			boolean isClean =true; 
			for (int d = 0; d < 4; d++) {
				int nexti= nowi+di[d];
				int nextj= nowi+dj[d];
				//로봇청소기 주위 4칸중에 청소안한 빈칸이 있는지 ? 
				if(map[nexti][nextj]==0 && !visit[nexti][nextj]) {
					isClean=false;
				}
			}
			//2-1. 현재 칸의 주변4칸중 청소되지 않은 빈 칸이 없는경우, (청소안해도됨 isClean True)
			//바라보는 방향을 유지한채로 한칸 후진할수있다면 한칸 후진하고 1번으로 돌아간다
			//바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다
			if(isClean) {
				int backi = nowi + di[(dir+2)%4];  
				int backj = nowj + di[(dir+2)%4];
				if(map[backi][backj]==0) {
					nowi=backi;
					nowj=backj;
				}
				else {
					break;
				}//로봇청소기 작동 정지
			}
			//2-2. 현재칸의 주변4칸중 청소되지 않은 빈 칸이 있는경우, 반시계방향으로 90도 회전한다. (청소 해야됨isClean flase)
			//바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈칸인 경우 한칸 전진된다.
			else {
				dir= (dir+3)%4;
				int nexti=nowi+di[dir];
				int nextj=nowi+di[dir];
				if(map[nexti][nextj]==0 && !visit[nexti][nextj]) {
					nowi=nexti;
					nowj=nextj;
				}
			}
			//1번으로 돌아간다.
		}
		System.out.println(ans);
		
	}
}
