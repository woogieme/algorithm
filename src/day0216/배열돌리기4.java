package day0216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.sound.midi.Soundbank;

import day0216.BOJ_15686_치킨배달_Improved.Point;

public class 배열돌리기4 {
	static int N,M,K;
	static int[][] map;
	static Rotate[] cards; //입력으로 들어오는 회전연산(순열의 재료)
	static Rotate[] result; // cards를 이용해 만든 순열이 저장되는 배열
	static boolean[] used;
	
	static int ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N=sc.nextInt();
		M=sc.nextInt();
		K=sc.nextInt();
		
		map = new int [N+1][M+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				map[i][j]= sc.nextInt();
			}
		}
		result = new Rotate[K];
		used = new boolean[K];
		cards = new Rotate[K]; //회전연산의 갯수
		for (int k = 0; k < K; k++) {
			cards[k] = new Rotate(sc.nextInt(),sc.nextInt(),sc.nextInt());
		}
//		int[][] copy = deepcopy(map);
//		rotate(copy,cards[1]);
//		print(copy);
		ans=Integer.MAX_VALUE;
		perm(0);
		System.out.println(ans);
		
	}
	private static void perm(int idx) {
		if(idx==result.length) {//result 배열이 채워졌네?! 순열 하나 됐따 ! 시뮬 고고 !
			//System.out.println(Arrays.toString(result));
			int[][] copy = deepcopy(map);
			for (int i = 0; i < result.length; i++) {
				rotate(copy,result[i]);
			}
			
			for (int i = 1; i <=N; i++) {
				int rowSum=0;
				for (int j = 1; j <=M; j++) {
					rowSum+=copy[i][j];
				}
				ans=Math.min(ans, rowSum);
			}
			return;
		}
		// TODO Auto-generated method stub
		for (int i = 0; i < cards.length; i++) {
			if(used[i]) continue;
			result[idx] = cards[i];
			used[i] = true;
			perm(idx+1);
			used[i]=false;
		}
		
	}
	static void print(int[][] origin) {
		for (int i = 0; i < origin.length; i++) {
			for (int j = 0; j < origin[0].length; j++) {
				System.out.print(origin[i][j]+" ");
			}
			System.out.println();
		}
	}
	static int[][] deepcopy(int[][] origin){
		int[][] copy = new int [origin.length][origin[0].length];
		for (int i = 0; i < copy.length; i++) {
			for (int j = 0; j < copy[i].length; j++) {
				copy[i][j]=origin[i][j];
			}
		}
		return copy;
	}
	static void rotate(int[][] copy,Rotate now) {
		for (int s = 1; s <= now.s; s++) {
			int i = now.r-s, j=now.c-s;
			int tmp= copy[i][j];  //현재 회전하는 왼쪽위 한칸 뽑아놓기
			
			
			for (i =now.r-s; i < now.r+s; i++) {
				copy[i][j]= copy[i+1][j];
			}
			for (j = now.c-s; j <now.c+s; j++) {
				copy[i][j]=copy[i][j+1];
			}
			for (i = now.r+s; i>now.r-s; i--) {
				copy[i][j]=copy[i-1][j];
			}
			for (j = now.c+s; j >now.c+s; j--) {
				copy[i][j]=copy[i][j-1];
			}
			copy[now.r-s][now.c-s+1]=tmp;
		}
	}
	
	static class Rotate{
		int r,c,s;

		public Rotate(int r, int c, int s) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
		}

		@Override
		public String toString() {
			return "Rotate [r=" + r + ", c=" + c + ", s=" + s + "]";
		}
		
	}
}
