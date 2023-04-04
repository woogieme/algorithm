package X_Professor.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1247_최적경로 {
	static int N;
	static List<Point> list;
	static boolean[] selected;
	static int[] index;
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int i = 1; i <=TC ;i++) {
			
			N = Integer.parseInt(br.readLine());
			selected=new boolean[N];
			index = new int[N];
			StringTokenizer st =new StringTokenizer(br.readLine());
			ans =Integer.MAX_VALUE;
			list = new ArrayList<>();
			while(st.hasMoreTokens()) {
				list.add(new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
			}
			perm(0);
			System.out.println("#"+i+" "+ans);
		}
	}
	private static void perm(int idx) {
		
		if(idx==N) {
			int sum=0;
			sum+=Math.abs(list.get(0).x - list.get(index[0]+2).x) + Math.abs(list.get(0).y - list.get(index[0]+2).y);
			for (int i = 0; i < index.length-1; i++) {
				sum+=Math.abs(list.get(index[i]+2).x - list.get(index[i+1]+2).x) + Math.abs(list.get(index[i]+2).y - list.get(index[i+1]+2).y);
			}
			sum+=Math.abs(list.get(1).x  - list.get(index[index.length-1]+2).x) + Math.abs(list.get(1).y  - list.get(index[index.length-1]+2).y);
			
			ans = Math.min(ans, sum);
			return;
		}
		for (int i = 0; i < N; i++) {
			if(selected[i]) continue;
			selected[i]=true;
			index[idx]=i;
			perm(idx+1);
			selected[i]=false;
		}
		
	}
	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		
	}
}
