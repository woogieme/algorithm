package day0227;

import java.util.Arrays;

public class DisjointSet2 {
	static int[] disjoint;
	static int N;
	public static void main(String[] args) {
		N=10;
		makeSet();
		
		System.out.println(Arrays.toString(disjoint));
		
		union(1,2);
		union(3,4);
		union(5,6);
		union(1,3);
		union(2,5);
		union(9,3);
		union(7,10);
		union(7,1);
		for (int i = 1; i <=N; i++) {
			System.out.print(find(i)+" ");
		}
		System.out.println();
		System.out.println(Arrays.toString(disjoint));
		union(1,8);
	}
	static void makeSet() {
		disjoint=new int[N+1];
		for (int i = 1; i <=N; i++) {
			disjoint[i]=i;
		}
	}
	static int find(int i) {
		if(i==disjoint[i]) //disjoin[4]칸에 4라고 들어있으면 얘는 대표임 .
			return i;
		else //disjoin[4]번칸에 5라고 들어있었어 , 그러면 5를 집어넣고 다시 find(5)함. - 부모를 찾는행위 [재귀]
			//재귀 호출해놓고 기다리면 언젠가 대표번호 리턴옴. 그걸 내칸에 다이렉트로 대표 전화번호 저장!!!
			return disjoint[i] =find(disjoint[i]);
	}
	static boolean union(int n1,int n2) {
		int p1= find(n1); //n1이 소속된 그룹의 대표를 일단 찾아라 (말단끼리 합병 못함)
		int p2= find(n2); //n1이 소속된 그룹의 대표를 일단 찾아라 (말단끼리 합병 못함)
		
		if(p1==p2) { // n1이 어느대표 소속인지, n2가 어느대표 소속인지 봤더니 뭐야 얘ㅖ네 이미 같은 회사야 
			return false;
		}
		disjoint[p1]=p2; //병합 
		return true;
	}
}
