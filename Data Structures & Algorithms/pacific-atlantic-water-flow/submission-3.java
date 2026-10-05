class Solution {
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        if(heights==null || heights.length==0 || heights[0].length==0){
            return res;
        }
        int r = heights.length;
        int c = heights[0].length;
        boolean[][] pac = new boolean[r][c];
        boolean[][] atl = new boolean[r][c];

        for(int i=0;i<r;i++){
            dfs(i,0,Integer.MIN_VALUE,heights,pac);
            dfs(i,c-1,Integer.MIN_VALUE,heights,atl);
        }

        for(int i=0;i<c;i++){
            dfs(0,i,Integer.MIN_VALUE,heights,pac);
            dfs(r-1,i,Integer.MIN_VALUE,heights,atl);
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(pac[i][j] && atl[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }

        return res;
    }

    private void dfs(int r, int c, int prev,int[][] heights, boolean[][] ocean){
        if(r<0 || r>=heights.length ||c<0 || c>=heights[0].length){
            return;
        }
        if(heights[r][c] < prev || ocean[r][c]){
            return;
        }
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        ocean[r][c] = true;
        for(int[] dir : dirs){
            int x = r+dir[0];
            int y = c+dir[1];
            dfs(x,y,heights[r][c],heights,ocean);
        }
    }
}
