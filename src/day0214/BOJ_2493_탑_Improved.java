package day0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493_탑_Improved {
	static class Tower{
		int num, height;

		public Tower(int num, int height) {
			this.num = num;
			this.height = height;
		}

		@Override
		public String toString() {
			return "Tower [num=" + num + ", height=" + height + "]";
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Stack<Tower> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <=N; i++) {
			Tower now = new Tower(i, Integer.parseInt(st.nextToken()));
			
			//스택비었는데 pop하면 오류 and 나보다 큰놈이 들어오는것
			//스택에(나보다 왼쪽에 있던) 작은 놈들은 다 치워, 계속 치워, 그러면 비거나 큰놈일때 반복 종료 
			while(!stack.isEmpty() && stack.peek().height < now.height) {
				stack.pop();
			}
			
			if(stack.isEmpty()) { //결국 다 쪼마니들이었네
				sb.append("0 ");
			}
			else {
				sb.append(stack.peek().num+" ");
			}
			stack.push(now);
		}
		System.out.println(sb.toString());
	}
}
