package project9_2;


/**
 * BookManager 클래스를 이용하여 도서 객체 추가,삭제,조회하는 클래스
 */
import java.io.IOException;
import java.util.Scanner;
public class BookTest {
	public static void main(String[] args) {
		BookManagerImpl bm1 =BookManagerImpl.getInstance();
		bm1.add(new Book("21424","JAVA Pro","김하나","jaen.kr",15000,"JAVA 기본 문법"));
		bm1.add(new Book("35355","JAVA Pro2","김하나","jaen.kr",25000,"JAVA 응용"));
		bm1.add(new Book("44444","ABCD Pro3","소나무","abcd.kr",45000,"ABCD 공부"));
		bm1.add(new Magazine("44445","ABC Pro4","소나무1","abcd.kr",1000,"ABCD 공부1",1,1));
		bm1.add(new Magazine("44446","BCD Pro5","소나무1","abcd.kr",4500,"ABCD 공부2",2,2));
		
		System.out.println("****************도서목록 ***************");
		for(Book b : bm1.getList()) {
			System.out.println(b);
		}
		
		System.out.println("****************잡지 목록 ***************");
		for(Magazine b : bm1.getMagazines()) {
			System.out.println(b);
		}
		
		System.out.println("****************일반 도서 ***************");
		for(Book b : bm1.getBooks()) {
			System.out.println(b);
		}
		
		System.out.println("****************도서 번호 :21424***************");
		System.out.println(bm1.searchByIsbn("21424"));
		
		System.out.println("****************도서 이름:BCD***************");
		for(Book b : bm1.searchByTitle("BCD")) {
			if (b==null) continue;
			System.out.println(b);
		}
		
		System.out.println("****************도서 가격 총합***************");
		System.out.println(bm1.getTotalPrice());

		System.out.println("****************도서 가격 평균 ***************");
		System.out.println(bm1.getPriceAvg());
	}
}
