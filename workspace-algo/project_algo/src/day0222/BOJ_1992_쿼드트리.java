package day0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ_1992_쿼드트리 {
	static int N;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map= new int[N][N];
		char[] tmp = new char[8];
		for (int i = 0; i < N; i++) {
			tmp= sc.next().toCharArray();
			for (int j = 0; j <N; j++) {
				map[i][j]=(tmp[j])-'0';
			}
			
		}
		func(0,0,N,N);
	}
	private static void func(int si, int sj, int ei, int ej) {
		if(ei-si==1) {
			System.out.println(si+" "+sj);
			System.out.println(si+" "+ej);
			System.out.println(ei+" "+sj);
			System.out.println(ei+" "+ej);
			//System.out.print(map[si][sj]);
			System.out.println("------------------");
			return;
		}
		
		int mi = (si+ei)/2;
		int mj = (si+ei)/2;
		func(si,sj,mi,mj); 
		func(si,mj,mi,ej); 
		func(mi,sj,ei,mj); 
		func(mi,mj,ei,ej);
		
	}
}
