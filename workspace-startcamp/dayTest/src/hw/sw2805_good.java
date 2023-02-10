package hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw2805_good {
	public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int TC=Integer.parseInt(br.readLine());

        for(int tc=1; tc<=TC; tc++){
            int N= Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];

            for (int i = 0; i < 9; i++) {
                String line = br.readLine();
                for (int j = 0; j < 9;j++) {
                       char ch = line.charAt(j);
                       map[i][j] = ch-'0';
                }//end for k
            }//end for j
            
            int sum=0;
            for (int i = 0; i < N; i++) {
				for(int j=Math.abs(i-(N/2)); j<N-Math.abs(i-N/2); j++) {
					sum +=map[i][j];
				}
			}
            System.out.println("#"+tc+" "+sum);

	}
}	
}