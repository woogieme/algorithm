package project2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class p2027 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		int[] height = new int[input];
		int[] speed = new int[input]; 
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<input; i++) {
			speed[i]=Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<input; i++) {
			height[i]=Integer.parseInt(st.nextToken());
		}
		
		int[] exit_s= {900,1000,1100};
		int[] exit_h= {4000,3000,2000};
		int answer=0;
		boolean isFlag=false;
		for(int i=0; i<4; i++) {
			int dis=0;
			int tmp=0;
			for(int j=6; j>=4; j--) {
				int value=0;

				for(int k=i; k<=j; k++) {
					if(Math.abs(height[k]-height[j])>=exit_h[dis]) {
						answer=j+1;
						isFlag=true;
						break;
					}
					else {
						value+=speed[k];
						
					}
					tmp-=1;
				}//end for k
				if(isFlag) break;
				if ((value/j)==exit_h[dis]) {
						answer=j+1;
						isFlag=true;
						break;
				}
				if(isFlag) break;
			}//end for j
			if(isFlag) break;
		}//end for i 
		if(isFlag) System.out.println(answer);
		if(!isFlag) System.out.println(-1); 
		
	}
}
