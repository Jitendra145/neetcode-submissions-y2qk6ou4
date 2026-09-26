class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(grid[r][c]==2){
                    q.offer(new int[]{r,c});
                }
                else if (grid[r][c]==1){
                    fresh++;
                }
            }
        }

        if(fresh==0) return 0;
        int[][] dirs = {{-1,0},{0,-1},{1,0},{0,1}};
        int time = 0;

        while(!q.isEmpty() && fresh > 0){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] cell = q.poll();
                for(int[] dir : dirs){
                    int x = cell[0]+dir[0];
                    int y = cell[1]+dir[1];
                    if(x<0 || x==rows || y<0 || y==cols || grid[x][y]!=1){
                        continue;
                    }
                    grid[x][y] = 2;
                    q.add(new int[]{x,y});
                    fresh--;
                }
            }
            time++;
        }

        return fresh==0?time:-1;
    }
}
