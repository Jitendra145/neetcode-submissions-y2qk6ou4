class Solution {
    private boolean[][] isVisited;
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        isVisited = new boolean[row][col];

        int islands = 0;
        for(int r=0;r<row;r++){
            for(int c=0;c<col;c++){
                if(grid[r][c]=='1' && !isVisited[r][c]){
                    bfs(grid,r,c);
                    islands++;
                }
            }
        }        
        return islands;
    }

    private void bfs(char[][] grid,int startR, int startC){
        isVisited[startR][startC] = true;
        int[] dr = {-1,0,0,1};
        int[] dc = {0,-1,1,0};

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startR,startC});

        while(!q.isEmpty()){
            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];
            for(int i=0;i<4;i++){
                int nr = r+dr[i];
                int nc = c+dc[i];
                if(isSafe(grid,nr,nc)){
                    bfs(grid,nr,nc);
                }
            }
        }
    }
    private void dfs(char[][] grid,int r,int c){
        isVisited[r][c] = true;

        int dr[] = {-1,0,0,1};
        int dc[] = {0,-1,1,0};

        for(int i=0;i<4;i++){
            int nr = r+dr[i];
            int nc = c+dc[i];

            if(isSafe(grid,nr,nc)){
                dfs(grid,nr,nc);
            }
        }
    }

    private boolean isSafe(char[][] grid,int r, int c){
        int row = grid.length;
        int col = grid[0].length;

        return r>=0 && r<row && c>=0 && c<col && grid[r][c]=='1' && !isVisited[r][c];
    }
}
