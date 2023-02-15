package day0213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9012_괄호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int z=0; z<tc; z++) {
		char[] arr = br.readLine().toCharArray();
		Stack<Character> st = new Stack<>();
		boolean isFlag=true;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]=='(') {
				st.add(arr[i]);
			}
			else {
				if(st.isEmpty()) {
					isFlag=false;
					break;
				}
				st.pop();
			}
		}
		if(isFlag  && st.isEmpty()) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
		}
	}
}
