
class NumMatrix {

    int[][] prefix;

    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        prefix = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                prefix[i][j] = prefix[i - 1][j]
                             + prefix[i][j - 1]
                             + matrix[i - 1][j - 1]
                             - prefix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        int total = prefix[row2 + 1][col2 + 1];

        int top = prefix[row1][col2 + 1];

        int left = prefix[row2 + 1][col1];

        int overlap = prefix[row1][col1];

        return total - top - left + overlap;
    }
}
