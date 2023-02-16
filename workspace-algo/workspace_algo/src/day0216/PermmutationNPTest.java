package day0216;

import java.util.Arrays;
import java.util.Scanner;

// nPn 만 가능하다.
public class PermmutationNPTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int[] input  = new int[N];

		for (int i = 0; i < N; ++i) {
			input[i] = sc.nextInt();
		}
		
		//전처리 : 오름차순정렬
		Arrays.sort(input);
		long beforeTime = System.currentTimeMillis();
		do {
			System.out.println(Arrays.toString(input));
		}while(np(input));
		long afterTime = System.currentTimeMillis();
		long secDiffTime = (afterTime - beforeTime)/1000;
		System.out.println("시간차이(m) : "+secDiffTime);
	}
	private static boolean np(int[] input) {
		// TODO Auto-generated method stub
		int n = input.length;
		
		//step1. 뒤쪽부터 꼭대기를 찾는다. (꼭대기 바로 앞이 교환할 자리)
		int i = n - 1;
		while(i>0 && input[i-1]>=input[i]) --i;
		if(i==0) return false;
		
		//step2. 꼭대기 바로 앞(i-1_자리에 교환할 값을 뒤쪽부터 찾는다.
		int j = n-1;
		while(input[i-1]>=input[j]) --j;
		
		//step3. 꼭대기 바로 앞 (i-1)자리와 그 자리값 보다 한단계 큰 수와 교환
		swap(input,i-1,j);
		
		//step4. 꼭대기부터 맨뒤까지 오름차순으로 정렬
		int k = n-1;
		while(i<k) {
			swap(input,i++,k--);
		}
		
		return true;
	}
	private static void swap(int[] input, int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j]= temp;
		
	}
}
