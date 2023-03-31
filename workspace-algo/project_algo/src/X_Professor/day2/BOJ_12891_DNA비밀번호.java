package X_Professor.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_12891_DNA비밀번호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		int[] A = new int[4];
		int[] B = new int[4];
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int ans=0;
		char[] pw = br.readLine().toCharArray();
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < 4; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
	}
}
