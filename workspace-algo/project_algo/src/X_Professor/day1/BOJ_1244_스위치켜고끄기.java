package X_Professor.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1244_스위치켜고끄기 {
	static int N;
	static int[] arr;
	static int M;
	static int gender;
	static int loc;
	static int start;
	static int end;
	static int jumpTip;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N= Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st =new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}
		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			gender = Integer.parseInt(st.nextToken());
			loc = Integer.parseInt(st.nextToken())-1;
			jumpTip=loc+1;
			start= loc;
			end = loc;
			
			if(gender==2) {
				
				switch2(start,end);
				
			}
			else if(gender==1) {
				switch1(loc);
			}
			
		}
		for (int i = 0; i < arr.length; i++) {
			if(i!=0 && i%20==0) {
				System.out.println();
			}
			System.out.print(arr[i]+" ");
		}
		
		
		
		
	}

	private static void switch1(int jump) {
		if(jump>=arr.length) {
			return;
		}
		if(arr[jump]==0) {
			arr[jump]=1;
			
		}
		else {
			arr[jump]=0;
		}
		switch1(jump+jumpTip);
		
	}

	private static void switch2(int front, int end) {
		if(front<0 || end==arr.length || arr[front]!=arr[end]) {
			return;
		}
		
		if(arr[front]==arr[end]) {
			if(arr[front]==1) {
				arr[front]=0;
				arr[end]=0;
			}
			else {
				arr[front]=1;
				arr[end]=1;
			}
			switch2(front-1,end+1);
		}
		
	}
}
