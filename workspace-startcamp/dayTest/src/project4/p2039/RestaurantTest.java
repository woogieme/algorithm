package project4.p2039;

public class RestaurantTest {
	public static void main(String[] args) {
		Restaurant r1 = new Restaurant(101,"을밀대","서울","냉면",4);
		Restaurant r2 = new Restaurant(401,"도마29","대구","연어초밥",3);
		System.out.println("====================맛집목록====================");
		System.out.println(r1.toString());
		System.out.println(r2.toString());
		
		System.out.println("====================리뷰목록====================");
		Review rv1 = new Review(1,101,"김싸피","너무 맛있네요.");
		Review rv2 = new Review(2,401,"나싸피","연어초밥은 여기가 최고!");
		System.out.println(rv1.toString());
		System.out.println(rv2.toString());
	}
	
	
	
	

}
