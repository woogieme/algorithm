package day0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15686_치킨배달 {
	static ArrayList<Point> houses = new ArrayList<>();
	static ArrayList<Point> chickens = new ArrayList<>();
	static int N;
	static int M;
	static boolean[] checked;
	static int sum;
	static int result;
public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j <N; j++) {
				int tmp=Integer.parseInt(st.nextToken());
				if(tmp==1) {
					houses.add(new Point(i, j));
				}
				else if (tmp==2) {
					chickens.add(new Point(i, j));
				}
			}
		}
		sum=0;
		result=Integer.MAX_VALUE;
		checked = new boolean[chickens.size()];
		comb(0,0);
		System.out.println(result);
		
		
	}
	private static void comb(int idx, int cnt) {
	// TODO Auto-generated method stub
		if(cnt==M) {
			for (int i = 0; i < houses.size(); i++) {
				int value=Integer.MAX_VALUE;
				for (int j = 0; j < checked.length; j++) {
					if(checked[j]) {
						if(value>=(Math.abs(houses.get(i).i-chickens.get(j).i)+Math.abs(houses.get(i).j-chickens.get(j).j))) {
							value=(Math.abs(houses.get(i).i-chickens.get(j).i)+Math.abs(houses.get(i).j-chickens.get(j).j));
						}
					}
				}
				if(value!=Integer.MAX_VALUE) {
					sum+=value;
				}
			}
			//sum+=Math.abs(houses.get(j).i-chickens.get(i).i)+Math.abs(houses.get(j).j-chickens.get(i).j);
			if(sum<result) {
				result=sum;
		
			}
			sum=0;
			return;
		}
		if(idx==chickens.size()) {
			return;
		}
		checked[idx]=true;
		comb(idx+1,cnt+1);
		checked[idx]=false;
		comb(idx+1,cnt);
}
	static class Point{
		int i, j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}

		@Override
		public String toString() {
			return "Point [i=" + i + ", j=" + j + "]";
		}
		
	}
}
