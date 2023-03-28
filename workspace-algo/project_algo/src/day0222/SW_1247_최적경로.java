package day0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class SW_1247_최적경로 {
	static int[] company;
	static int[] house;
	static List<Point> customer;
	static int N;
	static int tmpx;
	static int tmpy;
	static int[] brr;
	static boolean[] selected;
	static int value;
	public static void main(String[] args) throws Throwable, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC=Integer.parseInt(br.readLine());
		for (int tc = 1; tc <=TC; tc++) {
			N= Integer.parseInt(br.readLine());
			System.out.println(N);
			StringTokenizer st = new StringTokenizer(br.readLine());
			company = new int[2];
			house = new int[2];
			customer = new ArrayList<>();
			company[0]=Integer.parseInt(st.nextToken());
			company[1]=Integer.parseInt(st.nextToken());
			tmpx=company[0];
			tmpy=company[1];
			house[0]=Integer.parseInt(st.nextToken());
			house[1]=Integer.parseInt(st.nextToken());
			while(st.hasMoreTokens()) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				customer.add(new Point(x,y));
			}
			brr=new int[N];
			selected =new boolean[N];
			value=Integer.MAX_VALUE;
			perm(0);
			System.out.println("#"+tc+" "+value);
		}
	}
	private static void perm(int idx) {
		if (idx==N){
			int sum=0;
			company[0]=tmpx;
			company[1]=tmpy;
			
			for (int i = 0; i < brr.length; i++) {
				sum+=(Math.abs(company[0]-customer.get(brr[i]).x)+Math.abs(company[1]-customer.get(brr[i]).y));
				company[0]=customer.get(brr[i]).x;
				company[1]=customer.get(brr[i]).y;
				
			}
			sum+=(Math.abs(company[0]-house[0])+Math.abs(company[1]-house[1]));
			if(sum<=value) {
				value=sum;
			}
			return;
		}
		for (int i = 0; i < N; i++) {
			if(selected[i])continue;
			selected[i]=true;
			brr[idx]=i;
			perm(idx+1);
			selected[i]=false;
		}
		
	}
	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
		
	}
}
