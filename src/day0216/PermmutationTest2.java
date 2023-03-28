package day0216;

import java.util.Arrays;
import java.util.Scanner;

public class PermmutationTest2 {
	static int N,R;
	static int[] numbers, input;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		numbers = new int[R];
		input = new int[N];
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		permutation(0,0);
	}
	private static void permutation(int cnt,int flag) {
		if(cnt==R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = 0; i < N; i++) {
			if((flag & (1<<i)) != 0) continue;
			numbers[cnt]= input[i];
			permutation(cnt+1,flag|1<<i);
			
			
		}
		
	}
}
