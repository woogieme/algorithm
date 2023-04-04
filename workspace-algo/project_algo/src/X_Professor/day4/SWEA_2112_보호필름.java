package X_Professor.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_2112_보호필름 {
	static int D;
	static int W;
	static int K;
	static int[][] map;
	static int[][] copy;
	static int[] drugMap;
	static int ans;
	static boolean[] checked;
	static boolean[] selected;
	static int[] index;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		D=Integer.parseInt(st.nextToken());
		W=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		map=new int[D][W];
		copy= new int[D][W];
		
		for (int i = 0; i < D; i++) {
			st =new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < D; i++) {
			checked = new boolean[D];
			comb(0,0,i+1);
		}
		
		
		//검사
//		int ans=0;
//		for (int j = 0; j < W; j++) {
//			boolean isFlag=false;
//			int count=0;
//			for (int i = 0; i < D-1; i++) {
//				if(map[i][j]==map[i+1][j]) {
//					count++;
//					if(count==2) {
//						isFlag=true;
//						break;
//					}
//				}else {
//					count=0;
//				}
//			}
//			if(isFlag) {
//				ans++;
//			}
//		}
//		
//		
		
	}

	private static void comb(int idx, int cnt,int tmp) {
		if(cnt==tmp) {
			copy();
			if(tmp==1) {
				index= new int[tmp];
				selected= new boolean[tmp];
				dupPerm(0,tmp);
			}
			return;
		}
		if(idx==checked.length) {
			return;
		}
		checked[idx]=true;
		comb(idx+1,cnt+1,tmp);
		checked[idx]=false;
		comb(idx+1,cnt,tmp);
		
	}

	private static void dupPerm(int idx,int tmp) {
		if(idx==tmp) {
			System.out.println(Arrays.toString(index));
			return;
		}
		
		for (int i = 0; i <=tmp; i++) {
			index[idx]=i;
			dupPerm(idx+1,tmp);
		}
		
	}

	private static void copy() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				copy[i][j]=map[i][j];
			}
		}
		
	}
}
