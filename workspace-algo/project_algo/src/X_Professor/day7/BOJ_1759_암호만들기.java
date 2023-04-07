package X_Professor.day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759_암호만들기 {
	static int N;
	static int M;
	static char[] arr;
	static char[] cards;
	static boolean[] checked;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new char[M];
		cards = new char[N];
		checked = new boolean[M];
		st =new StringTokenizer(br.readLine());
		String brr="";
		while (st.hasMoreTokens()) {
			brr+=st.nextToken();
		}
		for (int i = 0; i < M; i++) {
			arr[i]= brr.charAt(i);
		}
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i]<arr[j]) {
					char tmp = arr[i];
					arr[i]=arr[j];
					arr[j]=tmp;
				}
			}
		}
		perm(0,0);

	}
	private static void perm(int idx, int cnt) {
		
		if(cnt==N) {
			boolean isFlag=false;
			int count= 0;
			for (int i = 0; i < M; i++) {
				if(checked[i]) {
					if(arr[i]=='a' || arr[i]=='o' || arr[i]=='i' || arr[i]=='u'|| arr[i]=='e') {
						isFlag=true;
					}
					else {
						count++;
					}
				}
			}
			if(isFlag && count>=2) {
				for (int i = 0; i < arr.length; i++) {
					if(checked[i]) {
						System.out.print(arr[i]);
					}
				}
				System.out.println();
			}
			return;
		}
		if(idx==M) {
			return;
		}
		checked[idx]=true;
		perm(idx+1,cnt+1);
		checked[idx]=false;
		perm(idx+1,cnt);
	}
}
