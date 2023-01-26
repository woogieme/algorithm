package day01117;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test3_3 {
	static int[] di = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dj = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		// Test안에 실행되는 변수들은 for문 안에다가 넣어줘야함.
		for (int tc = 1; tc <= TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			char[][] map = new char[N][N]; // 시작인덱스를 고려해서 배열의크기를 고려해야한다.
			int ans = 0; // 맵 전체에서 최대 얼마나 높이 지을 수있는지 기록할 변수

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = st.nextToken().charAt(0); // "B" -> 'B'
				}
			} // 일단 전체 지도 입력 다 받음. 받기전까지 할수있는게 없으테니

			for (int i = 0; i < N; i++) { // N개의 행

				for (int j = 0; j < N; j++) { // N개의 열
					boolean isG = false;
					if (map[i][j] == 'B') { // 건물 올릴수 있는 구역이다?! 주변에 G 있나없나 봐야하네 ??
						for (int d = 0; d < 8; d++) { // 현재 주인공 i,j 주변 8개의 옆간 좌표 계산해보기
							int nexti = i + di[d];
							int nextj = j + dj[d];

							if (nexti < 0 || nextj < 0 || nexti >= N || nextj >= N)
								continue;

							if (map[nexti][nextj] == 'G') {
								isG = true;
								break;
							} // if G end
						} // for d end - 8개 방향끝내는 부분
						if (!isG) { // G가 있었으면 어차피 최대 2층이니까.. 없었을 때만 최대높이 계산해보기
							int tmp = 0;
							for (int t = 0; t < N; t++) { // 현재 칸 i,j 기준 가로로 B의 갯수
								tmp += (map[i][t] == 'B') ? 1 : 0;
							} // for t end
							for (int t = 0; t < N; t++) { // 현재 칸 i,j 기준 세로로 B의 갯수
								tmp += (map[t][j] == 'B') ? 1 : 0;
							} // for t2 end

							ans = Math.max(tmp - 1, ans); // 현재칸의 B가 두번 카운트 됐으니 -1 해서 갱신
						} // if !isG end
					} // B확인 end
				} // N개의 열 end
			} // N개의 행 end
			System.out.println("#"+tc+" "+Math.max(ans, 2));
		} // TC end
	}//end main
}//end class
