package day0111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test06 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int value=Integer.parseInt(br.readLine());
		int result=value;
		int tmp=0;
		int a=0;
		int b=0;
		int count=0;
		if (value<10) {
			String result_user_no = String.format("%02d", value);
			value=Integer.parseInt(result_user_no);
		}
		for(int aa=0; aa<65; aa++) {
			b=value/10; // 2
			a=value%10; // 6
			int c= a+b;
			if (c>=10) {
				c=c%10;
			}
			String str1=Integer.toString(a);
			String str2=Integer.toString(c);
			String answer= (str1+str2);

			value=Integer.parseInt(answer);
		
			if (value==result) {
				count+=1;
				break;
			}
			count+=1;
		}
		System.out.println(count);
	}
}
