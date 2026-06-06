class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] isVisited = new boolean[row][col];
        int islands = 0;
        for(int r=0;r<row;r++){
            for(int c=0;c<col;c++){
                if(grid[r][c]=='1' && !isVisited[r][c]){
                    dfs(grid,r,c,isVisited);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void dfs(char[][] grid,int r,int c, boolean[][] isVisited){
        isVisited[r][c] = true;
        int[] dr = {-1,0,0,1};
        int[] dc = {0,-1,1,0};
        for(int i=0;i<4;i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(isSafe(grid,nr,nc,isVisited)){
                dfs(grid,nr,nc,isVisited);
            }
        }
    }

    private boolean isSafe(char [][] grid,int r,int c,boolean[][] isVisited){
        int row = grid.length;
        int col = grid[0].length;
        return r>=0 && r<row && c>=0 && c<col && grid[r][c]=='1' && !isVisited[r][c];
    }
}
