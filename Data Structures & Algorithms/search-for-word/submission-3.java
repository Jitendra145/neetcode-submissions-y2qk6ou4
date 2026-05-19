class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(dfs(i,j,0,board,word)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int r,int c,int i,char[][] board,String word){
        if(i==word.length()){
            return true;
        }
        
        if(r<0 ||c<0 || r>= board.length || c>=board[0].length || 
                word.charAt(i)!=board[r][c]){
                    return false;
        }
       char tmp = board[r][c];
       board[r][c] = '#';
       boolean res = (dfs(r+1,c,i+1,board,word) ||
                        dfs(r-1,c,i+1,board,word) ||
                         dfs(r,c+1,i+1,board,word) ||
                          dfs(r,c-1,i+1,board,word));
       board[r][c] = tmp;
       return res;
    }
}
