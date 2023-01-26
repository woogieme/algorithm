package test02;

public class Test {
	public static void main(String[] args) {
		BoxObject obx= new BoxObject();
		
		obx.setData(100);
		//obx.setData("String"); 오류
		
		System.out.println((Integer)obx.getData()+10);
		
		BoxGeneric<Integer> gbx = new BoxGeneric<Integer>();
		BoxGeneric<String> gbx1 = new BoxGeneric<String>();
		gbx.setData(100);
		gbx1.setData("String");
		
		System.out.println(gbx.getData()+54221);
		System.out.println(gbx1.getData()+" is Freedom");
		
	}
}
