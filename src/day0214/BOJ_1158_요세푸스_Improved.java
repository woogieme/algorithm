package day0214;

import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_1158_요세푸스_Improved {
	public static void main(String[] args) {
		Scanner sc  =new Scanner (System.in);
		int N =  sc.nextInt();
		int K = sc.nextInt();
		
		LinkedList<Integer> list = new LinkedList<>();
		for (int i =1; i <=N; i++) {
			list.add(i);
		}
		
		StringBuilder sb =new StringBuilder("<");
		int cnt=0,idx=0;
		while(list.size()>0) {
			int now = list.get(idx);
			cnt++; //1,2,3,1,2,3,1,2,3
			if(cnt==K) {
				//방금 idx에 있던 병사를 죽여서 뒤에 애들이 idx로 땡겨져왔음. idx로 땡겨져왔음
				list.remove(idx);
				sb.append(now+", ");
				cnt=0;
				idx--; //idx 자리 다시한번봐야함 
			}
			idx++; // 0,1,2,3,4,5,6,0,1,2,3,4.......
			if(list.size()==0)break;
			idx = idx%list.size();
		}
		sb.delete(sb.length()-2,sb.length());
		sb.append(">");
		System.out.println(sb.toString());
		
		
	}
}
