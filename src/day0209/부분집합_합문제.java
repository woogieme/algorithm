package day0209;

import java.util.Scanner;

public class 부분집합_합문제 {
	
	static int N, totalCnt; 
	static int[] input; // 입력받은 수들
	static boolean[] isSelected; //각 원소가 부분집합의 구성에 포함되었는지 여부
	static int value=0;
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		N = sc.nextInt();
		input =new int[N];
		isSelected = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		generateSubSet(0);
		System.out.println("총 경우의 수 "+totalCnt);
		
	}
	private static void generateSubSet(int cnt) { //  cnt : 직전까지 고려된 원소 수
		if(cnt==N) {
			int sum=0;
			for (int i = 0; i < N; i++) {
				if(isSelected[i]) sum+=input[i];
			}
			if(sum==value) {
				totalCnt++;
				for (int i = 0; i < N; i++) {
					if(isSelected[i]) System.out.print(input[i]+"\t");
				}
				System.out.println();
			}
			return ;
		}
		//현재 원소를 부분집합의 구성에 포함
		isSelected[cnt] = true;
		generateSubSet(cnt+1);
		//현재 원소를 부분집합의 구성에 비포함
		isSelected[cnt] = false;
		generateSubSet(cnt+1);
		
	}
}
