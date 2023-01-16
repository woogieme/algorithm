package day0111;

public class Test12 {
	public static void main(String[] args) {
		int age=23;
		String answer = "";
        String value="";
        int tmp=0;
        while (age>0){
            tmp=age%10;
            age/=10;
            value=Integer.toString(tmp);
            System.out.println(value);
        }
        System.out.println(answer);
	}
}
