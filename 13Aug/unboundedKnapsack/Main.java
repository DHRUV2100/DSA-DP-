
// package 13Aug.unboundedKnapsack;
import java.util.*;

public class Main {
    public static int unboundedKnapsack(int i, int cap, int[] wt, int[] val) {
        // bc
        if (i == 0) {
            if (cap - wt[0] < 0)
                return 0;
            else {
                return (cap / wt[0]) * val[0];
            }
        }
        // faith
        int ansY = Integer.MIN_VALUE;
        int ansN = Integer.MIN_VALUE;
        // yes inf method
        if (cap - wt[i] >= 0) {
            ansY = val[i] + unboundedKnapsack(i, cap - wt[i], wt, val);
        }
        ansN = 0 + unboundedKnapsack(i - 1, cap, wt, val);
        // exp
        int ans = Math.max(ansY, ansN);
        return ans;
    }

    public static int unboundedKnapsackMemo(int i, int cap, int[] wt, int[] val, int[][] dp) {
        // bc
        if (i == 0) {
            if (cap - wt[0] < 0)
                return dp[i][cap] = 0;
            else {
                return dp[i][cap] = (cap / wt[0]) * val[0];
            }
        }
        // sub
        if (dp[i][cap] != -1)
            return dp[i][cap];
        // faith
        int ansY = Integer.MIN_VALUE;
        int ansN = Integer.MIN_VALUE;
        // yes inf method
        if (cap - wt[i] >= 0) {
            ansY = val[i] + unboundedKnapsackMemo(i, cap - wt[i], wt, val, dp);
        }
        ansN = 0 + unboundedKnapsackMemo(i - 1, cap, wt, val, dp);
        // exp
        int ans = Math.max(ansY, ansN);
        return dp[i][cap] = ans;
    }

    public static int unboundedKnapsackTabu(int cap, int[] wt, int[] val) {
        int[][] dp = new int[wt.length][cap + 1];
        // dir
        for (int i = 0; i < dp.length; i++) {
            for (cap = 0; cap < dp[0].length; cap++) {
                // bc
                if (i == 0) {
                    if (cap - wt[0] < 0)
                        dp[i][cap] = 0;
                    else {
                        dp[i][cap] = (cap / wt[0]) * val[0];
                    }
                } else {
                    // faith
                    int ansY = Integer.MIN_VALUE;
                    int ansN = Integer.MIN_VALUE;
                    // yes inf method
                    if (cap - wt[i] >= 0) {
                        ansY = val[i] + dp[i][cap - wt[i]];
                    }
                    ansN = 0 + dp[i - 1][cap];
                    // exp
                    int ans = Math.max(ansY, ansN);
                    dp[i][cap] = ans;
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int cap = scn.nextInt();
        int[] wt = new int[n];
        int[] val = new int[n];
        for (int i = 0; i < wt.length; i++) {
            wt[i] = scn.nextInt();
        }
        for (int i = 0; i < val.length; i++) {
            val[i] = scn.nextInt();
        }
        System.out.print(unboundedKnapsackTabu(cap, wt, val));
    }
}
