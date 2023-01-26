package day0116;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test10 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		int[] dx = { -1, 1, 0, 0, -1, -1, 1, 1 };
		int[] dy = { 0, 0, -1, 1, -1, 1, -1, 1 };

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
		
			String[][] arr = new String[N][N];
			for (int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int k = 0; k < N; k++) {
					arr[j][k] = st.nextToken();
				}
			}
			
			
			
			
			
			
			
		}

	}
}
