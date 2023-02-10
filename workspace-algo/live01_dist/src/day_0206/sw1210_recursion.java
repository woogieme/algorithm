package day_0206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw1210_recursion {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //start for array Start
        int[][] arr = new int[100][100];
        for(int tc =1; tc<=10; tc++) {
        	int tmp=Integer.parseInt(br.readLine());
	        for (int i = 0; i < 100; i++) {
	            StringTokenizer st = new StringTokenizer(br.readLine());
	            for (int j = 0; j < 100; j++) {
	                arr[i][j] = Integer.parseInt(st.nextToken());
	            }
	        }//end for array Input
	        
	        for (int i = 0; i < 100; i++) {
	        	int brr[][] = new int[arr.length][arr[0].length];
	        	for(int x=0; x<brr.length; x++){
	                System.arraycopy(arr[x], 0, brr[x], 0, arr[0].length);
	            }
	            if (brr[0][i] == 1) {
	                if(recursion(brr, 0, i)==1){
	                    System.out.println("#"+tc+" "+i);
	                    break;
	                }
	            }
	
	        }
    }

    }//end for tc

    private static int recursion(int[][] brr, int x, int y) {
        if (x == brr.length - 1) {
            if (brr[x][y] == 3) {
                return 1;
        	}
            	return 0;
    	}
        if(y+1<=brr.length-1 && brr[x][y+1]==1) {
        	brr[x][y+1]+=1;
        	return recursion(brr,x,y+1);
        }
        else if(y-1>=0 && brr[x][y-1]==1) {
        	brr[x][y-1]+=1;
        	return recursion(brr,x,y-1);
        }
        brr[x+1][y]+=1;
        return recursion(brr,x+1,y);
	}
    
}
//else if(y-1>=0){
//if(arr[x][y-1]==1) {
//return recursion(arr,x,y-1);
//}
//else {
//	return recursion(arr,x+1,y);
//}
//}
////////////////////////////////////////////
//if(y-1>=0 && y+1<= brr.length-1){
//if (brr[x][y+1]==1) {
//	brr[x][y+1]=3;
//	return recursion(brr,x,y+1);
//}
//else if(brr[x+1][y]==1) {
//	 return recursion(brr,x+1,y);
//	}
//else if(brr[x][y-1]==1){
//	return recursion(brr,x,y-1);
//}
//else if(brr[x+1][y]==1) {
// return recursion(brr,x+1,y);
//}
//}
////////////////////////////////////
////오른쪽 대각선 1검사 
//if(y+1<= arr.length-1 && arr[x+1][y+1]==1 ){
//      return recursion(arr,x+1,y+1);
//}
////오른쪽 1 검사
//else if(y+1<= arr.length-1 && arr[x][y+1]==1){
//      return recursion(arr,x,y+1);
//}
////왼쪽 대각선 1검사
//else if(y-1>=0 &&arr[x + 1][y - 1] == 1){
//      return recursion(arr,x+1,y-1);
//  }
////왼쪽 1 검사
//else if(y-1>=0 && arr[x][y-1]==1){
//      return recursion(arr,x,y-1);
//}