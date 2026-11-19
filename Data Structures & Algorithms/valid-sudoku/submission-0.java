class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char ch = board[r][c];
                if (ch == '.') continue;

                // check row
                for (int j = 0; j < 9; j++) {
                    if (j != c && board[r][j] == ch) return false;
                }

                // check column
                for (int i = 0; i < 9; i++) {
                    if (i != r && board[i][c] == ch) return false;
                }

                // check 3x3 box
                int startRow = (r / 3) * 3;
                int startCol = (c / 3) * 3;
                for (int i = startRow; i < startRow + 3; i++) {
                    for (int j = startCol; j < startCol + 3; j++) {
                        if ((i != r || j != c) && board[i][j] == ch) return false;
                    }
                }
            }
        }
        return true;
    }
}