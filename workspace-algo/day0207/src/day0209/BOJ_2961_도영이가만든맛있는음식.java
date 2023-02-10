package day0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2961_도영이가만든맛있는음식 {
    static int[] S;
    static int[] B;
    static boolean[] select;
    static int N;
    static int flavor=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S= new int[N];
        B= new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            S[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }
        select = new boolean[N];
        comb(0,0);
        System.out.println(flavor);

    }
    private static void comb(int idx, int cnt) {
        // TODO Auto-generated method stub
        if(idx==N) {
            int count=0;
            for (int i = 0; i < select.length; i++) {
                if(select[i]) {
                    count+=1;
                }

            }
            if (count!=0) {
                int S_tmp = 1;
                int B_tmp = 0;
                for (int i = 0; i < select.length; i++) {
                    if (select[i]) {
                        B_tmp += B[i];
                        S_tmp *= S[i];
                    }

                }
                //System.out.print(B_tmp-S_tmp+" ");
/*                System.out.print(B_tmp + " " + S_tmp);
                System.out.println();*/
                if (Math.abs(B_tmp - S_tmp) <= flavor) {
                    flavor = Math.abs(B_tmp - S_tmp);
                }
            }
            return;
        }
        // TODO Auto-generated method stub
        select[idx]=true;
        comb(idx+1,cnt+1);
        select[idx]=false;
        comb(idx+1,cnt);
    }
}
