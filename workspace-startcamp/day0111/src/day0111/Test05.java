package day0111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test05 {
public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int result=Integer.parseInt(br.readLine());
	int TC = Integer.parseInt(br.readLine());
	int compare=0;
	for(int i=0; i<TC; i++) {
		
		String line = br.readLine(); // 10개의 숫자를 하나의 문자열 통으로 입력받기 "1 2 3 4 5 6"
		StringTokenizer st = new StringTokenizer(line);
		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());
		compare+=num1*num2;
	}
	if (compare==result) {
		System.out.println("Yes");
	}
	else {
		System.out.println("No");
	}
}
}
