class Solution {
    private int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
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

    private void dfs(int i, int j, int prev,int[][] heights,boolean[][] ocean){
        if(i<0 || i>=heights.length || j<0 || j>=heights[0].length){
            return;
        }
        if(heights[i][j] < prev || ocean[i][j]){
            return;
        }

        ocean[i][j] = true;
        for(int[] dr : dirs){
            int x = i+dr[0];
            int y = j+dr[1];
            dfs(x,y,heights[i][j],heights,ocean);
        }
    }
}
