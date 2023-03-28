package day0213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SW_1228_암호문1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <=10; tc++) {
		int T= Integer.parseInt(br.readLine());
		StringTokenizer st =new StringTokenizer(br.readLine());
		ArrayList<String> arr = new ArrayList<>();
		for (int i = 0; i < T; i++) {
			arr.add(st.nextToken());
		}
		int N= Integer.parseInt(br.readLine());
		
		
		st=new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			if(st.nextToken().equals("I")) {
				int tmp = Integer.parseInt(st.nextToken());
				int i_for = Integer.parseInt(st.nextToken());
				for(int i=0; i<i_for; i++) {
					arr.add(tmp+i,st.nextToken());
				}
			}
		}
		System.out.print("#"+tc+" ");
		for (int i = 0; i < 10; i++) {
			System.out.print(arr.get(i)+" ");
			}
		System.out.println();
		}
		
	}
}
