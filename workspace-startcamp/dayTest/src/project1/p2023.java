package project1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2023 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		if(N<M) {
			int temp=N;
			N=M;
			N=temp;
		}
		int TC=Integer.parseInt(br.readLine());
		int[] temp = new int[TC+1];
		temp[0]=N;
		for(int i=1; i<TC+1; i++) {
			temp[i]=Integer.parseInt(br.readLine());
		}
		int[] count = new int[TC+1];
		for(int i=0; i<TC+1; i++) {
			temp[i]=
		}
		
		
		
	}
}
