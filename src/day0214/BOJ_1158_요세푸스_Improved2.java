package day0214;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1158_요세푸스_Improved2 {
	public static void main(String[] args) {
		Scanner sc  =new Scanner (System.in);
		int N =  sc.nextInt();
		int K = sc.nextInt();
		
		Queue<Integer> queue = new LinkedList<>();
		for (int i =1; i <=N; i++) {
			queue.add(i);
		}
		
		StringBuilder sb =new StringBuilder("<");
		int cnt=0;
		while(!queue.isEmpty()) {
			int now = queue.poll();
			cnt++;
			if(cnt==K) {
				sb.append(now+", ");
				cnt=0;
			}
			else {
				queue.add(now);
			}
		}
		sb.delete(sb.length()-2,sb.length());
		sb.append(">");
		System.out.println(sb.toString());
		
		
	}
}
