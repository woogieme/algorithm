package day_0206;

public class RecursionTest {
	public static void main(String[] args) {
		System.out.println("1번 답 pr ---------------------");
//		1. 1부터 9까지 출력하기
		pr(0);
		System.out.println("2번 답 doSUm---------------------");
//		2. 1부터 10까지의 합을 출력하는 재귀함수를 만드시오?
		doSum(0,10);
		System.out.println("3번 답 fact---------------------");
//		3. 팩토리얼
		int result = fact(0);
		System.out.println(result);	
		System.out.println("4번 답 digiSum---------------------");
//		4. 자연수를 넣어 그 각자리의 수의 합을 반환하는 재귀함수를 만들어라
		int sum = digitSum(12356,0);
		System.out.println("sum:" + sum);
		System.out.println("5번 답 doStringComma---------------------");
//		5. 문자열을 전달받아 그문자사이에 ,를 결합하여 반환하는 재귀함수를 만들어라
		String s = doStringComma("korea","");
//		k,o,r,e,a
		System.out.println(s);
		System.out.println("6번 답 fibo---------------------");
//		6. 피보나치수열 10개를 출력하라
		for(int i = 1; i <= 10;i++) {
			System.out.println(fibo(i));
		}
		System.out.println("7번 답 doMakeBinary"
				+ "---------------------");
//		7. 2진수 3자리를 구성할 수 있는 재귀함수를 만들어라
		doMakeBinary(0,"");
		System.out.println("끝---------------------");
		}
		public static void doMakeBinary(int digit, String result) {
			if (digit==3) {
				System.out.println(result);
				return;
			}
			else {
				doMakeBinary(digit+1,result+"0");
				doMakeBinary(digit+1,result+"1");
			}
		
			
		}
		
		public static int fibo(int num) {
			if(num==1 || num==2) {
				return 1;
			}
			else {
				return fibo(num-1)+fibo(num-2);
			}
			
		}
		public static String doStringComma(String s, String result) {
			if(s.length()==1) {
				result+=s.charAt(0);
				return(result);
			}
			result+=s.charAt(0);
			s=s.substring(1,s.length());
			return doStringComma(s,result+",");
			
		}
		
		public static int digitSum(int data, int sum) {
			if(data<10) {
				return sum+data;
			}
			sum+= data%10;
			data/=10;
			return  digitSum(data,sum);
		}
		
		
		static int fact(int num) {
			if (num==0)
			{
				return 1;
			}
			else {
				return num*fact(num-1);
			}
			
		}
		public static void doSum(int sum,int num) {
			if(num!=0) {
				doSum(sum+num,num-1);
			}
			else {
				System.out.println(sum);
			}
			
		}
	//	 숫자 출력예제
		public static void pr(int num) {
			if(num<10) {
				System.out.println("num"+" : "+num);
				pr(num+1);
			}
		}
}
