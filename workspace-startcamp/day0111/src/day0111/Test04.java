package day0111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test04 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		int tmp=0;
		for (int i=1; i<=TC; i++) {
			tmp+=i;
		}
		System.out.println(tmp);
	}
}

