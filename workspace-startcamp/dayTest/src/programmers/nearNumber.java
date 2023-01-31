package programmers;

import java.util.Arrays;

public class nearNumber {
	public static void main(String[] args) {
		int[] array= {4,2};
		int n =5;
        Arrays.sort(array);
        int [] array_abs=new int[array.length];
        for (int i=0; i< array.length; i++){
            array_abs[i]=Math.abs(n-array[i]);
        }
        int tmp=0;
        int k=0;
        System.out.println(array_abs[0]);
        System.out.println(array_abs[1]);
        for(int i=0; i<array.length; i++){
            if(i==1){
                tmp=array_abs[i];
                k=i;
                continue;
            }

            if (tmp>array_abs[i]){
                tmp=array_abs[i];
                k=i;
            }

        }
        System.out.println(array[k]);
		
		
		
	}
}
