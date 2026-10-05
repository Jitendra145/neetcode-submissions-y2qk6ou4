class Solution {
    private boolean[][] isVisited;
    private int rows;
    private int cols;

    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        isVisited = new boolean[rows][cols];

        int islands = 0;
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(grid[r][c]=='1' && !isVisited[r][c]){
                    dfs(grid,r,c);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void dfs(char[][] grid,int i, int j){
        isVisited[i][j] = true;

        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        for(int[] dir : dirs){
            int x = i+dir[0];
            int y = j+dir[1];
            if(isSafe(grid,x,y)){
                dfs(grid,x,y);
            }
        }
    }

    private boolean isSafe(char[][] grid,int r,int c){
        return r>=0 && r<rows && c>=0 && c<cols && grid[r][c]=='1' &&  !isVisited[r][c];
    }
}
