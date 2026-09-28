class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
                else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0) return 0;
        int[][] drs = {{-1,0},{1,0},{0,-1},{0,1}};
        int time = 0;

        while(!q.isEmpty() && fresh > 0){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] node = q.poll();
                for(int[] dr : drs){
                    int nr =node[0]+dr[0];
                    int nc = node[1]+dr[1];
                    if(nr<0 || nr>=rows ||nc<0 || nc>=cols || grid[nr][nc]!=1)
                        continue;
                    grid[nr][nc]= 2;
                    q.add(new int[]{nr,nc});
                    fresh--;
                }
            }
            time++;
        }

        return fresh==0?time:-1;
    }
}
