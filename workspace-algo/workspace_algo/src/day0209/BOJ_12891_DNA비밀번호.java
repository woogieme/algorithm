package day0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_12891_DNA비밀번호 {
	static char[] DNA;
	static char[] pw;
	static int N;
	static int M;
	static int A;
	static int C;
	static int G;
	static int T;
	static int count;
	 public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 StringBuilder sb = new StringBuilder();
		 N= Integer.parseInt(st.nextToken());
		 M= Integer.parseInt(st.nextToken());
		 DNA = new char[N];
		 st = new StringTokenizer(br.readLine());
		 String str= st.nextToken();
		 int[] value = new int[4];
		 for (int i = 0; i < N; i++) {
			DNA[i]=str.charAt(i);
			if(DNA[i]=='A') {
				value[0]+=1;
			}else if(DNA[i]=='C') {
				value[1]+=1;
			}else if(DNA[i]=='G') {
				value[2]+=1;
			}else if(DNA[i]=='T') {
				value[3]+=1;
			}
		}
		 count=0;
		 
		 st = new StringTokenizer(br.readLine());
		 A= Integer.parseInt(st.nextToken());
		 C= Integer.parseInt(st.nextToken());
		 G= Integer.parseInt(st.nextToken());
		 T= Integer.parseInt(st.nextToken());
		 int[] cp = {A,C,G,T};
		 int sum=0;
		 for (int i = 0; i < 4; i++) {
			sum+=value[i]-cp[i];
		}
		 if(sum<0) {
			 System.out.println(0);
		 }
		 else {
			 System.out.println(sum);
		 }
	}
}
