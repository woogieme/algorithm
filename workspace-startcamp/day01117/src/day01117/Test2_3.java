package day01117;

import java.util.Scanner;

public class Test2_3 {
	public static void main(String[] args) {
		int N, M;
		int[] arr;
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 전체 스위치 개수 ex) 10 : 1,2,3....10
		M = sc.nextInt(); // 입력되는 숫자가 M개

		arr = new int[N + 1]; // 스위치 번호가 1번부터라길래 배열 크기 하나 늘려서 0번 빼고 쓰기
		for (int i = 0; i < M; i++) { // 내가 눌러야 하는 M개의 스위치번호 입력받는 반복문
			int input = sc.nextInt(); //이 번호의 배수들을 다 토글해야함.
			//for (int j = 1; (input * i) < N + 1; j++) { // 입력받은 input에 i=1,2,3....
				//arr[input * j] = arr[input * j] == 0 ? 1 : 0;
			//}
			for(int j=input; j<=N; j+=input) { //for문이 항상 1씩 늘어나라는 법은 없음.
				arr[i] = arr[i]==0?1:0;
			}
		}
		for(int i =1; i<=N; i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
