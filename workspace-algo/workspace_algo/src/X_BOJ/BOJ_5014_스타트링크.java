package X_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5014_스타트링크 {
	static int F;
	static int S;
	static int G;
	static int U;
	static int D;
	static int ans;
	static int[] dis;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		F=Integer.parseInt(st.nextToken());
		S=Integer.parseInt(st.nextToken());
		G=Integer.parseInt(st.nextToken());
		U=Integer.parseInt(st.nextToken());
		D=Integer.parseInt(st.nextToken());
		ans=0;
		dis =new int[] {U,-D};
		BFS(S);
	}
	private static void BFS(int current) {
		Queue<Integer> arr =new ArrayDeque<>();
		arr.add(current);
		boolean[] visited= new boolean[F+1];
		visited[current]=true;
		boolean isFlag=true;
		while(!arr.isEmpty()) {
			int size= arr.size();
			for (int i = 0; i < size; i++) {
				int count=arr.poll();
				if(count==G) {
					isFlag=false;
					break;
				}
				for (int d = 0; d < 2; d++) {
					int tmp=count+dis[d];
					//System.out.println(count+" : "+tmp);
					if(tmp<=F && tmp>0 &&!visited[tmp]) {
						visited[tmp]=true;
						arr.add(tmp);
					}
				}
			}
			ans++;
			if(!isFlag) {
				break;
			}
		}
		if(!isFlag) {
			System.out.println(ans-1);
		}
		else {
			System.out.println("use the stairs");
		}
	}
}		
