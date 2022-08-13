// package 13Aug.CoinsInfSupply;

public class Main {
    public static int countKTargSSS(int i, int targ, int[] arr) {
        // bc
        if (i == 0) {
            if (targ % arr[0] == 0) {
                return 1;
            }
            return 0;
        }
        // faith
        int ansY = 0;
        int ansN = 0;
        if (targ - arr[i] >= 0)
            ansY = countKTargSSS(i, targ - arr[i], arr);
        ansN = countKTargSSS(i - 1, targ, arr);
        // exp
        int ans = ansN + ansY;
        return ans;
    }

    public static int countKTargSSSMemo(int i, int targ, int[] arr, int[][] dp) {
        // bc
        if (i == 0) {
            if (targ % arr[0] == 0) {
                return dp[i][targ] = 1;
            }
            return dp[i][targ] = 0;
        }
        // sub
        if (dp[i][targ] != -1)
            return dp[i][targ];
        // faith
        int ansY = 0;
        int ansN = 0;
        // yes
        if (targ - arr[i] >= 0)
            ansY = countKTargSSSMemo(i, targ - arr[i], arr, dp);
        // no
        ansN = countKTargSSSMemo(i - 1, targ, arr, dp);
        // exp
        int ans = ansN + ansY;
        return dp[i][targ] = ans;
    }

    public static long countKTargSSSMemo(int i, int targ, int[] arr, long[][] dp) {
        // bc
        if (i == 0) {
            if (targ % arr[0] == 0) {
                return dp[i][targ] = 1;
            }
            return dp[i][targ] = 0;
        }
        // sub
        if (dp[i][targ] != -1)
            return dp[i][targ];
        // faith
        long ansY = 0;
        long ansN = 0;
        // yes
        if (targ - arr[i] >= 0)
            ansY = countKTargSSSMemo(i, targ - arr[i], arr, dp);
        // no
        ansN = countKTargSSSMemo(i - 1, targ, arr, dp);
        // exp
        long ans = ansN + ansY;
        return dp[i][targ] = ans;
    }

    public static long countKTargSSSTabu(int[] arr, int targ) {
        long[][] dp = new long[arr.length][targ + 1];
        // dir
        for (int i = 0; i < arr.length; i++) {
            for (targ = 0; targ < dp[0].length; targ++) {
                if (i == 0) {
                    if (targ % arr[0] == 0) {
                        dp[i][targ] = 1;
                    } else
                        dp[i][targ] = 0;
                } else {
                    // faith
                    long ansY = 0;
                    long ansN = 0;
                    // yes
                    if (targ - arr[i] >= 0)
                        ansY = dp[i][targ - arr[i]];
                    // no
                    ansN = dp[i - 1][targ];
                    // exp
                    long ans = ansN + ansY;
                    dp[i][targ] = ans;
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static long getSubSetsWithSumKTabuSO(int[] arr, int targ) {
        long[] prev = new long[targ + 1];
        long[] curr = new long[targ + 1];
        for (int i = 0; i < arr.length; i++) {
            for (targ = 0; targ < curr.length; targ++) {
                if (i == 0) {
                    if (targ % arr[0] == 0) {
                        curr[targ] = 1;
                    } else
                        curr[targ] = 0;
                } else {
                    // faith
                    long ansY = 0;
                    long ansN = 0;
                    // yes
                    if (targ - arr[i] >= 0)
                        ansY = curr[targ - arr[i]];
                    // no
                    ansN = prev[targ];
                    // exp
                    long ans = ansN + ansY;
                    curr[targ] = ans;
                }
            }
            //update prev and curr
            for (targ = 0; targ < prev.length; targ++) {
                prev[targ]=curr[targ];
            }
        }
        return prev[prev.length-1];
    }

    public static void main(String[] args) {

    }
}
