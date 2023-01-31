package backjoon;

import java.util.Scanner;

public class swea2805 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC=Integer.parseInt(sc.nextLine());
		for(int tc=1; tc<=TC; tc++) {
		int N = Integer.parseInt(sc.nextLine());
		int sum=0;
		int count=0;
		int[][] arr = new int[N][N];
		
		
		for(int i=0; i<N; i++) {
			String tmp = sc.nextLine();
			for (int j = 0; j < N; j++) {
				arr[i][j]=tmp.charAt(j)-'0';
			}
		}
		
		
		for (int i = 0; i <= N/2; i++) {
			for (int j = N/2-i; j <=N/2+i; j++) {
				sum+=arr[i][j];
			}
		}
		
		for (int i = N-1; i >=(N/2)+1; i--) {
			
			for (int j = N/2-count; j <=N/2+count; j++) {
				sum+=arr[i][j];
			}
			count+=1;
		}
		System.out.println("#"+tc+" "+sum);
		}
		
	}
}
