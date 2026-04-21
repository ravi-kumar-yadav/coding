package com.ravi.coding.leetcode.medium;

// Problem: 200
// https://leetcode.com/problems/number-of-islands/description/
public class NoOfIslands {
    private int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    public int islandCount(char[][] grid){
        if (grid == null || grid.length == 0){
            return 0;
        }

        int count = 0;

        // loop through all cells and count distinct elements
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[i].length; j++){
                if (grid[i][j] == '1'){
                    count++;

                    processNearByCells(grid, i, j);
                }
            }
        }



        return count;
    }

    // for each cell find the nearby cells and mark them visited (cell = '0')
    private void processNearByCells(char[][] grid, int row, int col){
//        if (row<0 || col<0 || row>=grid.length || col>=grid[row].length || grid[row][col] == '0'){
//            return;
//        }
//
//        grid[row][col] = '0';
//
//        // process other nearby cells
//        processNearByCells(grid, row+1, col);
//        processNearByCells(grid, row-1, col);
//        processNearByCells(grid, row, col+1);
//        processNearByCells(grid, row, col-1);

        if (grid[row][col] == '0'){
            return;
        }

        grid[row][col] = '0';

        for (int[] direc: directions){
            int ni = row + direc[0];
            int nj = col + direc[1];

            if (ni>=0 && nj>=0 && ni<grid.length && nj<grid[0].length && grid[ni][nj] == '1'){
                processNearByCells(grid, ni, nj);
            }
        }
    }
}
