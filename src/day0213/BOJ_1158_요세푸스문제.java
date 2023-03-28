package day0213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1158_요세푸스문제 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {
			list.add(i+1);
		}
		int M=K-1;
		int idx=0,i=0;
		sb.append("<");
		while(true) {
			if(idx==M) {
				sb.append(list.remove(i)+", ");
				idx%=M;
				continue;
			}
			if(list.size()==1) {
				sb.append(list.remove(0)+">");
				break;
			}
			i+=1;
			idx+=1;
			i%=list.size();
		}
		System.out.println(sb);
	}
}
