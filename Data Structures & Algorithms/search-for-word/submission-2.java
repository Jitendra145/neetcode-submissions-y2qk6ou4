class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        Set<String> set = new HashSet<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(dfs(i,j,0,board,word,set)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int r,int c,int i,char[][] board,String word,Set<String> set){
        if(i==word.length()){
            return true;
        }
        String key = r+"_"+c;
        if(r<0 ||c<0 || r>= board.length || c>=board[0].length || 
                word.charAt(i)!=board[r][c] ||set.contains(key)){
                    return false;
        }
        set.add(key);
        boolean res = (dfs(r+1,c,i+1,board,word,set) ||
                        dfs(r-1,c,i+1,board,word,set) ||
                         dfs(r,c+1,i+1,board,word,set) ||
                          dfs(r,c-1,i+1,board,word,set));
        set.remove(key);
        return res;
    }
}
