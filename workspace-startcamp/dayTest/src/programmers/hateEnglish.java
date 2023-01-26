package programmers;

import java.util.Map;
import java.util.HashMap;

public class hateEnglish {
	public static void main(String[] args) {
		String numbers="onefourzerosixsevenonefourzerosixsevenonefourzerosixsevenonefourzerosixsevenonefourzerosixsevenonefourzerosixsevenonefourzerosixsevenonefourzerosixsevenonefourzerosixsevenonefourzerosixsevenonefourzerosixsevenonefourzerosixsevenonefourzerosixseven";
        String[] arr = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        int x=0;
        int y=2;
        String answer="";
        int i=numbers.length()-1;
        while(i!=0){
            for(int j=0; j<arr.length; j++){
                if(numbers.substring(x,y).equals(arr[j])){
                	x=y;
                    answer+=String.valueOf(j);
                    break;
                }
            }
            y+=1;
            i-=1;
        }
        
        long tmp=Integer.parseInt(answer);
        System.out.println(tmp);
        
        
    }
}