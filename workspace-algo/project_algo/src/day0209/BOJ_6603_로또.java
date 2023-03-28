package day0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_6603_로또 {
    static int[] numbers;
    static int[] result;
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T = Integer.parseInt(st.nextToken());
            if(T==0){
                break;
            }
            numbers = new int[T];
            result= new int[6];
            for (int i = 0; i < T; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }
            comb(0,0);
            System.out.println();
        }




    }

    private static void comb(int idx, int cnt) {
        if(idx==6){
            for (int i = 0; i < idx; i++) {
                System.out.print(result[i]+" ");
            }
            System.out.println();
            return;
        }
        for (int i = cnt; i < numbers.length; i++) {
            result[idx]=numbers[i];
            comb(idx+1,i+1);
        }

    }
}