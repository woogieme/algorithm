package day0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11659_구간합구하기4_Improved {
    static int N;
    static int M;
    static int[] arr;
    static int value=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < arr.length; i++) {
        	arr[i] = arr[i-1]+Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        for (int m = 0; m <M; m++) {

            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            sb.append((arr[j]-arr[i-1])+"\n");
        }
        System.out.println(sb.toString());
    }

}