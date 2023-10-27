package me.fengyj.leetcode.all.graph;

import java.util.HashSet;
import java.util.Set;

public class No_200_NumberOfIslands {

    public int numIslands(char[][] grid) {

        int count = 0;

        for(int x = 0; x < grid.length; x++) {
            for(int y = 0; y < grid[x].length; y++) {
                if(grid[x][y] == '1') {
                    explore(x, y, grid);
                    count++;
                }
            }
        }
        return count;
    }

    private void explore(int x, int y, char[][] grid){

        grid[x][y] = '0';
        if(x - 1 >= 0 && grid[x-1][y] == '1') explore(x - 1, y, grid);
        if(y + 1 < grid[x].length && grid[x][y + 1] == '1') explore(x, y + 1, grid);
        if(x + 1 < grid.length && grid[x + 1][y] == '1') explore(x + 1, y, grid);
        if(y - 1 >= 0 && grid[x][y - 1] == '1') explore(x, y - 1, grid);
    }
}
