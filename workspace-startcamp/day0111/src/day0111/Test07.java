package day0111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test07 {
	public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Input your socre >> ");
			int score=Integer.parseInt(br.readLine());
			
			/*if (score<=100 && score>=90) {
				System.out.println("grade A");
			}
			else if (score<=80) {
				System.out.println("grade B");
			}
			else if (score<=70) {
				System.out.println("grade C");
			}
			else if (score<=60){
				System.out.println("grade D");
			}
			else {
				System.out.println("grade F");
			}
			*/
			switch(score/10) { //switch(여기에는 정수 변수만 가능했었으나 자바7부터는 문자열도 가능해짐.)
			case 10:
			case 9:
				System.out.println("grade A");
				break;
			case 8:
				System.out.println("grade B");
				break;
			case 7:
				System.out.println("grade C");
				break;
			case 6:
				System.out.println("grade D");
			default:
				System.out.println("grade F");	
				break;
			}
	}
}
