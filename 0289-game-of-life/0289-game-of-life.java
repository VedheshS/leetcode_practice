class Solution {
    public void gameOfLife(int[][] arr) {
        if (arr.length <= 1 && arr[0].length <= 1) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++)
                    arr[i][j] = 0;
            }
        } else {
            int r = arr.length, c = arr[0].length;
            int[][] ans = new int[r][c];
            ;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    int cn = 0;
                    if (i > 0 && j > 0 && arr[i - 1][j - 1] == 1)
                        cn++;
                    if (i > 0 && arr[i - 1][j] == 1)
                        cn++;
                    if (j > 0 && arr[i][j - 1] == 1)
                        cn++;
                    if (i < r - 1 && arr[i + 1][j] == 1)
                        cn++;
                    if (j < c - 1 && arr[i][j + 1] == 1)
                        cn++;
                    if (i < r - 1 && j < c - 1 && arr[i + 1][j + 1] == 1)
                        cn++;
                    if (i > 0 && j < c - 1 && arr[i - 1][j + 1] == 1)
                        cn++;
                    if (i < r - 1 && j > 0 && arr[i + 1][j - 1] == 1)
                        cn++;
                    if (arr[i][j] == 1 && (cn == 2 || cn == 3))
                        ans[i][j] = 1;
                    if (arr[i][j] == 0 && cn == 3)
                        ans[i][j] = 1;
                }
            }
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    arr[i][j] = ans[i][j];
                }
            }
        }
    }
}