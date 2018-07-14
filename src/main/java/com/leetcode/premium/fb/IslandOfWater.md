#Island of Water

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:
```
Input:
11110
11010
11000
00000
```
Output: 1
Example 2:
```
Input:
11000
11000
00100
00011
```
Output: 3


```
class Solution {
    public int numIslands(char[][] grid) {
       if(grid == null || grid.length == 0){
           return 0;
       } 
       boolean[][] visited = new boolean[grid.length][grid[0].length];
       int connected =0;      
       for(int y = 0; y <= grid.length-1; y++){
           for(int x = 0; x <= grid[0].length-1; x++){
               if(!visited[y][x] && grid[y][x]=='1'){
                    checkConectedComponents(y,x,visited, grid);
                    connected++;
             }else{
                    visited[y][x] = true;
            }               
       }
      }
      return connected;  
    }
    
    void checkConectedComponents(int y, int x,boolean[][] visited, char[][] grid ){
        visited[y][x]=true;
        if(grid[y][x] == '1'){
        
          if(canMove(y,x+1, grid, visited)){ //right
              checkConectedComponents(y,x+1,visited, grid);
          }
          if(canMove(y+1,x, grid, visited)){ //up
              checkConectedComponents(y+1,x,visited, grid);
          }
          if(canMove(y-1,x, grid, visited)){ //down
              checkConectedComponents(y-1,x,visited, grid);
          }
          if(canMove(y,x-1, grid, visited)){ //left
             checkConectedComponents(y,x-1,visited, grid);
          }     
        }
    }
    
    boolean canMove(int y,int x,char[][] grid, boolean[][] visited){
        if( y >= 0 && y <= grid.length-1 && x >= 0 && x <= grid[y].length-1 && !visited[y][x] ){
            return true;
        }
        return false;
    }
          
}
    
    
  
    
    
    

```
