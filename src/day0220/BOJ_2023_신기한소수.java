package day0220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2023_신기한소수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int num_first = (int) Math.pow(1, N-1);
		int num_last = (int) Math.pow(10,N);
		
		for (int i = num_first; i < num_last; i++) {
			isPrime(i);
		}
	
	}

	private static void isPrime(int i) {
		// TODO Auto-generated method stub
		
		
		
	}
	
}
