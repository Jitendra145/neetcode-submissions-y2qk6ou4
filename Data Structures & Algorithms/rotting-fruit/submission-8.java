class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
                else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0) return 0;

        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        int times = 0;

        while(!q.isEmpty() && fresh > 0){
            int n = q.size();
            for(int i=0;i<n;i++){
                int[] curr = q.poll();
                for(int[] dir : dirs){
                    int x = curr[0]+dir[0];
                    int y = curr[1]+dir[1];
                    if(x<0 || x==grid.length || y<0 || y==grid[0].length || grid[x][y]!=1){
                        continue;
                    }
                    grid[x][y] = 2;
                    q.offer(new int[]{x,y});
                    fresh--;
                }
            }
            times++;
        }

        return fresh==0?times:-1;
    }
}
