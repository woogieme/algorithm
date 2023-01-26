package dayTest;

import java.util.ArrayList;
import java.util.Scanner;

public class day0118 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		ArrayList<Integer> answer = new ArrayList<Integer>();
		for(int i=0; i<TC; i++) {
			int N = sc.nextInt();
			if (N==0) {
				answer.remove(answer.size()-1);
			} //end for if
			else {
				answer.add(N);
			} // end for else
			
		}//end for i
		
		int result=0;
		for (int arr : answer) {
			result+=arr;
		}
		System.out.println(result);
		
	}//end for main
}
