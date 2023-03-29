package day0329;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1463_1로만들기_DFS_BFS_DP {	
	
	static int X;
	static int ans;
	static int[] visit;
	static int maxCnt, maxX;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		X=sc.nextInt();
		visit =new int[X+1];
		Arrays.fill(visit, Integer.MAX_VALUE);
		ans = Integer.MAX_VALUE;
		dp();
		//dfs(X,0);
		//System.out.println(ans);
		//ans = Integer.MAX_VALUE;
		//System.out.println(bfs(X));
		
		
		
	}
	private static void dp() {
		int[] memo = new int[X+1];
		
		//memo[1] =0; 1은 1이 되기 위해 연산횟수 0번 필요. 기본값이네 안채워도되네
		
		for(int x=2; x<=X; x++) {
			memo[x]= memo[x-1]+1; //현재 x에서 -1한 숫자는 1로 가는데 연산 몇번 수행하는지 봐서 걔보다 내가 연산 한번더 함.
			if(x%3==0) {
				memo[x]=Math.min(memo[x], memo[x/3]+1); //위에서 -1연산 했을때랑 /3한 숫자에 연산 한번 +1한거랑 비교
			}
			if(x%2==0) {
				memo[x]=Math.min(memo[x], memo[x/2]+1); //위에서 -1연산 했을때랑 /2한 숫자에 연산 한번 +1한거랑 비교
			}
		}
		ans=memo[X];
		
	}
	private static void dfs(int num, int cnt) {
		if(cnt>=ans) {
			return;
		}
		if(num==1) {
			ans = Math.min(ans, cnt);
			return;
		}
		if(num%3==0) {
			dfs(num/3, cnt+1);
		}
		
		if(num%2==0) {
			dfs(num/2,cnt+1);
		}
		dfs(num-1,cnt+1);
	}
	
	private static int bfs(int num) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visit = new boolean[X+1];
		queue.add(X);
		visit[X]= true;
		
		int cnt = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for (int i = 0; i < size; i++) {
				int now = queue.poll();
					if(now == 1) {
						return cnt;
					}
					
					if(now%3==0 && !visit[now/3]) {
						queue.add(now/3);
						visit[now/3]=true;
					}
					
					if(now%2==0&& !visit[now/2]) {
						queue.add(now/2);
						visit[now/2]=true;
					}
					if(!visit[now-1]) {
					queue.add(now-1);
					visit[now-1]=true;
					}
			}
			cnt++;
		}
		return cnt;
		
	}

}
