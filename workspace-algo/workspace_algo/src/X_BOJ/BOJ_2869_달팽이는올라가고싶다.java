package X_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2869_달팽이는올라가고싶다 {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		long N =Integer.parseInt(st.nextToken());
		long M =N-Integer.parseInt(st.nextToken());
		long T =Integer.parseInt(st.nextToken());
		int day=0;
		if(T-N>=M) {
			T-=N;
			day++;
		}
		
		if(T==M) {
			day+=1;
		}
		else {
			day+=T/M;
		}
		System.out.println(day);
		
	}
}
