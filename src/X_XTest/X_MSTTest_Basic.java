package X_XTest;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class X_MSTTest_Basic {
	static int N;
	static int[] disjoint;
	public static void main(String[] args) {
		N=10;
		disjoint = new int[N];
		makeSet(); //각자 대장을 할수있게 임무부여
		union(1,3);
		System.out.println(Arrays.toString(disjoint));
		
	}
	private static void union(int a, int b) {
		//난 병합할거야
		int a_boss = find(a); // a의 대장 찾아서 a에다가 갖다박아 
		int b_boss = find(b);
		//왜 대장을 찾아야해? => 합병할려면 대장들끼리 합쳐야하거든
		
		disjoint[a_boss] =b_boss;
		//a의 보스는 a 였고 ,b의 보스는 b라고 가정했을때
		//b의보스가 a를 이겼기때문에  b의 보스가 a보스를 이겼다 라는 의미 
		
	}
	private static int find(int boss) {
		if(boss==disjoint[boss]) return boss; //boss, 즉 Index가 disjoint[boss]와 똑같다면
											// 0 1 2 3 4 5 6 7 8 9 그냥 인덱스
											// 0 1 2 3 4 4 4 7 8 9 인덱스 안에 보스가 있어요 !! 라는의미 4,5,6의 보스는 4이다.
											//그렇다면 5의보스는 4이기때문에 boss==disjoint[boss] 가 될수없다
											//5의보스를 찾고싶어요 라는 의미의 find 
		//if문에서 보스를 찾지못했을때
		return find(disjoint[boss]); // 5의보스는 4이니까  5는 4의 부하, 그렇다면 4는 그 집합의 부하인가 대장인가 찾아야하니까 또 4의 상사를 찾으러가자!!! 
	}
	private static void makeSet() {
		for (int i = 0; i < N; i++) {
			disjoint[i]=i;
		}
		
	}
	
}
