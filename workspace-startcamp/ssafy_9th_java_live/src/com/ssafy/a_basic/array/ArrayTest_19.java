package com.ssafy.a_basic.array;

public class ArrayTest_19 {

    public static void main(String[] args) {

        char[][] grid = { 
        		{ '2', '3', '1', '4' },
        		{ '1', 'X', '3', '2' },
                { '3', '4', 'X', 'X' },
                { 'X', '4', '1', '5' } 
                };
        int[] direct = {1,-1};
        int sum = 0;
        // TODO: X로 표시된 항목의 좌우 숫자의 합을 구하시오.
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
                	if (i+direct[0] < grid.length && grid[i+direct[0]][j]!='X' ) {
                		sum+=grid[i+direct[0]][j]-'0';
                		System.out.println(grid[i+direct[0]][j]);
                	}
                	if (i+direct[1] > -1 && grid[i+direct[1]][j]!='X') {
                		sum+=grid[i+direct[1]][j]-'0';
                		System.out.println(grid[i+direct[1]][j]);
                	}
                }
            }
        }
        // END:
        System.out.println(sum);
    }
}
