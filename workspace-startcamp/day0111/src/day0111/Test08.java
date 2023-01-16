package day0111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test08 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int tmp=Integer.parseInt(br.readLine());
		
		int[][] array=new int[101][101];
		int[][] paper = new int[tmp][2];
		for (int i = 0; i < tmp; i++) {
			String line = br.readLine(); //10개의 숫자를 하나의 문자열 통으로 입력받기 "1 2 3 4 5 6"
			StringTokenizer st = new StringTokenizer(line);
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            for(int k=0; k<10; k++) {
            	 for(int z=0; z<10; z++) {
            		 array[n1+k][n2+z]=1;
            	 }
            	
            }
            
            
        }
		int count=0;
		for(int k=0; k<101; k++) {
			for(int a=0; a<101; a++) {
				if (array[k][a]==1) {
					count+=1;
				}
			}
		}
		System.out.println(count);
			
	}
}
