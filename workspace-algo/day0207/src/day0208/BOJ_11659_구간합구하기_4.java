package day0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11659_구간합구하기_4 {
	static int N;
	static int M;
	static int[] arr;
	static int value=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < M; i++) {
			value=0;
			st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken())-1;
			int Y = Integer.parseInt(st.nextToken())-1;
			if(X==Y) {
				value+=arr[X];
			}
			else {
				int tmp=0;
				if((Y-X+1)%2==1) {
					tmp=(Y-X+1)/2+1;
				}
				else {
					tmp=(Y-X+1)/2;
				}
				for (int k = 0; k <tmp; k++) {
					if(X==Y) {
						value+=arr[X];
						
					}
					else {
					value+=(arr[X]+arr[Y]);
					}
					System.out.println(value);
					X+=1;
					Y-=1;
				}
			}
			System.out.println(value);
		}
	}

}
