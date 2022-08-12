import java.util.Scanner;

// package 8thAug.TargSubProb1;

public class Main {
    public static boolean isTargetPresentInSubseq(int i, int target, int[] arr) {
        // bc
        if (target == 0)
            return true;
        if (i == 0) {
            int ans = target - arr[i];
            if (ans == 0) {
                return true;

            }
            return false;
        }
        boolean ansY = false, ansN = false;
        // faith
        // yes
        if (target - arr[i] >= 0)
            ansY = isTargetPresentInSubseq(i - 1, target - arr[i], arr);
        // no
        ansN = isTargetPresentInSubseq(i - 1, target, arr);
        // exp
        return ansY || ansN;

    }

    public static boolean isTargetPresentInSubseqMemo(int i, int target, int[] arr, int[][] dp) {
        // bc
        if (target == 0) {
            dp[i][target] = 1;
            return true;
        }
        if (i == 0) {
            int ans = target - arr[i];
            if (ans == 0) {
                dp[i][target] = 1;
                return true;

            }
            return false;
        }
        // sub
        if (dp[i][target] != -1) {
            // /-1 represents cell values isnt solved yet 1 represnts true and 0 represents
            // false
            return (dp[i][target] == 1);
        }
        boolean ansY = false, ansN = false;
        // faith
        // yes
        if (target - arr[i] >= 0)
            ansY = isTargetPresentInSubseqMemo(i - 1, target - arr[i], arr, dp);
        // no
        ansN = isTargetPresentInSubseqMemo(i - 1, target, arr, dp);
        // exp
        dp[i][target] = (ansY || ansN == true) ? 1 : 0;
        return (ansY || ansN);

    }

    public static boolean isTargetPresentInSubseqTabu(int[] arr, int targ) {
        // make dp
        boolean[][] dp = new boolean[arr.length][targ + 1];
        // dir-> row wise traversla from top
        for (int i = 0; i < dp.length; i++) {
            for (int k = 0; k < dp[0].length; k++) {
                // bc
                if (k == 0) {
                    dp[i][k] = true;
                } else if (i == 0) {
                    int ans = k - arr[i];
                    if (ans == 0) {
                        dp[i][k] = true;

                    } else
                        dp[i][k] = false;
                } else {
                    boolean ansY = false, ansN = false;
                    // faith
                    // yes
                    if (k - arr[i] >= 0)
                        ansY = dp[i - 1][k - arr[i]];
                    // no
                    ansN = dp[i - 1][k];
                    // exp
                    dp[i][k] = (ansY || ansN);
                }
            }
        }
        return dp[arr.length - 1][targ];
    }

    public static boolean isTargetPresentInSubseqTabuSO(int[] arr, int k) {
        boolean[] prev = new boolean[k + 1];
        boolean[] curr = new boolean[k + 1];
        // bc if idx==0
        for (int targ = 0; targ <= k; targ++) {
            if (targ == 0)
                prev[targ] = true;
            else if (targ - arr[0] == 0)
                prev[targ] = true;
            else {
                prev[targ] = false;
            }
        }
        //for 1->n-1 rows
        for (int i = 1; i < arr.length; i++) {
            for (int targ = 0; targ < curr.length; targ++) {
                if(targ==0)
                    curr[targ]=true;
                else{
                    boolean ansY = false, ansN = false;
                    // faith
                    // yes
                    if (targ- arr[i] >= 0)
                        ansY = prev[targ - arr[i]];
                    // no
                    ansN = prev[targ];
                    // exp
                    curr[targ] =ansY || ansN;
                }    
            }
            //update prev and curr
            for (int j = 0; j < curr.length; j++) {
                prev[j]=curr[j];
            }
        }
        return prev[prev.length-1];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] arr = { 1, 2, 3, 4 };
        int k = scn.nextInt();
        int[][] dp = new int[arr.length][k + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(isTargetPresentInSubseq(arr.length - 1, 6, arr));

    }
}
