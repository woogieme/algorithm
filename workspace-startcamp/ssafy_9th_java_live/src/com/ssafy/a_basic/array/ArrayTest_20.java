package com.ssafy.a_basic.array;

public class ArrayTest_20 {
	public static void main(String[] args) {

		char[][] grid = {
				{ '2', '3', '1', '4' },
				{ '1', 'X', '3', '2' },
				{ '3', '4', 'X', 'X' },
				{ 'X', '4', '1', '5' } };

		int sum = 0;
        int[] direct = {1,-1};
        int[][] redirect= {{-1,0},{1,0},{0,1},{0,-1}};
        for(int i=0; i<grid.length; i++) {
        	for(int j=0; j<grid.length; j++) {
                if (grid[i][j]=='X') {
                	if (j+direct[0] < grid.length && grid[i][j+direct[0]]!='X') {
                		sum+=grid[i][j+direct[0]]-'0';
                		System.out.println(grid[i][j+direct[0]]);
                	}
                	if (j+direct[1] > -1 && grid[i][j+direct[1]]!='X') {
                		sum+=grid[i][j+direct[1]]-'0';
                		System.out.println(grid[i][j+direct[1]]);
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
