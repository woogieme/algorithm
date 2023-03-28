package day0224;

import java.util.Arrays;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

public class BOJ_6987_월드컵_나의버젼 {
	static int [] teamA; //6개의 국가는 15번의 게임을 하게됨
	static int [] teamB; // 각 게임의번호는 0~14번 게임임.
	static int [][] input, make;
	static int ans;
	static int count;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N=5;
		count=0;
		for (int i = 1; i <=5; i++) {
			count+=i;
		}
		teamA=new int[count];
		teamB=new int[count];
		int k=0;
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j <= N; j++) {
				teamA[k]=i;
				teamB[k]=j;
				k+=1;
			}
		}
		
		for (int tc = 1; tc <=4; tc++) {
			input = new int [6][3];
			make = new int [6][3];
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					input[i][j]=sc.nextInt();
				}
			}
			ans=0;
			game(0);
			System.out.print(ans+" ");
			
		}
		
	}

	private static void game(int gameIdx) {
		if(gameIdx==count) {
			if(check()) {
				ans=1;
			}
			return;
		}
		
		int teamA_cnt = teamA[gameIdx];
		int teamB_cnt = teamB[gameIdx];
		
		make[teamA_cnt][0]++;
		make[teamB_cnt][2]++;
		game(gameIdx+1);
		make[teamA_cnt][0]--;
		make[teamB_cnt][2]--;
		
		make[teamA_cnt][2]++;
		make[teamB_cnt][0]++;
		game(gameIdx+1);
		make[teamA_cnt][2]--;
		make[teamB_cnt][0]--;
		
		make[teamA_cnt][1]++;
		make[teamB_cnt][1]++;
		game(gameIdx+1);
		make[teamA_cnt][1]--;
		make[teamB_cnt][1]--;

		
	}

	private static boolean check() {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 3; j++) {
				if(input[i][j]!=make[i][j]) {					
					return false;
				}
			}
		}
		return true;
	}
}
