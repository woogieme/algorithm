package day0116;

public class Test03 {
// 다음은 5x5의 2차원 배열을 나타낸다. 각 항목의 숫자 중 3의 배수의 개수와 합을 구하는 코드를 작성하시오.
	public static void main(String[] args) {
		int[][] arr =new int[5][5];
		
		int count=1;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<i; j++) {
				System.out.print(" "+" ");
			}
			for(int j=arr.length-i; j>0; j--) {
				System.out.print(count+" ");
				count+=1;
			}
			System.out.println();
		}
	}
}
