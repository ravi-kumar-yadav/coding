package com.ravi.coding.leetcode.medium;

import java.util.Stack;

// Problem: 200
// https://leetcode.com/problems/number-of-islands/description/
public class NoOfIslandsOptimised {

    private static final int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    public int islandCount(char[][] grid){
        int count = 0;

        // general checks
        if (grid == null || grid.length == 0){
            return count;
        }

        // loop over each cell and count distinct islands
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[i].length; j++){
                if (grid[i][j] == '1'){
                    count++;

                    // find all connected neighbors and mark them visited i.e. '0'
                    processNeighbours(grid, i, j);
                }
            }
        }

        return count;
    }

    // find all connected neighbors and mark them visited i.e. '0'
    private void processNeighbours(char[][] grid, int row, int col){
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{row, col});
        grid[row][col] = '0';

        while (!stack.isEmpty()){
            int[] cell = stack.pop();

            for (int[] eachDirection: directions){
                int ni = cell[0] + eachDirection[0];
                int nj = cell[1] + eachDirection[1];

                if (ni>=0 && nj>=0 && ni<grid.length && nj<grid[ni].length && grid[ni][nj]=='1'){
                    stack.push(new int[]{ni, nj});
                    grid[ni][nj] = '0';
                }
            }
        }
    }
}
