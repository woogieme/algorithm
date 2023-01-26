package project2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class p2026 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		int[] death = new int[input];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<input; i++) {
			death[i]=Integer.parseInt(st.nextToken());
		}
		
		int tmp=0;
		for (int i = 0; i < death.length; i++) {
			if (tmp<death[i]){
				tmp=death[i];
			}
		}
		
		int value=death[death.length-1];
		for (int i = 0; i < death.length; i++) {
			if (value>death[i]){
				value=death[i];
			}
		}
		
		if (value==death[death.length-1]) {
			System.out.println(-1);
		}
		else {
			System.out.println(tmp-value);
		}
		
		
		
		
		
	}
}
