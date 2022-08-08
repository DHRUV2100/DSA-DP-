// package 8thAug.AliceAndBob;

public class Main {
    public static int maxChocolates(int i, int j1, int j2, int[][] maze) {// we do not need to keep row positions for
                                                                          // both alice and bob as we are mving them
                                                                          // together.
        // bc
        if()
        // faith
        int maxAns = Integer.MIN_VALUE;
        for (int aliceDir = -1; aliceDir <= 1; aliceDir++) {
            for (int bobDir = -1; bobDir <= 1; bobDir++) {
                // not OOb
                if (j1 + aliceDir >= 0 && j1 + aliceDir < maze[0].length && j2 + bobDir >= 0
                        && j2 + bobDir < maze[0].length) {
                    // faith
                    int temp = maxChocolates(i + 1, j1 + aliceDir, j2 + bobDir, maze);
                    maxAns = Math.max(maxAns, temp);
                }
            }
        }
        // exp
        if (j1 == j2) {
            maxAns += maze[i][j1];// need to get this cell only once
        } else {
            maxAns += maze[i][j1] + maze[i][j2];
        }
        return maxAns;
    }

    public static int maxChocolatesMemo(int i, int j1, int j2, int[][] maze, int[][][] dp) {// we do not need to keep
                                                                                            // row positions for
        // both alice and bob as we are mving them
        // together.
        // bc
        if (i == maze.length - 1) {
            if (j1 == j2)
                return dp[i][j1][j2] = maze[i][j1];
            else if (j1 != j2) {
                return dp[i][j1][j2] = maze[i][j2] + maze[i][j1];
            }
        }
        // subProb
        if (dp[i][j1][j2] != 0)
            return dp[i][j1][j2];
        // faith
        int maxAns = Integer.MIN_VALUE;
        for (int aliceDir = -1; aliceDir <= 1; aliceDir++) {
            for (int bobDir = -1; bobDir <= 1; bobDir++) {
                // not OOb
                if (j1 + aliceDir >= 0 && j1 + aliceDir < maze[0].length && j2 + bobDir >= 0
                        && j2 + bobDir < maze[0].length) {
                    // faith
                    int temp = maxChocolatesMemo(i + 1, j1 + aliceDir, j2 + bobDir, maze, dp);
                    maxAns = Math.max(maxAns, temp);
                }
            }
        }
        // exp
        if (j1 == j2) {
            maxAns += maze[i][j1];// need to get this cell only once
        } else {
            maxAns += maze[i][j1] + maze[i][j2];
        }
        return dp[i][j1][j2] = maxAns;
    }

    public static int maxChocolatesTabu(int[][] maze, int[][][] dp) {
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j1 = 0; j1 < dp[0].length; j1++) {
                for (int j2 = 0; j2 < dp.length; j2++) {
                    if (i == maze.length - 1) {
                        if (j1 == j2)
                            dp[i][j1][j2] = maze[i][j1];
                        else if (j1 != j2) {
                            dp[i][j1][j2] = maze[i][j2] + maze[i][j1];
                        }
                    } else {
                        int maxAns=Integer.MIN_VALUE;
                        for (int aliceDir = -1; aliceDir <= 1; aliceDir++) {
                            for (int bobDir = -1; bobDir <= 1; bobDir++) {
                                // not OOb
                                if (j1 + aliceDir >= 0 && j1 + aliceDir < maze[0].length && j2 + bobDir >= 0
                                        && j2 + bobDir < maze[0].length) {
                                    // faith
                                    int temp = dp[i + 1][j1 + aliceDir][j2 + bobDir];
                                    maxAns = Math.max(maxAns, temp);
                                }
                            }
                        }
                        // exp
                        if (j1 == j2) {
                            maxAns += maze[i][j1];// need to get this cell only once
                        } else {
                            maxAns += maze[i][j1] + maze[i][j2];
                        }
                        dp[i][j1][j2] = maxAns;
                    }
                }
            }
        }
        return dp[0][0][maze[0].length-1];
    }

    public static void main(String[] args) {

    }
}
