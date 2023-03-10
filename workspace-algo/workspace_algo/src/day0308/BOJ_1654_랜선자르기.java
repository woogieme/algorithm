package day0308;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1654_랜선자르기 {
	static long[] arr;
	static int K;
	static int N;
	static long lanLen;
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr = new long[K];
		for (int i = 0; i < K; i++) {
			arr[i]=Integer.parseInt(br.readLine());
		} 
		Arrays.sort(arr);
		
		
		long left=1,right=arr[arr.length-1];
		while(left<=right) {
			long mid = (left+right)/2;
			ans=0;
			for(long i : arr) {
				if(mid<=i) {
					ans+=i/mid;
				}
			}
			if(ans>=N) {
				left=mid+1;
			}
			else {
				right=mid-1;
			}
		}
		System.out.println(right);
	}
}
