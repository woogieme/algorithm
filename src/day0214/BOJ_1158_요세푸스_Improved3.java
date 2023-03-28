package day0214;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1158_요세푸스_Improved3 {
	public static void main(String[] args) {
		Scanner sc  =new Scanner (System.in);
		int N =  sc.nextInt();
		int K = sc.nextInt();
		
		Queue<Integer> list = new LinkedList<>();
		for (int i =1; i <=N; i++) {
			list.add(i);
		}
		
		StringBuilder sb =new StringBuilder("<");
		int idx=0;
		while(list.size()>0) {
			idx +=(K-1);
			idx%=list.size();
			sb.append(list.remove(idx)+", ");
		}
		sb.delete(sb.length()-2,sb.length());
		sb.append(">");
		System.out.println(sb.toString());
		
		
	}
}
