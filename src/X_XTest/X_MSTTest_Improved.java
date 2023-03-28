package X_XTest;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class X_MSTTest_Improved {
	static int N;
	static int[] disjoint;
	public static void main(String[] args) {
		N=10;
		disjoint = new int[N];
		makeSet(); //각자 대장을 할수있게 임무부여
		int count=0;
		//두번쨰 의문점을 해결 하기위해선 union(1,3)가 아닌 true,false로 만들어줘야한다.  
		if(union(1,3)) {
			count+=1; // 나 합병했어요라는 의미로 count 혹은 출력을 해준다.
		}
		
		
		System.out.println(Arrays.toString(disjoint));
		
	}
	//MSTTEST_Basic을 보고와라
	//첫번째 의문점
	//0 1 2 3 4 5 6 7 8 9 
	//0 2 3 4 5 6 7 8 9 9 일때 1의 보스를 찾기위해선 9까지 재귀를 돌려야한다
	//1.서로소 집합에서 한번에 boss를 찾는 법은 없을까?
	//두번째 의문점
	//0 1 2 3 4 5 6 7 8 9
	//0 2 2 2 2 5 5 5 5 5 일때 1,3은 보스가 같다. 하지만 항상 boss찾아서 같은지 판별해야한다 
	//2.겹치는 집합이면 굳이 계산안하는 방법은 있지 않을까? 
	
	//두번째 의문점 해결 void가 아닌 boolean으로 바꾸어준다
	private static boolean union(int a, int b) {
		//난 병합할거야
		//왜 대장을 찾아야해? => 합병할려면 대장들끼리 합쳐야하거든
		int a_boss = find(a); // a의 대장 찾아서 a에다가 갖다박아 
		int b_boss = find(b);
		
		//보스가 똑같은데 굳이 출력해줘야해? 아니 난 안할건데??? 하지마~~
		if(a_boss==b_boss) {
			return false;
		}
		//a의 보스는 a 였고 ,b의 보스는 b라고 가정했을때
		//b의보스가 a를 이겼기때문에  b의 보스가 a보스를 이겼다 라는 의미
		disjoint[a_boss] =b_boss;
		return false;
		
	}
	private static int find(int boss) {
		if(boss==disjoint[boss]) return boss; //boss, 즉 Index가 disjoint[boss]와 똑같다면
											// 0 1 2 3 4 5 6 7 8 9 그냥 인덱스
											// 0 1 2 3 4 4 4 7 8 9 인덱스 안에 보스가 있어요 !! 라는의미 4,5,6의 보스는 4이다.
											//그렇다면 5의보스는 4이기때문에 boss==disjoint[boss] 가 될수없다
											//5의보스를 찾고싶어요 라는 의미의 find 
		//if문에서 보스를 찾지못했을때
		// 5의보스는 4이니까  5는 4의 부하, 그렇다면 4는 그 집합의 부하인가 대장인가 찾아야하니까 또 4의 상사를 찾으러가자!!!
		
		
		//return find(disjoint[boss]);
		//첫번째 의문점 해결 
		//0 1 2 3 4 5 6 7 8 9 인덱스
		//0 2 3 4 5 6 7 8 9 9 인덱스 보스라면
		//find(1)을했을때, 재귀가 끝날때 disjoin[boss]를 심어준다
		//1. find(disjoint[boss])는 보스 호출후 보스값을 return 해준다
		//2. 그전 재귀는 boss=7, disjoint[boss]=8이였다면, disjoint[boss] (8) <= find(disjoint[boss]) (9) 로 되어 
		//3. boss=7, disjoint[boss]=9가 되는것이다. 
		//즉 한번의 호출로 모든 보스를 정해줄수있다. 
		return disjoint[boss]=find(disjoint[boss]); 
	}
	private static void makeSet() {
		for (int i = 0; i < N; i++) {
			disjoint[i]=i;
		}
		
	}
	
}
