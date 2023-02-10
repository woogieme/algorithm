package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1748_S4 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int count=1;
		int sum=0;
		while (true) {
			if(N>(Math.pow(10, count)-1)) {
				sum+=(((Math.pow(10, count)-1) -(Math.pow(10, count-1))+1))*count;
			}
			else {
				if(count==1) {
					sum+=N;
					break;
				}
				else {
					sum+=((N-Math.pow(10, count-1)+1)*count);
					break;
				}
			}
			count+=1;
		}
		System.out.println(sum);
		
	}
}
