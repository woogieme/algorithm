package day0216;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_15686_치킨배달_Improved {
	static List<Point> homes;
	static List<Point> chickens;
	
	static int N,M,ans; // 지도 크기, 치킨집 살릴수있는갯수
	
	static boolean[] select; //살려놓을 치킨집 true, 폐업을 가정한 치킨집 false
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		
		
		homes = new ArrayList<>();
		chickens = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int input = sc.nextInt();
				if(input==1) {
					homes.add(new Point(i,j));
				}else if(input==2) {
					chickens.add(new Point(i,j));
				}
			}
		}
		select = new boolean[chickens.size()];
		ans= Integer.MAX_VALUE;
		comb(0,0); //치킨집 idx, 현재 살려둔 치킨집 갯수
		System.out.println(ans);
		
	}
	
	private static void comb(int idx, int cnt) {
		if(cnt==M) { //M개의 치킨집을 뽑았다! 치킨거리 계산해보자
			int sum=0;
			for(Point home: homes) {
				int min =Integer.MAX_VALUE; //지금 home 집에서 가장 가까운 치킨집까지의 거리를 찾자
				for (int i = 0; i < chickens.size(); i++) {
					if(select[i]) {
						int dist = Math.abs(chickens.get(i).i - home.i)+
									Math.abs(chickens.get(i).j - home.j);
						min = Math.min(min, dist);
					}
				}
				sum+=min; //현재 가정집에서 가장 가까운 치킨집까지의 거리를 동네 총합에 누적시키기
			}//모든 집에 대해 치킨거리 탐색 완료
			ans = Math.min(ans, sum);
			return;
		}
		if(idx == chickens.size()) {
			return;
		}
		select[idx]=true;
		comb(idx+1,cnt+1);
		select[idx]=false;
		comb(idx+1,cnt);
	}
	static class Point{
		int i;
		int j;
		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
