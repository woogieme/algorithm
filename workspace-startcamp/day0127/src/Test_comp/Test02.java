package Test_comp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class Test02 {
	public static void main(String[] args) {
		ArrayList<Book>bookList = new ArrayList<>();
		bookList.add(new Book("21424","JAVA Pro","김하나","jaen.kr",15000,"JAVA 기본 문법",10));
		bookList.add(new Book("35355","JAVA Pro2","김하나","jaen.kr",25000,"JAVA 응용",20));
		bookList.add(new Book("44444","ABCD Pro3","소나무","abcd.kr",45000,"ABCD 공부",30));
		bookList.add(new Book("44445","ABC Pro4","소나무1","abcd.kr",1000,"ABCD 공부1",60));
		bookList.add(new Book("44446","BCD Pro5","소나무1","abcd.kr",4500,"ABCD 공부2",70));
		
		Collections.sort(bookList);
		System.out.print(bookList);
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1:제목오름차순 2:제목내림차순 3:ISBN 4:남은수량수 -1:종료");
			int select = sc.nextInt();
			if (select ==-1 ) {
				System.out.println("종료하였습니다");
				break;
			}
			switch(select){
				case 1:
//					Collections.sort(bookList, new Comparator<Book>() {
//
//						@Override
//						public int compare(Book o1, Book o2) {
//							// TODO Auto-generated method stub
//							return o1.getTitle().compareTo(o2.getTitle());
//						}}); 
					// new Comparator<Book>() {} 에서 {}가 객체임 이것은 무명클래스 , Comparator는 인터페이스임
					//Collections.sort(bookList, (o1,o2)-> { } ; 이게 양팔저울 
					Collections.sort(bookList, (o1,o2)->{ 
						return o1.getTitle().compareTo(o2.getTitle());
						});  //()-> 추론형 , (객체,객체)를 넣을건데 -> 로가서 {안에 있는걸 실행시킬거야}; 
					break;
				case 2:
					Collections.sort(bookList, new Comparator<Book>() {

						@Override
						public int compare(Book o1, Book o2) {
							// TODO Auto-generated method stub
							return o2.getTitle().compareTo(o1.getTitle());
						}
					});
					break;
//				case 3:
//					Collections.sort(bookList, new TitleCompratorAsc());
//					break;
				case 4:
					Collections.sort(bookList, (o1,o2)->{ 
						return o1.getQuantity()-o2.getQuantity();
						}); 
						
//					Collections.sort(bookList, new Comparator<Book>(){
//
//						@Override
//						public int compare(Book o1, Book o2) {
//							// TODO Auto-generated method stub
//							return o1.getQuantity()-o2.getQuantity();
//						}});
					break;
			}
			System.out.println(("----선택 결과----"));
			System.out.println(bookList);
		}
	}
}
//비교자 클래스 - 양팔저울
//class TitleCompratorAsc implements Comparator<Book>{
//	@Override
//	public int compare(Book o1, Book o2) {
//		// TODO Auto-generated method stub
//		return o1.getTitle().compareTo(o2.getTitle());
//	}
//}
//
//class TitleCompratorDesc implements Comparator<Book>{
//	@Override
//	public int compare(Book o1, Book o2) {
//		// TODO Auto-generated method stub
//		return o2.getTitle().compareTo(o1.getTitle());
//	}
//}
//
//class QuantityComprator implements Comparator<Book>{
//	@Override
//	public int compare(Book o1, Book o2) {
//		// TODO Auto-generated method stub
//		return o1.getQuantity()-o2.getQuantity();
//	}
//}
//
//











