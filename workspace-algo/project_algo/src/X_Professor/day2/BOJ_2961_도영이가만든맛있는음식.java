package X_Professor.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2961_도영이가만든맛있는음식 {
	private static final String List = null;
	static int[] arr ;
	static int N;
	static boolean[] check;
	static List<Point> flavor;
	static int ans;
	static boolean isFlag;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int [N];
		for (int i = 0; i < N; i++) {
			arr[i]=i+1;
		}
		check=new boolean[N];
		StringTokenizer st =null;
		
		flavor = new ArrayList<>();
		ans=Integer.MAX_VALUE;
		for (int i = 0; i <N; i++) {
			st =new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			flavor.add(new Point(x,y));
		}
		isFlag=true;
		sub(0);
		
		System.out.println(ans);
	}
	private static void sub(int idx) {
		if(idx==N) {
			int front=1;
			int end=0;
			for (int i = 0; i < N; i++) {
				if(check[i]) {
					front*=flavor.get(i).x;
					end+=flavor.get(i).y;
					isFlag=false;
				}
			}
			if(!isFlag) {
				int result = Math.abs(front-end);
				ans = Math.min(ans, result);
			}
			isFlag=true;
			return;
		}
		
		check[idx]=true;
		sub(idx+1);
		check[idx]=false;
		sub(idx+1);
		
		
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
