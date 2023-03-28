package day0207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW1289_WonJae {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			String value = br.readLine();
			String[] arr = value.split("");
			String[] brr = arr.clone();
			for (int i = 0; i < brr.length; i++) {
				brr[i]="0";
			}
			boolean isFlag =true;
			int count=0;
            for(int i =0; i<arr.length; i++) {
                if(!(arr[i].equals(brr[i]))&& isFlag) {
                    isFlag=false;
                    count+=1;
                }else if(arr[i].equals(brr[i])&& !isFlag) {
                    isFlag=true;
                    count+=1;
                }
            }
			System.out.println("#"+tc+" "+count);
		}
		
		
		
		
		
		
	}//end for main
	
}
