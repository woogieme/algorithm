package day0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_6987_월드컵 {
	static ArrayList<Point> arr;
	static ArrayList<Integer> brr;
	static boolean[] selected;
	static int[] permArr = {1,2,3,4,5,6};
	static int[] permBrr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new ArrayList<>();
		brr = new ArrayList<>();
		while(st.hasMoreTokens()) {
			int a =Integer.parseInt(st.nextToken());
			int b =Integer.parseInt(st.nextToken());
			int c =Integer.parseInt(st.nextToken());
			arr.add(new Point(a,b,c));
		}
		for (int i = 0; i < permArr.length; i++) {
			permBrr= new int[] {0,0,0};
			checkperm(i,i);
		}
	}
	private static void checkperm(int idx,int N) {
		if(idx==permBrr.length) {
			System.out.println(Arrays.toString(permBrr));
			if(permBrr[0]==arr.get(N).x) {
				if((permBrr[1]==arr.get(N).y)&& permBrr[2]==arr.get(N).z) {
					System.out.println("유레카!!");
					System.out.println(Arrays.toString(permBrr));
				}
			}
			return;
		}
		for (int i = 0; i < permArr.length; i++) {
			permBrr[idx]=i;
			checkperm(idx+1,N);
		}
		
	}
	static class Point{
		int x;
		int y;
		int z;
		public Point(int x, int y, int z) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
}
