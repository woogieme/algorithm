package X_Professor.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2164_카드2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> arr = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			arr.add(i+1);
		}
		while(true) {
			if(arr.size()==1) {
				System.out.println(arr.poll());
				break;
			}
			arr.poll();
			arr.add(arr.poll());
		}

		
	}
}
