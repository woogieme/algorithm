package day0116;

public class Test04 {
	public static void main(String[] args) {

		char[][] grid = {
				{ '2', '3', '1', '4' },
				{ '1', 'X', '3', '2' },
				{ '3', '4', 'X', 'X' },
				{ 'X', '4', '1', '5' }
				};

		int sum = 0;
        int[] direct = {1,-1};
        //델타 탐색
        int[] dx= {-1,1,0,0};
        int[] dy= {0,0,-1,1};
        for(int i=0; i<grid.length; i++) {
        	for(int j=0; j<grid.length; j++) {
                if (grid[i][j]=='X') {
                	for(int d=0; d<4; d++) {
                		int nexti=i+dx[d];
                		int nextj=j+dy[d];
                		//grid[nexti][nextj]!='X'가 앞에있으면 오류가남 , 유효인덱스 체크를 먼저 다끝내고나서 넣어줘야되는 문구임 왜냐하면 유효인덱스이지도 않은데 x가 있는지 없는지 검사하는것이기때문이다
                		if (nexti>=0 && nexti<grid.length && nextj>=0 && nextj<grid[i].length && grid[nexti][nextj]!='X') {
                			sum+=grid[nexti][nextj]-'0';
                			grid[nexti][nextj]='0';
                		}
                	}
                }
            }
        }
		// TODO: X로 표시된 항목의 상좌우 숫자의 합을 구하시오.
		//  단 합을 구할 때 이미 더한 영역은 다시 더하지 않는다.
		// END:
		System.out.println(sum);
	}
}
