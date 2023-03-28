package day0309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11659_구간합구하기4 {
    static int N;
    static int M;
    static int[] arr;
    static int[] brr;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        brr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <=N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
        for (int i =1; i <=N; i++) {
			if(i==1) {
				brr[i]=arr[i];
			}
			else {
				brr[i]=brr[i-1]+arr[i];
			}
		}
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int x=Integer.parseInt(st.nextToken());
        	int y=Integer.parseInt(st.nextToken());
        	int ans = brr[y]-brr[x-1];
        	System.out.println(ans);
        			
		}
        
        
        
        
    }
}