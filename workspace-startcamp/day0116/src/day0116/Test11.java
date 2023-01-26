package day0116;

public class Test11 {
	public static void main(String[] args) {
		int[] array= {10,11,12};
		int n=13;
		
		 int[] answer =new int[array.length];
        for(int i=0; i<array.length; i++){
            answer[i]= Math.abs(n-array[i]);
            System.out.println(answer[i]);
        }
        int iMin=Math.abs(n-array[0]);
        for(int i : answer ) {
            iMin = Math.min( i, iMin );
            System.out.println(iMin);
        }
        System.out.println(iMin+n);
}
}
