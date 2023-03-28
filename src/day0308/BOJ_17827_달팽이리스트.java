package day0308;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17827_달팽이리스트 {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		int N =Integer.parseInt(st.nextToken());
		int M =Integer.parseInt(st.nextToken());
		int V =Integer.parseInt(st.nextToken());
		
		int[] arr =new int[N];
		st = new  StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int cnt=0;
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(br.readLine());
			while(tmp>=N) {
				if(cnt==0) {
					tmp%=N;
					tmp+=(V-1);
					cnt++;
				}
				else {
					tmp%=N;
					tmp+=(V-1);
				}
			}
			System.out.println(arr[tmp]);
		}
		
				
	}
}
