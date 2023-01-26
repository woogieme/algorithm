package day0116;

public class Test07 {
	public static void main(String[] args) {
		int[][] arr =new int[5][5];
				
		int count=1;
		int tmp=0;
		for(int i=0; i<3; i++) {
			for(int j=0; j<i; j++) {
				System.out.print(" "+" ");
			}
			for(int j=0; j<arr.length-tmp; j--) {
				System.out.print(count+" ");
				count+=1;
			}
			tmp+=2;
			System.out.println();
		}
	}
}
