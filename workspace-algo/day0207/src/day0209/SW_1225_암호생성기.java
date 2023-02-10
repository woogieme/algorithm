package day0209;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SW_1225_암호생성기 {
	static int[] numbers = new int[8];
	static int answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);


		for (int t = 1; t <= 10; t++) {
			int tc = sc.nextInt();

			Queue<Integer> numbers = new LinkedList<>();
			for (int i = 0; i < 8; i++) {
				numbers.add(sc.nextInt());
			}
			
			int num = 1;
			
			while (true) {
				
				int temp = numbers.poll();
				
				if (temp - num <= 0) {
					numbers.add(0);
					break;
				}

				numbers.add(temp - num++);
				
				if (num == 6) {
					num = 1;
				}
			}
			System.out.print("#"+t+" ");
			for(int i : numbers) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
}
