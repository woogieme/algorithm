package day0111;

import java.util.Scanner;

public class Test10 {
public static void main(String[] args) {
	Scanner sc =new Scanner(System.in);
	int cnt= sc.nextInt();
	
	boolean[][] paper = new boolean[100][100];
	
	for(int c=0; c<cnt; c++) {
		int si=sc.nextInt();
		int sj=sc.nextInt();
		
		for(int i=si; i<si+10; i++) {
			for(int j=sj; j<sj+10; j++) {
				paper[i][j]=true;
			}
		}
	}
	int count=0;
	for(int i=0; i<101; i++) {
		for(int j=0; j<101; j++) {
			if (paper[i][j]==true) {
				count+=1;
			}
}
}
	System.out.println(count);
}
}
