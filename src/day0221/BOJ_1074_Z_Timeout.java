package day0221;

import java.util.Scanner;

public class BOJ_1074_Z_Timeout {
	static int r,c, ans,cnt,N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		
		//func(0,0,(int)Math.pow(2, N),(int)Math.pow(2, N));
		func(0,0,1<<N,1<<N);
		System.out.println(ans);
		
	}
	static void func(int si, int sj, int ei, int ej) {
		if(ei-si==1 ) {
			if(si == r && sj== c) {
				ans=cnt;
			}
			cnt++;
			return;
		}
		
		
		int mi = (si+ei)/2;
		int mj = (sj+ej)/2;
		
		func(si,sj,mi,mj); //현재 나의 1번영역
		func(si,mj,mi,ej); //현재 나의 2번영역
		func(mi,sj,ei,mj); //현재 나의 3번영역
		func(mi,mj,ei,ej); //현재 나의 4번영역
		//내 영역은 모두 방문이 끝났습니다 ㅂㅂㅂㅂㅂ
	}
}
