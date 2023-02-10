package day0207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW1208_Flatten {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 1; tc<=10; tc++) {
			int tmp = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int [] arr =new int[100];
			for(int i=0; i<100; i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			
			for(int i=0; i<tmp; i++) {
				int iMin=arr[0];
				int minKey=0;
				int iMax=arr[0];
				int maxKey=0;
				for(int j=0; j<100; j++) {
					if(iMax>=arr[j]) {
						iMax=arr[j];
						maxKey=j;
					}
					if(iMin<=arr[j]){
						iMin=arr[j];
						minKey=j;
					}
				}
				arr[maxKey]+=1;
				arr[minKey]-=1;
			}
			Arrays.sort(arr);
			System.out.println("#"+tc+" "+(arr[arr.length-1]-arr[0]));
		}
	}
}
