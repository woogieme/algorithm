package X_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18258_큐2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb =new StringBuilder();
		Queue<Integer> arr = new LinkedList<>();
		int cnt=0;
		int num;
		int last=0;
		while(true) {
			StringTokenizer st =new StringTokenizer(br.readLine()," ");
			switch(st.nextToken()) {
			case "push":
				num = Integer.parseInt(st.nextToken());
				last=num;
				arr.offer(num);
				break;
				
			case "front":
				if(!arr.isEmpty()) {
					
					sb.append(arr.peek()).append('\n');
				}
				else {
					sb.append(-1).append('\n');
				}
				break;
				
			case "back":
				if(!arr.isEmpty()) {
					sb.append(last).append('\n');
				}
				else {
					sb.append(-1).append('\n');
				}
				break;
				
			case "size":
				sb.append(arr.size()).append('\n');
				break;
				
			case "empty":
				if(!arr.isEmpty()) {
					sb.append(0).append('\n');
				}
				else {
					sb.append(1).append('\n');
				}
				break;
				
			case "pop":
				if(!arr.isEmpty()) {
					sb.append(arr.poll()).append('\n');
				}
				else {
					sb.append(-1).append('\n');
				}
				break;
			}

			cnt++;
			if(cnt==N) {
				break;
			}
			
		}
		System.out.println(sb);
		
	}
}
