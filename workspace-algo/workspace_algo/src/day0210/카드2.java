package day0210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 카드2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		Stack<Integer> arr =new Stack<>();
		for (int i = T; i >=1; i--) {
			arr.push(i);
		}
		Stack<Integer> brr =new Stack<>();
		Stack<Integer> crr =new Stack<>();
		if(T!=1) {
		while(true) {
			while(!arr.isEmpty()) {
				arr.pop();
				if(arr.isEmpty()) {
					break;
				}
				brr.push(arr.pop());
			}
		
			if(brr.size()==1) {
				System.out.println(brr.peek());
				break;
			}
			while(!brr.isEmpty()) {
				arr.push(brr.pop());
			}
		}
		}
		else {
			System.out.println(1);
		}
	}
}
