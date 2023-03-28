package day0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16926_배열돌리기1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int T=Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int Z=0;
		boolean isFlag=true;
		if(N==1 ||M==1) {
			isFlag=false;
		}
		if(N==M && (N!=1 || M!=1)) {
			if(N%2==0) {
				Z=N/2;
			}
			else {
				Z=N/2+1;
			}
		}
		else {
			if(N<M) {
				if(N%2==0) {
					Z=N/2;
				}
				else {
					Z=N/2+1;
				}
			}
			else {
				if(M%2==0) {
					Z=M/2;
				}
				else {
					Z=M/2+1;
				}
			}
		}
		int tmp=Z;
		while(T!=0&& isFlag) {
			int X=0,Y=0;
			while(Z!=0) {
				int K=0;
				int P=0;
				for(int i=X; i<=N-X-1; i++) {
					if(i!=N-X-1) {
						if (i==X) {
							if(K!=0) {
								int S = arr[i+1][Y];
								arr[i+1][Y]=K;
								K=S;
							}
							else {
								K = arr[i+1][Y];
								arr[i+1][Y]=arr[i][Y];
							}
						}
						else {
							P=arr[i+1][Y];
							arr[i+1][Y]=K;
							K=P;
						}
						
					}
					
				}
				for(int i=Y; i<=M-Y-1; i++) {
					if(i!=M-Y-1)
					{
						if(i==Y) {
							int S=arr[N-1-X][i+1];
							arr[N-1-X][i+1]=K;
							K = S;
						}
						else {
							P=arr[N-1-X][i+1];
							arr[N-1-X][i+1]=K;
							K=P;
						}
					}
				}
				for(int i=N-X-1; i>=X; i--) {
					if(i!=X) {
						if(i==N-X-1) {
							int S= arr[i-1][M-1-Y];
							arr[i-1][M-1-Y]=K;
							K=S;
						}
						else {
							P=arr[i-1][M-1-Y];
							arr[i-1][M-1-Y]=K;
							K=P;
						}	
					}
					
				}
				for(int i=M-Y-1; i>=Y; i--) {
					if(i!=Y)
					if(i==N-Y-1) {
						int S=arr[X][i-1];
						arr[X][i-1]=K;
						K=S;
					}
					else {
						P=arr[X][i-1];
						arr[X][i-1]=K;
						K=P;
					}
				}
			X+=1;
			Y+=1;
			Z-=1;
		}
			
		Z=tmp;
		T-=1;
	}
		for (int i = 0; i < N; i++) {
			for (int k = 0; k < M; k++) {
				System.out.print(arr[i][k]+" ");
			}
			System.out.println();
		}	
	}
}
