package day0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class SW_6809_Improved {
    static int[] G;
    static int[] I;
    static int[] I_tmp;
    static boolean[] select=new boolean[10];
    static int[] result=new int[10];
    static int G_A;
    static int I_A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC=Integer.parseInt(br.readLine());
        for(int asd=1; asd<=TC; asd++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            G = new int[10];
            I_tmp = new int[19];
            I = new int[10];
            boolean[] I_sup = new boolean[19];
 
            for (int i = 1; i <= 9; i++) {
                G[i] = Integer.parseInt(st.nextToken());
                I_sup[G[i]] = true;
            }
 
            int k = 1;
            for (int i = 1; i <= 18; i++) {
                if (!I_sup[i]) {
                    I[k] = i;
                    k += 1;
                }
            }
            G_A=0;
            I_A=0;
            comb(1);
            System.out.println("#"+asd+" "+G_A +" "+ I_A);
        }
 
    }
    private static void comb(int idx) {
        if(idx==10){
    		System.out.println(Arrays.toString(result));
            int G_win=0;
            int R_win=0;
            for (int i = 1; i <=9; i++) {
                if(G[i]<result[i]){
                    R_win+=result[i]+G[i];
                }
                else if (G[i]>result[i]){
                    G_win+=result[i]+G[i];
                }
 
            }
            if(G_win<R_win){
                I_A+=1;
            }
            else if(R_win<G_win){
                G_A+=1;
            }
            return;
        }
        
        
        for (int i = 1; i <=9; i++) {
            if(select[i]) continue;
            
            select[i]=true;
            result[idx]=I[i];
            comb(idx+1);
            select[i]=false;
        }
    }
}