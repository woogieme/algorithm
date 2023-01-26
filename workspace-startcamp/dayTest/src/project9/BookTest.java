package project9;
import java.io.IOException;
import java.util.Scanner;
public class BookTest {
	public static void main(String[] args) throws QuantityException,ISBNNotFoundException {
		BookManagerImpl bm1 =BookManagerImpl.getInstance();
		bm1.add(new Book("21424","JAVA Pro","김하나","jaen.kr",15000,"JAVA 기본 문법",10));
		bm1.add(new Book("35355","JAVA Pro2","김하나","jaen.kr",25000,"JAVA 응용",20));
		bm1.add(new Book("44444","ABCD Pro3","소나무","abcd.kr",45000,"ABCD 공부",30));
		bm1.add(new Magazine("44445","ABC Pro4","소나무1","abcd.kr",1000,"ABCD 공부1",1,1,20));
		bm1.add(new Magazine("44446","BCD Pro5","소나무1","abcd.kr",4500,"ABCD 공부2",2,2,50));
		
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
		System.out.println("****************도서  판매 21424,11개 ***************");
		try {
			bm1.sell("21426", 11);
			
		}catch(QuantityException e){
			System.out.println(" 수량이 부족합니다");
		}catch(ISBNNotFoundException e){
			System.out.println("ISBN이 맞지않습니다");
			//e.printStackTrace();
		}
		
		System.out.println("****************도서  판매 21424,50개 ***************");
		try {
			bm1.sell("21424", 50);
			
		}catch(QuantityException e){
			System.out.println(" 수량이 부족합니다");
		}catch(ISBNNotFoundException e){
			System.out.println("ISBN이 맞지않습니다");
			//e.printStackTrace();
		}
		
		System.out.println("****************도서  구매 21424,11개 ***************");
		try {
			bm1.buy("21424", 500);
			System.out.println(bm1.searchByIsbn("21424"));
			
		}catch(ISBNNotFoundException e){
			System.out.println(e.getMessage());
		}
		System.out.println("****************도서  판매 21424,5개 ***************");
		try {
			bm1.sell("21424", 5);
			System.out.println(bm1.searchByIsbn("21424"));
			
		}catch(QuantityException e){
			System.out.println(e.getMessage());
		}catch(ISBNNotFoundException e){
			System.out.println(e.getMessage());
		}
	}
}
