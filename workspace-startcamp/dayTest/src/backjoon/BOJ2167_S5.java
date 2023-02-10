package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2167_S5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int di = Integer.parseInt(st.nextToken());
		int dj = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[di][dj];
		for (int i = 0; i < di; i++) {
			st= new StringTokenizer(br.readLine());
			for (int j = 0; j <dj; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		st= new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		
		for (int tc = 0; tc < N; tc++) {
			st= new StringTokenizer(br.readLine());
			int i1 = Integer.parseInt(st.nextToken())-1;
			int j2 = Integer.parseInt(st.nextToken())-1;
			int x1 = Integer.parseInt(st.nextToken())-1;
			int y2 = Integer.parseInt(st.nextToken())-1;
			
			int sum=0;
			for (int i = i1; i <=x1; i++) {
				for (int j = j2; j <=y2; j++) {
					//System.out.println(i+" :  "+j);
					sum+=arr[i][j];
				}
			}
			System.out.println(sum);		
		}
		
		
		
		
				
	}
	
}
