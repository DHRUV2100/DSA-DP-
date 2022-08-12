
// package 12Aug.0-1KnapSack;
import java.util.*;

public class Main {
    public static int maxValueUnderKnapSack(int i, int capacity, int[] wt, int[] val) {
        // bc
        if (i == 0) {
            if (capacity - wt[i] >= 0)
                return val[0];
            else
                return 0;
        }
        // faith
        int ansY = Integer.MIN_VALUE;
        int ansN = Integer.MIN_VALUE;
        // yes
        if (capacity - wt[i] >= 0)
            ansY = val[i] + maxValueUnderKnapSack(i - 1, capacity - wt[i], wt, val);
        // no
        ansN = 0 + maxValueUnderKnapSack(i - 1, capacity, wt, val);
        int maxAns = Math.max(ansY, ansN);
        return maxAns;
    }

    public static int maxValueUnderKnapSackMemo(int i, int capacity, int[] wt, int[] val, int[][] dp) {
        // bc
        if (i == 0) {
            if (capacity - wt[i] >= 0)
                return dp[i][capacity] = val[0];
            else
                return dp[i][capacity] = 0;
        }
        // subP
        if (dp[i][capacity] != -1)
            return dp[i][capacity];
        // faith
        int ansY = Integer.MIN_VALUE;
        int ansN = Integer.MIN_VALUE;
        // yes
        if (capacity - wt[i] >= 0)
            ansY = val[i] + maxValueUnderKnapSackMemo(i - 1, capacity - wt[i], wt, val, dp);
        // no
        ansN = 0 + maxValueUnderKnapSackMemo(i - 1, capacity, wt, val, dp);
        int maxAns = Math.max(ansY, ansN);
        return dp[i][capacity] = maxAns;
    }

    public static int maxValueUnderKnapSackTabu(int capacity, int[] wt, int[] val) {
        int[][] dp = new int[wt.length][capacity + 1];
        for (int i = 0; i < dp.length; i++) {
            for (capacity = 0; capacity < dp[0].length; capacity++) {
                // bc
                if (i == 0) {
                    if (capacity - wt[i] >= 0)
                        dp[i][capacity] = val[0];
                    else
                        dp[i][capacity] = 0;
                }

                // faith
                int ansY = Integer.MIN_VALUE;
                int ansN = Integer.MIN_VALUE;
                // yes
                if (capacity - wt[i] >= 0)
                    ansY = val[i] + dp[i - 1][capacity-wt[i]];
                // no
                ansN = 0 + maxValueUnderKnapSackMemo(i - 1, capacity, wt, val, dp);
                int maxAns = Math.max(ansY, ansN);
                return dp[i][capacity] = maxAns;
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static void main(String[] args) {

    }
}
