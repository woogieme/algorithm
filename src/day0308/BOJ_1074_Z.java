package day0308;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class BOJ_1074_Z {
	static int N;
	static int r;
	static int c;
	static int cnt;
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new  BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		r=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		cnt=0;
		ans=0;
		letgo(0,0,1<<N,1<<N);
		System.out.println(ans);
		
	}
	private static void letgo(int si, int sj, int ei, int ej) {
		if(r<si ||  r>=ei || c<sj|| c>=ej ) {
			cnt+=(ei-si)*(ej-sj);
			return;
		}
		if(ei-si==1) {
			if(si==r && sj==c) {
				ans=cnt;
			}
			cnt++;
			return;
		}
		
		int mi = (si+ei)/2;
		int mj = (sj+ej)/2;
		
		letgo(si,sj,mi,mj);
		letgo(si,mj,mi,ej);
		letgo(mi,sj,ei,mj);
		letgo(mi,mj,ei,ej);
		
	}
}
