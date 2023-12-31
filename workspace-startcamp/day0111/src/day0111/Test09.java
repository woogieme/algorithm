package day0111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Test09 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] num=new int[1001];
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int tmp=Integer.parseInt(br.readLine());
		int[] numa=new int[tmp];
		int[] numb=new int[tmp];
		int aa=0;
		int iEnd=0;
		for (int i = 0; i < tmp; i++) {
			String line = br.readLine(); //10개의 숫자를 하나의 문자열 통으로 입력받기 "1 2 3 4 5 6"
			StringTokenizer st = new StringTokenizer(line);
            int n1 = Integer.parseInt(st.nextToken());
            
            int n2 = Integer.parseInt(st.nextToken());
            numa[i]=n1;
            numb[i]=n2;
            num[n1]=n2;
            
            
		}
		
		Arrays.sort(numa);
		Arrays.sort(numb);
		int max = numb[0];
		int min = numb[0];
		int cou=0;
		for(int i=0 ; i<numb.length; i++) {
			if(numb[i]>max) {
				max = numb[i];
				
			}
			if(numb[i]<min) {
				min = numb[i];
				iEnd=numa[i];
			}
		}
		
		
		int value=0;
		int iStart=numa[0];
		int iMiddle=max;
		
		for(int i=iStart; i<cou; i++) {
			if(num[i]>value) {
				value+=num[i];
			}
			if(num[i]==0) {
				value+=num[i];
			}
		}
		for(int i=cou; i<iEnd; i++) {
			value+=min;
		}
		System.out.println(value);
	}
}
