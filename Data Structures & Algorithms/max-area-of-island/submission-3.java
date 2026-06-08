class Solution {
    private int row;
    private int col;
    private boolean[][] isVisited;
    private int maxArea = 0;

    public int maxAreaOfIsland(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        isVisited = new boolean[row][col];
        for(int r=0;r<row;r++){
            for(int c=0;c<col;c++){
                if(grid[r][c]==1 && !isVisited[r][c]){
                    int area = dfs(grid,r,c);
                    maxArea = Math.max(maxArea,area);
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid,int r, int c){
        isVisited[r][c] = true;

        int [] dr = {-1,0,0,1};
        int [] dc = {0,-1,1,0};
        int area = 1;
        for(int i=0;i<4;i++){
            int nr = r+dr[i];
            int nc = c+dc[i];
            if(isSafe(grid,nr,nc)){
                area +=dfs(grid,nr,nc);
            }
        }
        return area;
    }

    private boolean isSafe(int[][] grid,int r,int c){
        return r>=0 && r<row && c>=0 && c<col && grid[r][c]==1 && !isVisited[r][c];
    }
}
