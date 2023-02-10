package day0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_6603_로또2_Improved {
    static int[] cards;
    static StringBuilder sb;
    static boolean[] select;
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder("");
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            T = Integer.parseInt(st.nextToken());
            if(T==0){
                break;
            }
            cards = new int[T];
            select = new boolean[T];
            for (int i = 0; i < T; i++) {
            	cards[i] = Integer.parseInt(st.nextToken());
            }
            comb(0,0);
            sb.append("\n");
        }
        System.out.println(sb);
        
    }


    

    private static void comb(int idx, int cnt) {
        if(cnt==6){
            for (int i = 0; i < T; i++) {
            	if(select[i])
            	{
            		sb.append(cards[i]+" ");
            	}
                sb.append("\n");
                return;
            }
        }
        
        if(idx==T) return;
        select[idx] =true;
        comb(idx+1,cnt+1);
        select[idx]=false;
        comb(idx+1,cnt);

    }
}