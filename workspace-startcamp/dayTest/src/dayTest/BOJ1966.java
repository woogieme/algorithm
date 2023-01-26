package dayTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1966 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=TC; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[] array = new int[N];
			int[] count = new int[N];
			int key = Integer.parseInt(st.nextToken());
			st= new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				array[j]= Integer.parseInt(st.nextToken());
				count[j]=j;
			}//end for arrays
			int result=1;
			int value=0;
			for (int x=0; x<array.length; x++) {
				
				boolean isFlag=false;
				int max =  Arrays.stream(array).max().getAsInt();
				if(array[value]!=max) {
					while(array[value]!=max) {
						int alpha=array[value];
						int beta =count[value];
						for (int y = 1; y < count.length; y++) {
							
							array[y-1]=array[y];
							count[y-1]=count[y];
						}//end for array,count
						result+=1;
						array[array.length-1]=alpha;
						count[array.length-1]=beta;
					}//end for while
				}//end for if
				else {
					
					if (key==count[0]) {
						isFlag=true;
						break;
					}//end for key ==count
					else{
						value+=1;
					}//end for else
				} // end for else
				if (isFlag==true) {
					break;
				}
			}//end for x
			System.out.println(result);
		}//end for TC
	}//end for main

}
