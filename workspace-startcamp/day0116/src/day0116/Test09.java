package day0116;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test09 {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int[] arr = new int[a];
		 
		System.out.println(arr);
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<b; i++) {
			int tmp=Integer.parseInt(st.nextToken());
			for(int j=0; j<arr.length; j++) {
				if ((j+1)%tmp==0 ) {
					if (arr[j]==0) {
						arr[j]=1;
					}
					else {
						arr[j]=0;
					}
				}
			}
		}
		
		
		
		for(int array : arr) {
			System.out.print(array+" ");
		}
	}
}
