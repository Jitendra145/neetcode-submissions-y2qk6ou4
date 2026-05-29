class Solution {
    private int boardSize;
    private int[] columnOccupied;
    private int[] mainDiagonal;
    private int[] antiDiagonal;
    private List<List<String>> ans = new ArrayList<>();
    private String [][] board;
    public List<List<String>> solveNQueens(int n) {
        boardSize = n;
        columnOccupied = new int[n];
        mainDiagonal = new int[2*n];
        antiDiagonal = new int[2*n];
        board = new String[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],".");
        }

        findQueens(0);
        return ans;
    }

    private void findQueens(int currentRow){
        if(currentRow == boardSize){
            List<String> currSolution = new ArrayList<>();
            for(int i=0;i<boardSize;i++){
                currSolution.add(String.join("",board[i]));
            }
            ans.add(currSolution);
            return;
        }

        for(int col=0;col<boardSize;col++){
            if(columnOccupied[col]+mainDiagonal[currentRow+col]+antiDiagonal[boardSize-currentRow+col]==0){
                board[currentRow][col]="Q";
                columnOccupied[col] = 1;
                mainDiagonal[currentRow+col] = 1;
                antiDiagonal[boardSize-currentRow+col] = 1;
                findQueens(currentRow+1);

                board[currentRow][col]=".";
                columnOccupied[col] = 0;
                mainDiagonal[currentRow+col] = 0;
                antiDiagonal[boardSize-currentRow+col] = 0;
            }
        }
    }
}
