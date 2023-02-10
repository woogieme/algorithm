package day0209;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.MAX_VALUE;

public class TEST_재욱이의_조합 {
    static int N=3;
    static int[] arr= {1,2,3,4,5,6};
    static int[] brr =new int[N];
    static  boolean[] crr;
    public static void main(String[] args) throws IOException{
    	comb(0,0);
    
    	//comb2(0,0);
    }


    private static void comb(int idx, int cnt) { //idx는 졸라맨이 있는 인덱스, cnt는 졸라맨이 가리키고싶어하는 인덱스 , 졸라맨이 있는 인덱스가 꽉차면 조합완성 !!, 졸라맨이 가리키고싶어하는 인덱스가 없으면 도망가 !!
    	if(idx==N) {
    		System.out.println(Arrays.toString(brr));
    	}
    	if(cnt==arr.length) {

    		return;
    	}
    	brr[idx]=arr[cnt];
    	comb(idx+1,cnt+1);
    	
    	comb(idx,cnt+1);
    	
    	
	}
    
    private static void comb2(int idx, int cnt) { //idx는 졸라맨이 있는 인덱스, cnt는 졸라맨이 가리키고싶어하는 인덱스 , 졸라맨이 있는 인덱스가 꽉차면 조합완성 !!, 졸라맨이 가리키고싶어하는 인덱스가 없으면 도망가 !!
    	if(cnt==N) {
    		System.out.println(Arrays.toString(brr));
    		return;
    	}
    	if(idx==N) {
    		
    		return;
    	}
    	brr[idx]=arr[cnt];
    	comb(idx+1,cnt+1);
    	comb(idx,cnt+1);
    	
    	
	}
}