package day0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11660_구간합구하기5 {
    static int N;
    static int M;
    static int[][] arr;
    static int[][] brr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        brr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(i == 0 && j==0){
                    brr[i][j]=arr[i][j];
                }
                else if (i!=0 && j==0){
                    brr[i][j]+=brr[i-1][arr.length-1]+arr[i][j];
                }
                else {
                    brr[i][j] += (arr[i][j] + brr[i][j - 1]);
                }
            }
        }
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(brr[i][j]+" ");
//            }
//            System.out.println();
//        }
        for (int i = 0; i < M; i++) {
            int value=0;
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken())-1;
            int y1 = Integer.parseInt(st.nextToken())-1;
            int x4 = Integer.parseInt(st.nextToken())-1;
            int y4 = Integer.parseInt(st.nextToken())-1;
            if(x1==x4 && y1==y4){
                value+= arr[x4][y4];
            }
            else if(x1==y1 && x4==y4 && y4 == arr.length-1 && x1==0){
                value += brr[x4][y4];
            }
            else if(y1!=0){
                for (int j = x1; j <= x4; j++) {
                    value+=brr[j][y4]-brr[j][y1-1];
                }
            }
            else {
                for (int j = x1; j <= x4; j++) {
                    if(j==0){
                        value+=brr[j][y4];
                    }
                    else{
                        value+=brr[j][y4]-brr[j-1][arr.length-1];
                    }
                }
            }
            sb.append(value);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}