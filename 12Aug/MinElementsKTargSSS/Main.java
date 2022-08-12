
// package 12Aug.MinElementsKTargSSS;
import java.util.*;

public class Main {
    public static int minElementsKTargSumSSS(int i, int targ, int[] arr) {
        // bc
        if (i == 0) {
            if (targ == 0)
                return 0;
            else if (targ % arr[0] == 0) {
                return targ / arr[0];
            } else {
                return (int) Math.pow(10, 9);
            }
        }

        // faith
        int ansY = (int) Math.pow(10, 9);
        if (targ - arr[i] >= 0)
            ansY = 1 + minElementsKTargSumSSS(i, targ - arr[i], arr);
        int ansN = 0 + minElementsKTargSumSSS(i - 1, targ, arr);
        // System.out.println(i+" "+" "+targ+" "+ansY+" "+ansN);
        // exp
        int ans = Math.min(ansY, ansN);
        return ans;
    }

    public static int minElementsKTargSumSSSMemo(int i, int targ, int[] arr, int[][] dp) {
        // bc
        if (i == 0) {
            if (targ == 0)
                return dp[i][targ] = 0;
            else if (targ % arr[0] == 0) {
                return dp[i][targ] = targ / arr[0];
            } else {
                return dp[i][targ] = (int) Math.pow(10, 9);
            }
        }
        // subProb
        if (dp[i][targ] != -1)
            return dp[i][targ];
        // faith
        int ansY = (int) Math.pow(10, 9);
        if (targ - arr[i] >= 0)
            ansY = 1 + minElementsKTargSumSSSMemo(i, targ - arr[i], arr, dp);
        int ansN = 0 + minElementsKTargSumSSSMemo(i - 1, targ, arr, dp);
        // System.out.println(i+" "+" "+targ+" "+ansY+" "+ansN);
        // exp
        int ans = Math.min(ansY, ansN);
        return dp[i][targ] = ans;
    }

    public static int minElementsKTargSumSSSTabu(int[] arr, int targ) {
        int[][] dp = new int[arr.length][targ + 1];
        // dir
        for (int i = 0; i < dp.length; i++) {
            for (targ = 0; targ < dp[0].length; targ++) {
                // bc
                if (i == 0) {
                    if (targ == 0)
                        dp[i][targ] = 0;
                    else if (targ % arr[0] == 0) {
                        dp[i][targ] = targ / arr[0];
                    } else {
                        dp[i][targ] = (int) Math.pow(10, 9);
                    }
                } else {
                    // faith
                    int ansY = (int) Math.pow(10, 9);
                    if (targ - arr[i] >= 0)
                        ansY = 1 + dp[i][targ - arr[i]];
                    int ansN = 0 + dp[i-1][targ];
                    // System.out.println(i+" "+" "+targ+" "+ansY+" "+ansN);
                    // exp
                    int ans = Math.min(ansY, ansN);
                    dp[i][targ] = ans;
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
    // TC-O(items*targ)
    // SC-O(targ)
    public static int minElementsKTargSumSSSTabuSO(int[] arr,int targ){
        int[] prev=new int[targ+1];
        Arrays.fill(prev, -1);
        int[] curr=new int[targ+1];
        for (int i = 0; i < arr.length; i++) {
            for (targ = 0; targ < curr.length; targ++) {
                if (i == 0) {
                    if (targ == 0)
                        curr[targ] = 0;
                    else if (targ % arr[0] == 0) {
                        curr[targ] = targ / arr[0];
                    } else {
                        curr[targ] = (int) Math.pow(10, 9);
                    }
                } else {
                    // faith
                    int ansY = (int) Math.pow(10, 9);
                    if (targ - arr[i] >= 0)
                        ansY = 1 + curr[targ - arr[i]];
                    int ansN = 0 + prev[targ];
                    // System.out.println(i+" "+" "+targ+" "+ansY+" "+ansN);
                    // exp
                    int ans = Math.min(ansY, ansN);
                    curr[targ] = ans;
                }
            }
            //update curr and prev
            for (targ = 0; targ < prev.length; targ++) {
                prev[targ]=curr[targ];
            }
        }
        return prev[prev.length-1];
    }

    public static void main(String[] args) {

    }
}
