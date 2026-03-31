class Solution {
    /*
    We treat the 3×3 boxes like a smaller grid.
    Each row of boxes has 3 boxes, so multiplying by 
    3 gives the starting index of that row, and then we add the column offset.   

    Why is boolean array better?”
    Ans:
    Both are O(n²), but the boolean array solution is more efficient because it scans 
    the board only once, avoids repeated passes, and uses simple array indexing instead of 
    HashSet operations, which have higher constant overhead and memory allocations.”
    */
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];
        
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.') continue;

                int num = board[i][j] -'1';
                int boxIndex = (i/3)*3 + (j/3);
                if(rows[i][num] || cols[j][num] || boxes[boxIndex][num]){
                    return false;
                } 
                rows[i][num] = true;
                cols[j][num] = true;
                boxes[boxIndex][num] = true;
            }
        }
        return true;
    }
}
