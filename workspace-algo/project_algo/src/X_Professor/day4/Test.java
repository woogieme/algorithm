package X_Professor.day4;

import java.util.Scanner;

public class Test {
    static int res;
    static int D; // 두께
    static int W; // 너비
    static int K; // 합격기준
    static int[][] map;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        for(int t = 1; t <= TC ;t++) {
            res = Integer.MAX_VALUE;
            D = sc.nextInt();
            W = sc.nextInt();
            K = sc.nextInt();
            arr = new int[D]; // 배열의 초기값-1(X) 0=A, 1=B
            for(int i = 0; i <D; i++) {
                arr[i] = -1;
            }
            map = new int[D][W];
            for(int i = 0; i < D; i++) {
                for(int j = 0; j < W; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            //입력 완료
            //시뮬레이션구현
            //현재 행(두께마다) 0,1, X 반복실행, 두께만큼
            dfs(0,0); //반환값 X
            System.out.println("#" + t + " " + res);
        }

    }
    private static void dfs(int idx, int cnt) {
        //핵심소스 판단이 가능한지
        if(cnt >=res) {
            return;
        }
        // 종료
        if(idx == D) {
            //합격기준판단
            if(isCheck()) {
                res = Math.min(res, cnt);
            }
            //최소값 업데이트
            return;
        }
        //실행및 재귀호출
        //아무것도 안함
        arr[idx] = -1;
        dfs(idx+1, cnt);
        //A(0)으로 변환
        arr[idx] = 0;
        dfs(idx+1, cnt + 1);
        //B(1)로 변환
        arr[idx] = 1;
        dfs(idx+1, cnt + 1);
        
    }
    private static boolean isCheck() {
        //모든열들이 안전하면 안전한것이다.
        //하나의 열이 안전하지 않은면 전체가 안전하지 않다.
        int a, b;
        int cnt = 0;
        for(int j = 0; j < W;j++) {
            cnt = 1;
            for(int i = 0; i < D-1 ; i++) {
                a = map[i][j];
                b = map[i+1][j];
                //화약 약품 사용했는지 안했는지 
                if(arr[i] != -1) {
                    a = arr[i];
                }
                if(arr[i+1] != -1) {
                    b = arr[i+1];
                }
                if(a == b) {
                    cnt++;
                    if(cnt >= K) {
                        break;
                    }
                }else {
                    cnt = 1;
                }
            }
            if(cnt < K) {
                return false;
            }
        }
        
        return true;
    }

}