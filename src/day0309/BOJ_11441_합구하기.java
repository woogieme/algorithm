package day0309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11441_합구하기 {
    static int N;
    static int M;
    static int[] arr;
    static int[] brr;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        brr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
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

        
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int x=Integer.parseInt(st.nextToken());
        	int y=Integer.parseInt(st.nextToken());
        	int ans = brr[y]-brr[x-1];
        	System.out.println(ans);
        			
		}
        
        
        
        
    }
}