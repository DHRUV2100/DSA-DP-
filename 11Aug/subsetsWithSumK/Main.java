
// package 11Aug;
import java.util.*;

public class Main {
    public static int subsetsWithSumK(int i, int targ, int[] arr) {
        // bc
        if (targ == 0)
            return 1;
        if (i == 0) {
            if (targ == arr[0])
                return 1;
            return 0;
        }
        // faith
        int ans1WithYes = 0;
        int ans2WithNo = 0;
        // yes
        if (targ - arr[i] >= 0) {
            ans1WithYes = subsetsWithSumK(i - 1, targ - arr[i], arr);
        }
        // no
        ans2WithNo = subsetsWithSumK(i - 1, targ, arr);
        // exp
        int totWays = ans1WithYes + ans2WithNo;
        return totWays;
    }

    public static int subsetsWithSumKMemo(int i, int targ, int[] arr, int[][] dp) {
        // bc

        if (i == 0) {
            if (targ == arr[0])
                return dp[i][targ] = 1;
            else if (targ == 0)
                return dp[i][targ] = 1;
            return dp[i][targ] = 0;
        }
        // subprob
        if (dp[i][targ] != -1) {
            return dp[i][targ];
        }
        // faith
        int ans1WithYes = 0;
        int ans2WithNo = 0;
        // yes
        if (targ - arr[i] >= 0) {
            ans1WithYes = subsetsWithSumKMemo(i - 1, targ - arr[i], arr, dp);
        }
        // no
        ans2WithNo = subsetsWithSumKMemo(i - 1, targ, arr, dp);
        // exp
        int totWays = ans1WithYes + ans2WithNo;
        return dp[i][targ] = totWays;
    }

    public static int subsetsWithSumKTabu(int targ, int[] arr) {
        int[][] dp = new int[arr.length][targ + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0) {
                    if (targ == arr[0])
                        dp[i][targ] = 1;
                    else if (targ == 0)
                        dp[i][targ] = 1;
                    else
                        dp[i][targ] = 0;
                } else {
                    int ans1WithYes = 0;
                    int ans2WithNo = 0;
                    // yes
                    if (targ - arr[i] >= 0) {
                        ans1WithYes = dp[i - 1] [targ - arr[i]];
                    }
                    // no
                    ans2WithNo = dp[i - 1] [targ];
                    // exp
                    int totWays = ans1WithYes + ans2WithNo;
                    dp[i][targ] = totWays;
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 3 };
        System.out.println(subsetsWithSumK(arr.length - 1, 3, arr));
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }
    }
}
