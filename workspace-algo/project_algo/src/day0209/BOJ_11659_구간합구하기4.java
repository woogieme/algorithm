package day0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11659_구간합구하기4 {
    static int N;
    static int M;
    static int[] arr;
    static int value=0;
    static int[] brr;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        brr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i]= Integer.parseInt(st.nextToken());
            if(i!=0){
                brr[i]+=arr[i]+brr[i-1];
            }
            else {
                brr[i] += arr[i];
            }
        }
        for (int i = 0; i < M; i++) {
            value=0;
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken())-1;
            int Y = Integer.parseInt(st.nextToken())-1;
            if(X==0){
                value=brr[Y];
            }
            else if(X==Y){
                value=arr[X];
            }
            else{
                value=brr[Y]-brr[X-1];
            }
            System.out.println(value);
        }
    }

}