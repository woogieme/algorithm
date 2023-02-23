package day0223;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SW_1873_상호의배틀필드_Improved {
    static int H;
    static int W;
    static char[][] map;
    static char[] orders;
    static int tanki, tankj,tankd; //전차는 맵에 두지 않고 공중부양시키자
    static char[] orderDir= {'^','v','<','>'}; //0:up, 1:down , 2:left , 3:right
    static char[] arrow= {'U','D','L','R'}; //0:up, 1:down , 2:left , 3:right
    static int[] dx ={-1,1,0,0};
    static int[] dy ={0,0,-1,1};
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int TC = Integer.parseInt(br.readLine());
    	for (int tc = 1; tc <=TC; tc++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		H=Integer.parseInt(st.nextToken());
    		W=Integer.parseInt(st.nextToken());
    		map=new char[H][];
    		for (int i = 0; i < H; i++) {
    			map[i]=br.readLine().toCharArray();
    			for (int j = 0; j < W; j++) {
					for (int d = 0; d <4; d++) { //0:up, 1:down , 2:left , 3:right 
						if(map[i][j]==arrow[d]) { //탱크 초기위치 찾음 (화살표 4개중에 하나임!)
							tanki=i;
							tankj=j;
							tankd=d;
							map[i][j]='.';
						}
					}
				}
				
			}
    		int orderCnt = Integer.parseInt(br.readLine());

    		orders = br.readLine().toCharArray();
    		for(char op: orders) { // U,D,L,R,S
    			if(op=='S') { //포탄
    				int nowi= tanki;
    				int nowj = tankj;
    				
    				while(true) {
    					int nexti = nowi+dx[tankd];
    					int nextj = nowj+dy[tankd];
    					if(nexti>=H || nexti<0 || nextj>=W ||nextj<0 || map[nexti][nextj]=='#') {
    						break;
    					}
    					if(map[nexti][nextj]=='*') {
    						map[nexti][nextj]='.';
    						break;
    					}
    					nowi=nexti;
    					nowj=nextj;
    				}
    			}
    			else { //포탄 아니면 그냥 이동
    				for (int d = 0; d < 4; d++) { //'U'를 0으로 , 'D'를 1로 각각 문자를 숫자방향으로 바꾸기
						if(op==orderDir[d]) {
							tankd=d; //탱크가 일단 명령한 방향을 쳐다보게하자.
							int nexti= tanki+dx[tankd]; //탱크가 보는 옆칸
							int nextj= tankj+dy[tankd];
							if(nexti>=0 && nexti<H && nextj>=0 && nextj<W && map[nexti][nextj]=='.') {
								tanki=nexti;
								tankj=nextj;
							}
						}
					}
    			}
    		}
    		
    		map[tanki][tankj]=arrow[tankd];//탱크착륙
    		System.out.print("#"+tc+" ");
    		for (int j = 0; j < H; j++) {
				for (int j2 = 0; j2 < W; j2++) {
					System.out.print(map[j][j2]);
				}
				System.out.println();
			}
    		
			
		}
    }
}
