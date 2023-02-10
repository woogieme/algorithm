package day0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_16969_차량번호판1 {
	static char[] input_string;
	static char[] chars;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		input_string = sc.next().toCharArray();
		chars = new char[input_string.length];
		answer = 0;
		perm(0);
		System.out.println(answer);
	}

	private static void perm(int idx) {
		if (idx == input_string.length) {
			for (int i = 0; i < input_string.length - 1; i++) {
				if (chars[i] == chars[i + 1]) {
					return;
				}
			}
			answer += 1;
		} else {
			if (input_string[idx] == 'c')
				for (int i = 0; i < 26; i++) {
					chars[idx] = (char) (i + 'a');
					perm(idx + 1);
				}
			else {
				for (int i = 0; i <= 9; i++) {
					chars[idx] = (char) (i + '0');
					perm(idx + 1);
				}
			}
		}
	}
}
