class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;

        for(int r=0;r<row;r++){
            for(int c=0;c<col;c++){
                if(backtrack(board,word,r,c,0)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean backtrack(char[][] board,String word,int r, int c, int i){
        if(i==word.length()){
            return true;
        }

        if(r<0 || r>=board.length || c<0 || c>=board[0].length ||
                 word.charAt(i)!=board[r][c]){
            return false;
        }

        char tmp = board[r][c];
        board[r][c] = '#';

        boolean res = (backtrack(board,word,r+1,c,i+1) ||
                        backtrack(board,word,r-1,c,i+1) ||
                        backtrack(board,word,r,c+1,i+1) ||
                        backtrack(board,word,r,c-1,i+1));
        board[r][c] = tmp;

        return res;
    }
}
