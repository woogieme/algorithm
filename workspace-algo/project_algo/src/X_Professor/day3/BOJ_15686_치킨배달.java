package X_Professor.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15686_치킨배달 {
	static int N;
	static int M;
	static int[][] map;
	static boolean[] select;
	static List<Point> arr;
	static List<Point> brr;
	static int ans;
	static int tmp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		arr = new ArrayList<>();
		brr = new ArrayList<>();
		ans = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==2) {
					arr.add(new Point(i,j));
				}
				else if (map[i][j]==1){
					brr.add(new Point(i,j));
				}
			}
		}
		select = new boolean[arr.size()];
		comb(0,0);
		System.out.println(ans);
	}
	private static void comb(int idx, int cnt) {
		if(cnt==M) {
			tmp=0;
			for(Point br : brr) {
				int value=Integer.MAX_VALUE;
				for (int i = 0; i < arr.size(); i++) {
					if(select[i]) {
						int result = Math.abs(br.x-arr.get(i).x)+ 
								Math.abs(br.y-arr.get(i).y);
						value=Math.min(value, result);
					}
				}
				tmp+=value;	
			}
			ans = Math.min(ans, tmp);
			return;
		}
		if(idx==select.length) {
			return;
		}
		select[idx]=true;
		comb(idx+1,cnt+1);
		select[idx]=false;
		comb(idx+1,cnt);
		
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
