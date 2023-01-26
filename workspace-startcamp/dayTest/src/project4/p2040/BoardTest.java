package project4.p2040;

import java.util.Date;

public class BoardTest {
	public static void main(String[] args) {
		Date today = new Date();
		User user1 = new User(0,"ssafy","1234","김싸피","김싸피","ssafy@ssafy.com");
		User user2 = new User(1,"hong","hong","홍싸피","홍홍","abcd@ssafy.com");
		User user3 = new User(2,"samsic","samsic","김삼식","김싸피","efgh@ssafy.com");
		User user4 = new User(3,"happy","happy","이싸피","이사장","gdfg@ssafy.com");
		
		Article arti1= new Article(0,"공지사항","게시글 내용",0,0,today);
		Article arti2= new Article(1,"코딩테스트란","게시글 내용",1,0,today);
		Article arti3= new Article(2,"취뽀는 나에게","게시글 내용",2,0,today);
		Article arti4= new Article(3,"완전정복","게시글 내용",3,0,today);
		
		Comment c1 = new Comment(0,1,5,"잘 보았습니다",today);
		Comment c2 = new Comment(1,1,4,"좋은 글입니다.",today);
		
		System.out.println("User 출력");
		System.out.println("------------------------------------");
		System.out.println(user1.toString());
		System.out.println(user2.toString());
		System.out.println(user3.toString());
		System.out.println(user4.toString());
		System.out.println();
		System.out.println("Article 출력");
		System.out.println("------------------------------------");
		System.out.println(arti1.toString());
		System.out.println(arti2.toString());
		System.out.println(arti3.toString());
		System.out.println(arti4.toString());
		System.out.println();
		System.out.println("Comment 출력");
		System.out.println("------------------------------------");
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		System.out.println();
	}
}
