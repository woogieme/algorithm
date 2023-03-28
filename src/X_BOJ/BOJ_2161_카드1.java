package X_BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2161_카드1 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		StringBuilder sb =new StringBuilder();
		int N = sc.nextInt();
		Queue<Integer> arr = new LinkedList<>();
		for (int i = 1; i <=N; i++) {
			arr.add(i);
		}
		
		while(true) {
			sb.append(arr.poll()).append(" ");
			if(arr.isEmpty()) {
				break;
			}
			arr.add(arr.poll());
		}
		System.out.println(sb);
	}
}
