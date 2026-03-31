class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int row=0;row<9;row++){
            Set<Character> set = new HashSet<>();
            for(int col=0;col<9;col++){
                char item = board[row][col];
                if(item !='.' && !set.add(item)){
                    return false;
                }
            }
        }

        for(int col=0;col<9;col++){
            Set<Character> set = new HashSet<>();
            for(int row=0;row<9;row++){
                char item = board[row][col];
                if(item !='.' && !set.add(item)){
                    return false;
                }
            }
        }

        int[][] sBoards = {{0,0},{0,3},{0,6},
                           {3,0},{3,3},{3,6},
                           {6,0},{6,3},{6,6}};
        for(int [] sBoard : sBoards){
            Set<Character> set = new HashSet<>();
            for(int row=sBoard[0];row<sBoard[0]+3;row++){
                for(int col=sBoard[1];col<sBoard[1]+3;col++){
                    char item = board[row][col];
                    if(item !='.' && !set.add(item)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
