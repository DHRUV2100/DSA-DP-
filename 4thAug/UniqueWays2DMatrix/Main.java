// package 4thAug.UniqueWays2DMatrix;

public class Main {
    public static int allWaysPossible(int i, int j, int m, int n) {
        // bc
        // if racvhe don target we find a way
        if (i == 0 && j == 0)
            return 1;
        // out of bounds
        if (i < 0 || j < 0)
            return 0;
        // faith
        // upper move
        int ansU = allWaysPossible(i - 1, j, m, n);
        // left move
        int ansL = allWaysPossible(i, j - 1, m, n);
        // exp
        int ans = ansU + ansL;
        return ans;
    }

    public static int allWaysPossibleMemo(int i, int j, int[][] dp) {
        // bc
        // if racvhe don target we find a way
        if (i == 0 && j == 0)
            return dp[0][0] = 1;
        // out of bounds
        if (i < 0 || j < 0)
            return 0;
        // subproblem
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        // faith
        // upper move
        int ansU = allWaysPossibleMemo(i - 1, j, dp);
        // left move
        int ansL = allWaysPossibleMemo(i, j - 1, dp);
        // exp
        int ans = ansU + ansL;
        return dp[i][j] = ans;
    }

    public static int uniquePaths(int m, int n) {
        // Write your code here.
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                dp[i][j] = -1;
        }
        int ans = allWaysPossibleMemo(m - 1, n - 1, dp);
        // for(int i=0;i<m;i++){
        // for(int j=0;j<n;j++)
        // System.out.print(dp[i][j]);
        // System.out.println();
        // }
        return ans;

    }

    public static int allWaysPossibleTabu(int i, int j) {
        // we know the direction-->
        // -->
        // -->
        int[][] dp = new int[i + 1][j + 1];
        for (int r = 0; r <= i; r++) {
            for (int c = 0; c <= j; c++) {
                // bc
                if (i == 0 && j == 0) {
                    dp[r][c] = 1;
                } else {
                    int ansU = 0;
                    int ansL = 0;
                    // upper call
                    if (r != 0) {
                        ansU = dp[r - 1][c];
                    }
                    // left call
                    if (c != 0) {
                        ansL = dp[r][c - 1];
                    }
                    dp[r][c] = ansU + ansL;
                }
            }
        }
        return dp[i][j];
    }

    public static int allWaysPossibleTabuSO(int i, int j) {
        // we know the direction-->
        // -->
        // -->
        int[] prev = new int[j];
        int[] curr = new int[j];
        for (int k = 0; k < curr.length; k++) {
            prev[k] = 1;
        }
        for (int r = 0; r < i - 1; r++) {
            {
                for (int c = 0; c < j; c++) {
                    if (c == 0) {
                        curr[c] = prev[c];
                    } else {
                        curr[c] = prev[c] + curr[c - 1];
                    }
                }
                // update prev to curr
                for (int idx = 0; idx < prev.length; idx++)
                    prev[idx] = curr[idx];
            }
        }
        return prev[j - 1];
    }

    public static void main(String[] args) {
        System.out.println(allWaysPossibleTabuSO(2, 2));
    }
}
