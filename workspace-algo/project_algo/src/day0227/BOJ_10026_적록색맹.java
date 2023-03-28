package day0227;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ_10026_적록색맹 {
    static int N;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx={0,1,0,-1};
    static int[] dy={1,0,-1,0};
    static int ans;
    static boolean isCheck;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());
        char R='R';
        char B='B';
        char G='G';
        isCheck=false;
        map = new char[N][N];
        visited = new boolean[N][N];
        ans=0;


        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == R && !visited[i][j]) {
                    BFS(i, j, visited, R);
                    ans++;
                }
                if (map[i][j] == B && !visited[i][j]) {
                    BFS(i, j, visited, B);
                    ans++;
                }
                if (map[i][j] == G && !visited[i][j]) {
                    BFS(i, j, visited, G);
                    ans++;
                }
            }
        }
        System.out.print(ans+" ");
        ans=0;
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == G) {
                    map[i][j] = R;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j]==R && !visited[i][j]){
                    BFS(i,j,visited,R);
                    ans++;
                }
                else if(map[i][j]==B && !visited[i][j]){
                    BFS(i,j,visited,B);
                    ans++;
                }
            }
        }
        System.out.println(ans);



    }

    private static void BFS(int i, int j, boolean[][] visit,char color) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(i,j));
        visit[i][j]=true;

        while(!queue.isEmpty()){
            Point now = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nexti = now.x+dx[d];
                int nextj = now.y+dy[d];
                if (nexti >= 0 && nextj < N && nextj >= 0 && nexti < N && map[nexti][nextj] == color && !visit[nexti][nextj]) {
                    queue.add(new Point(nexti, nextj));
                    visit[nexti][nextj] = true;
                }
            }
        }

    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

