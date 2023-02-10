 package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ11866_S5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int key=Integer.parseInt(st.nextToken())-1;
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			arr.add(i+1);
		}
		
		ArrayList<Integer> yose = new ArrayList<>();
		int count=0;
		while(arr.size()!=0) {
			
			if(count==key) {
				
				int tmp=arr.remove(0);
				yose.add(tmp);
				
				count=0;
				continue;
			}
			else {

				for (int i = 1; i < arr.size(); i++) {
					Collections.swap(arr, i-1, i);
				}
			}
			count+=1;
			
		}
		System.out.print("<");
		for (int i = 0; i < yose.size(); i++) {
			if (i!=yose.size()-1) {
			System.out.print(yose.get(i)+", ");
			}
			else {
					System.out.println(yose.get(i)+">");
				}
			}
		
		
		
	}
}
