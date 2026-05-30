class Solution {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int perimeter = 0;

        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                if(grid[row][col]==1){
                    perimeter +=4;
                    if(row <rows-1 && grid[row+1][col]==1){
                        perimeter -= 2;
                    }
                    if(col < cols-1 && grid[row][col+1]==1){
                        perimeter -= 2;
                    }
                }
            }
        }
        return perimeter;
    }
}