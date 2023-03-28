package day0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2578_빙고 {
	static int[][] map;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =null;
		map= new int[5][5];
		for (int i = 0; i <5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		arr	= new int[5][5];
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int count=0;
		int x=0;
		int y=0;
		int tmp=0;
		while(true) {
			if(count>=3) {
				break;
			}
			count=0;
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if(arr[x][y]==map[i][j]) {
						map[i][j]=0;
					}
				}
			}
			y+=1;
			y%=5;
			if(y==0) {
				x+=1;
				x%=5;
			}
			// 행검사
			tmp=0;
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j <5; j++) {
					if(map[i][j]==0) {
						tmp+=1;
					}
				}
				if(tmp==5) {
					count+=1;
				}
				tmp=0;

			}
			tmp=0;
			// 열검사
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j <5; j++) {
					if(map[j][i]==0) {
						tmp+=1;
					}
				}
				if(tmp==5) {
					count+=1;
				}
				tmp=0;
			}
			tmp=0;
			// 왼쪽 대각선 검사
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if(i==j&& map[i][j]==0) {
						tmp+=1;
					}
				}
			}
			if(tmp==5) {
				count+=1;
			}
			else {
				tmp=0;
			}
			tmp=0;
			//오른쪽 대각선 검사 
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if(i+j==4 && map[i][j]==0) {
						tmp+=1;
						
					}
				}
			}
			if(tmp==5) {
				count+=1;
			}
			else {
				tmp=0;
			}
		}
		System.out.println(x*5+y);
		
		
		
	}

}
