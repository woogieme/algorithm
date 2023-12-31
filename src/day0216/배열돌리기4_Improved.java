package day0216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 배열돌리기4_Improved {
	static int N;
	static int N_real;
	static int M_real;
	static int M;
	static int T;
	static int[][] map;
	static int[][] tmpMap;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static List<Point> pnt;
	static boolean[] checked;
	static int[] arr;
	static int value;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		tmpMap=new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		pnt = new ArrayList<>();
		for (int i = 0; i < T; i++) {
			int[] arr = new int[3];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			pnt.add(new Point(arr[0] - arr[2] - 1, arr[1] - arr[2] - 1, arr[0] + arr[2] - 1, arr[1] + arr[2] - 1));
		}
		checked = new boolean[pnt.size()];
		arr = new int[pnt.size()];
		value=Integer.MAX_VALUE;
		perm(0);
		System.out.println(value);

	}

	private static void perm(int idx) {
		if (idx == checked.length) {
			for (int s = 0; s < N; s++) {
				for (int j = 0; j < M; j++) {
					tmpMap[s][j]=map[s][j];
				}
			}
			for (int i = 0; i < arr.length; i++) {
				rotate(arr[i]);
			}
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j <M; j++) {
//					System.out.print(tmpMap[i][j]+" ");
//				}
//				System.out.println();
//			}
			int sum=0;
			for (int i = 0; i < N; i++) {
				sum=0;
				for (int j = 0; j <M; j++) {
					sum+=tmpMap[i][j];
				}
				if(sum<=value) {
					value=sum;
				}
			}
			return;
		}

		for (int i = 0; i < checked.length; i++) {
			if (checked[i])
				continue;
			checked[i] = true;
			arr[idx] = i;
			perm(idx + 1);
			checked[i] = false;
		}

	}

	private static void rotate(int i) {
		N_real = (pnt.get(i).idx_x);
		M_real = (pnt.get(i).idx_y);
		int depth = Math.min(N, M) / 2;
		for (int d = 0; d < depth; d++) {
			int tmp = tmpMap[d + pnt.get(i).idx_i][d + pnt.get(i).idx_j];
			int si = d + pnt.get(i).idx_i;
			int sj = d + pnt.get(i).idx_j;
			int nowi = si;
			int nowj = sj;
			int dir = 0;
			while (true) {
				int nexti = nowi + dx[dir];
				int nextj = nowj + dy[dir];
				if (nexti > N_real - d || nextj > M_real - d || nexti < si || nextj < sj) {
					dir += 1;
					if (dir == 4) {
						break;
					}
					continue;
				}

				tmpMap[nowi][nowj] = tmpMap[nexti][nextj];
				nowi = nexti;
				nowj = nextj;
			}
			if(nowi!=(si+N_real)/2 && nowj!=(sj+M_real)/2) {
				tmpMap[si][sj+1]=tmp;
			}
		}
	}

	static class Point {
		int idx_i;
		int idx_j;
		int idx_x;
		int idx_y;

		public Point(int idx_i, int idx_j, int idx_x, int idx_y) {
			this.idx_i = idx_i;
			this.idx_j = idx_j;
			this.idx_x = idx_x;
			this.idx_y = idx_y;
		}

	}
}
