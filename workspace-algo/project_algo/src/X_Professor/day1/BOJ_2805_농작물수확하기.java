package X_Professor.day1;

import java.util.Scanner;

public class BOJ_2805_농작물수확하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
//		
		for (int tc = 1; tc <=T; tc++) {
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				char[] tmp = sc.next().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j]= tmp[j]-'0';
				}
			}
			int flag = N/2;
			int start = N/2;
			int end = N/2;
			int count=0;
			int sum=0;
			for (int i = 0; i < N; i++) {
				if(i!=0) {
					count=1;
				}
				if(i<=flag) {
					start-=count;
					end+=count;
					for (int j = start; j <= end; j++) {
						sum+=map[i][j];
					}
				}
				else {
					start+=count;
					end-=count;
					for (int j = start; j <= end; j++) {
						sum+=map[i][j];
					}
				}
				
			}
			System.out.println("#"+tc+" "+sum);
		
		}
	}
}
