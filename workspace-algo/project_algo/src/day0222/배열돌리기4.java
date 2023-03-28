package day0222;
import java.util.Arrays;
import java.util.Scanner;

public class 배열돌리기4 {
	static int N, M, K;
	static int[][] map;

	static Rotate[] cards; 
	static Rotate[] result; 
	static boolean[] used;

	static int ans;

	public static void main(String[] args) {
		//System.out.println(Arrays.binarySearch(new int[] {1,2,3,4,99}, 99));
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		
		map = new int[N+1][M+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		cards = new Rotate[K]; 
		result = new Rotate[K];
		used = new boolean[K];
		
		for(int k=0; k<K; k++) {
			cards[k] = new Rotate(sc.nextInt(), sc.nextInt(), sc.nextInt());
		} 
		
		ans = Integer.MAX_VALUE;
		perm(0);
		System.out.println(ans);
	}
	
	static void perm(int idx) {
		if(idx == result.length) { 

			int[][] copy = deepcopy(map);
			for(int i=0; i<result.length; i++) {
				rotate(copy, result[i]);
			}
			
			for(int i=1; i<=N; i++) {
				int rowSum=0;
				for(int j=1; j<=M; j++) {
					rowSum += copy[i][j];
				}
				ans = Math.min(ans, rowSum);
			}
			return;
		}
		
		for(int i=0; i<cards.length; i++) {
			if(used[i]) continue;
			
			result[idx] = cards[i];
			used[i] = true;
			perm(idx+1);
			used[i] = false;
		}
	}
	
	static int[][] deepcopy(int[][] origin) {
		int[][] copy = new int[origin.length][origin[0].length];
		for (int i = 0; i < origin.length; i++) {
			for (int j = 0; j < origin[0].length; j++) {
				copy[i][j] = origin[i][j];
			}
		}
		return copy;
	}

	static void rotate(int[][] copy, Rotate now) {
		for (int s = 1; s <= now.s; s++) {
			int i = now.r - s, j = now.c - s;

			int tmp = copy[i][j]; 

			for (i = now.r - s; i < now.r + s; i++) {
				copy[i][j] = copy[i + 1][j];
			}

			for (j = now.c - s; j < now.c + s; j++) {
				copy[i][j] = copy[i][j + 1];
			}

			for (i = now.r + s; i > now.r - s; i--) {
				copy[i][j] = copy[i - 1][j];
			}

			for (j = now.c + s; j > now.c - s; j--) {
				copy[i][j] = copy[i][j - 1];
			}

			copy[now.r - s][now.c - s + 1] = tmp; 
		}
	}

	static class Rotate {
		int r, c, s;

		public Rotate(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}

		@Override
		public String toString() {
			return "Rotate [r=" + r + ", c=" + c + ", s=" + s + "]";
		}
	}

}