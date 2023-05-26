package X_XTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14503_로봇청소기 {	
	static int robot_x;
	static int robot_y;
	static int N;
	static int M;
	static int[][] map;
	static int dir;
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		robot_x = Integer.parseInt(st.nextToken());
		robot_y = Integer.parseInt(st.nextToken());
		dir = Integer.parseInt(st.nextToken());
		map= new int [N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		for (int i = 0; i < args.length; i++) {
//			
//			for (int j = 0; j < args.length; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
		int count=0;
		while(true) {
			boolean isClean=true;
			
			//현재있는 자리가 청소되지않는 경우는 청소한다.
			System.out.println(robot_x+" "+robot_y);
			System.out.println(map[robot_x][robot_y]);
			if(map[robot_x][robot_y]==1) {
				map[robot_x][robot_y]=0;
				count++;
				continue;
			}
			
			//만약 4방향이 다 더럽지 않는것을 가정
			for (int d = 0; d < 4; d++) {
				int nexti = robot_x+dx[d];
				int nextj = robot_y+dy[d];
				if(nexti>=0 && nexti<N && nextj>=0 && nextj<M && map[nexti][nextj]!=0) {
					isClean=false;
					break;
				}
			}
			
			//1칸이라도 더럽지않다면?
			if(isClean) {
				int tmp= dir;
				tmp+=2;
				tmp%=4;
				int nexti = robot_x+dx[tmp];
				int nextj = robot_y+dy[tmp];
				if(nexti<0 || nexti ==N || nexti<0 || nextj==M) {
					break;
				}
				robot_x=nexti;
				robot_y=nextj;
				continue;
			}
			//1칸이라도 더러운 경우가 있다면?
			else {
				dir-=1;
				if(dir<0) {
					dir=3;
				}
				int nexti = robot_x+dx[dir];
				int nextj = robot_y+dy[dir];
				if(nexti<0 || nexti ==N || nexti<0 || nextj==M) {
					continue;
				}
				if(map[nexti][nextj]==1) {
					robot_x=nexti;
					robot_y=nextj;
					continue;
				}
			}
			
		
			
			
			
		}
		System.out.println(count);
	}

}
