class Solution {
    private int row;
    private int col;
    public boolean exist(char[][] board, String word) {
        row = board.length;
        col = board[0].length;
        for(int r=0;r<row;r++){
            for(int c=0;c<col;c++){
                if(dfs(r,c,0,board,word)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int r, int c, int i, char[][] board,String word){
        if(i==word.length()){
            return true;
        }
        if(r<0 || r>=row || c<0 || c>=col || word.charAt(i)!=board[r][c]){
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
