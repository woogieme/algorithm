package day0227;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10163_색종이 {
	static int T;
	static int x1;
	static int y1;
	static int x2;
	static int y2;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int count=0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1=Integer.parseInt(st.nextToken());
			int y1=Integer.parseInt(st.nextToken());
			int x2=Integer.parseInt(st.nextToken());
			int y2=Integer.parseInt(st.nextToken());
			for (int x = 0; x < 100; x++) {
				for (int y = 0; y < 100; y++) {
					if((x>=x1 && x<=x2) &&(y>=y1 && y<=y2)){
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
}
