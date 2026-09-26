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
            for(int c=0; c<cols; c++){
                if(grid[r][c]=='1' && !isVisited[r][c]){
                    dfs(grid,r,c);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void dfs(char[][] grid, int r, int c){
        isVisited[r][c] = true;

        int[] dr = {-1,0,0,1};
        int[] dc = {0,-1,1,0};
        for(int i=0;i<4;i++){
            int nr = r+dr[i];
            int nc = c+dc[i];
            if(isSafe(grid,nr,nc)){
                dfs(grid,nr,nc);
            }
        }
    }

    private boolean isSafe(char[][] grid,int r, int c){
        return r>=0 && r<rows && c>=0 && c<cols && grid[r][c]=='1' && !isVisited[r][c];
    }
}
