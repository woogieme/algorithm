package day0308;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3273_두수의합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st =new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int key = Integer.parseInt(br.readLine());
		int ans=0;
		Arrays.sort(arr);
		int left=0, right=arr.length-1;
		while(true) {
			if(left>=right) {
				break;
			}
			if(arr[left]+arr[right]==key) {
				ans++;
				left+=1;
				right-=1;
			}
			else if((arr[left]+arr[right])<key) {
				left+=1;
			}
			else if((arr[left]+arr[right])>key) {
				right-=1;
			}
		}
		System.out.println(ans);
		
	}
}
