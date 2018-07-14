package com.leetcode.premium.fb;

import org.junit.Test;

public class NumOfIsland {

    char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};

    @Test
    public void test(){
        numIslands(grid);
    }

    public int numIslands(char[][] grid) {

        if(grid == null || grid.length==0){
            return 0;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count=0;
        for(int y=0; y < grid.length; y++){
            for(int x=0; x < grid[y].length; x++){
                if(grid[y][x]!='0' && !visited[y][x]){
                    count++;
                    dfs(grid, visited, y, x);
                }else{
                    visited[y][x]=true;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid,boolean[][] visited,int y, int x){
        if(y < 0 || y>= grid.length-1 || x < 0 || x > grid[y].length-1 || visited[y][x] || grid[y][x]=='0'){
            return;
        }
        visited[y][x]=true;
        dfs(grid,visited,y-1, x);
        dfs(grid,visited,y+1, x);
        dfs(grid,visited,y, x+1);
        dfs(grid,visited,y, x-1);
    }
}
