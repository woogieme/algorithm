package day0223;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SW_1873_상호의배틀필드 {
    static int H;
    static int W;
    static char[][] map;
    static int X;
    static int Y;
    static int[] dx ={-1,0,1,0};
    static int[] dy ={0,1,0,-1};
    static int N;
    static char fire;
    static char[] playTank;
    static int T;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            H = sc.nextInt();
            W = sc.nextInt();
            map = new char[H][];
            for (int i = 0; i < H; i++) {
                map[i] = sc.next().toCharArray();
                for (int j = 0; j < map[i].length; j++) {
                    if (map[i][j] == '<' || map[i][j] == '>' || map[i][j] == '^' || map[i][j] == 'v') {
                        X = i;
                        Y = j;
                    }
                }
            }
            N = sc.nextInt();
            playTank = sc.next().toCharArray();
            int idx = 0;
            while (true) {
                if (idx == playTank.length) {
                    break;
                }
                switch (playTank[idx]) {
                    case 'U':
                        moveU();
                        break;
                    case 'R':
                        moveR();
                        break;
                    case 'L':
                        moveL();
                        break;
                    case 'D':
                        moveD();
                        break;
                    case 'S':
                        fireShoot();
                        break;

                }
                idx++;
            }
            System.out.print("#"+t+" ");
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }
    }

    private static void fireShoot() {
        if(map[X][Y]=='^'){
            whereShoot(dx[0],dy[0],dx[0],dy[0]);
        }
        else if(map[X][Y]=='>'){
            whereShoot(dx[1],dy[1],dx[1],dy[1]);
        }
        else if(map[X][Y]=='v'){
            whereShoot(dx[2],dy[2],dx[2],dy[2]);
        }
        else if(map[X][Y]=='<'){
            whereShoot(dx[3],dy[3],dx[3],dy[3]);
        }
    }

    private static void whereShoot(int dx, int dy,int keyX,int keyY) {
        if(X+dx<0 || X+dx==H || Y+dy<0 || Y+dy==W ||map[X+dx][Y+dy]=='#'){
            return;
        }
        if(map[X+dx][Y+dy]=='*'){
            map[X+dx][Y+dy]='.';
            return;
        }
        whereShoot(dx+keyX,dy+keyY,keyX,keyY);
    }

    private static void moveD() {
        map[X][Y]='v';
        int nexti=X+dx[2];
        int nextj=Y+dy[2];
        if(check(nexti,nextj)){
            map[X][Y]='.';
            X=nexti;
            Y=nextj;
            map[X][Y]='v';
        }
    }

    private static void moveL() {
        map[X][Y]='<';
        int nexti=X+dx[3];
        int nextj=Y+dy[3];
        if(check(nexti,nextj)){
            map[X][Y]='.';
            X=nexti;
            Y=nextj;
            map[X][Y]='<';
        }
    }

    private static void moveR() {
        map[X][Y]='>';
        int nexti=X+dx[1];
        int nextj=Y+dy[1];
        if(check(nexti,nextj)){
            map[X][Y]='.';
            X=nexti;
            Y=nextj;
            map[X][Y]='>';
        }
    }

    private static void moveU() {
        map[X][Y]='^';
        int nexti=X+dx[0];
        int nextj=Y+dy[0];
        if(check(nexti,nextj)){
            map[X][Y]='.';
            X=nexti;
            Y=nextj;
            map[X][Y]='^';
        }
    }

    private static boolean check(int nexti,int nextj) {
        if( nexti<0 ||nexti==H ||nextj<0 ||nextj==W ||map[nexti][nextj]!='.'){
            return false;
        }
        return true;
    }
}
