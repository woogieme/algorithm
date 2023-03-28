package day0207;

import java.util.ArrayList;
import java.util.Arrays;

public class polyplus {
	public static void main(String[] args) {
		String polynomial="x + 10 + 20";
		String [] arr  = polynomial.split(" ");
		ArrayList<String> str1 = new ArrayList<>();
		ArrayList<String> str2 = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			if(arr[i].equals("x")) {
				str1.add("1");
			}
			else if(arr[i].contains("x")) {
				str1.add(arr[i].replace("x", ""));
			}
			else if(!(arr[i].contains("+"))) {
				str2.add(arr[i]);
			}
		}
		int a=0;
		int b=0;

		for(int i=0; i<str1.size(); i++) {
			a+=Integer.parseInt(str1.get(i));
		}
		
		for(int i=0; i<str2.size(); i++) {
			b+=Integer.parseInt(str2.get(i));
		}
		String x="";
		if(a!=1) {
			x=String.valueOf(a);
		}
		String y=String.valueOf(b);
		String answer="";
		if (b==0){
			answer += x+"x";
		}
		else if(a==0) {
			answer+=y;
		}
		else if(a>0 && b>0){
			answer += x+"x"+" + "+y;
		}
		System.out.println(answer);
		
	}

}
