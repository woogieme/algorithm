package day0116;

public class Test02 {
	public static void main(String[] args) {
		String org="SSAFY";
		char[] chars=new char[org.length()];
		for (int i = 0; i < chars.length; i++) {
			chars[i]=org.charAt(i);
		}
		
		for (int i = 0; i < chars.length; i++) {
			System.out.println(chars[i]);
		}
		
		chars=org.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			System.out.println(chars[i]);
		}
	}
}
