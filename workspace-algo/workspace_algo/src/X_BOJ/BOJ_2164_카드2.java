package X_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2164_카드2 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> cards= new LinkedList<>();
		
		for (int i = 1; i <=N; i++) {
			cards.add(i);
		}
		while(true) {
			if(cards.size()==1) {
				System.out.println(cards.peek());
				break;
			}
			else {
				cards.remove();
				cards.add(cards.remove());
			}
			
		}
	}

}
