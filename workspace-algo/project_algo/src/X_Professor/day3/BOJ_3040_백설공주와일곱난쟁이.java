package X_Professor.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import X_Professor.day3.BOJ_15686_치킨배달.Point;

public class BOJ_3040_백설공주와일곱난쟁이 {
	static int N;
	static int M;
	static int[] person;
	static boolean[] select;
	static List<Point> arr;
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		person = new int [9];
		select = new boolean[9];
		for (int i = 0; i < 9; i++) {
			person[i]= Integer.parseInt(br.readLine());
		}
		
		
		comb(0,0);

	}
	private static void comb(int idx, int cnt) {
		if(cnt==7) {
			ans=0;
			for (int i = 0; i < person.length; i++) {
				if(select[i]) {
					ans+=person[i];
				}
			}
			if(ans==100) {
				for (int i = 0; i < person.length; i++) {
					if(select[i]) {
						System.out.println(person[i]);
					}
				}
			}
			
			return;
		}
		
		if(idx==9) {
			return;
		}
		
		select[idx]=true;
		comb(idx+1,cnt+1);
		select[idx]=false;
		comb(idx+1,cnt);
	}

}
