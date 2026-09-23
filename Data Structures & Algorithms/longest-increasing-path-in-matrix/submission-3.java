class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int ans = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] memo = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                memo[i][j] = -1;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans = Math.max(ans,longestIncPath(i,j,matrix,n,m,memo));
            }
        }
        return ans;
    }

    private int longestIncPath(int i,int j,int[][] matrix,int n,int m,int[][] memo){
        if(memo[i][j]!=-1){
            return memo[i][j];
        }
        int ans = 1;

        int[][] drs = {{-1,0},{1,0},{0,-1},{0,1}};
        for(int[] dr : drs){
            int x = i+dr[0], y = j+dr[1];
            if(isValid(x,y,matrix,n,m,matrix[i][j])){
                ans = Math.max(ans, 1+longestIncPath(x,y,matrix,n,m,memo));
            }
        }
        memo[i][j] = ans;
        return ans;
    }

    private boolean isValid(int x,int y, int[][] matrix,int n,int m,int prev){
        return x>=0 && x<n && y>=0 && y<m && matrix[x][y] >prev;
    }
}
