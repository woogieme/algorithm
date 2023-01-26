package day01117;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BookTest {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Book b1 = new Book("21245","Java Pro","김하나","jaen.kr",15000,"Java 기본 문법");
		Book b2 = new Book("35355","분석설계","소나무","jaen.kr",30000,"SW 모델링");
		
		System.out.println("****************도서목록 ***************");
		System.out.println(b1.toString());
		System.out.println(b2.toString());
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		int tmp = Integer.parseInt(br.readLine());
		
	}
}
