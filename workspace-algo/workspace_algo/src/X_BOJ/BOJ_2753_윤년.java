package X_BOJ;

import java.util.Scanner;

public class BOJ_2753_윤년 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T = sc.nextInt();
		
		if(T%4==0 && T%100!=0 || T%400==0) {
			System.out.println(1);
		}
		else {
			System.out.println(0);
		}
	}
}	
