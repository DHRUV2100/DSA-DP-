
// package 14aUG.rodCutting;
import java.util.*;;

public class Main {
    public static int maxSPRodCutting(int n, int[] arr) {
        // bc
        if (n == 0)
            return 0;
        // faith
        int ans = Integer.MIN_VALUE;
        for (int j = 1; j <= n; j++) {
            int temp = maxSPRodCutting(n - j, arr);
            temp += arr[j - 1];
            ans = Math.max(temp, ans);
        }
        return ans;
    }

    public static int maxSPRodCuttingMemo(int n, int[] arr, int[] dp) {
        // bc
        if (n == 0)
            return dp[n] = 0;
        // sub
        if (dp[n] != -1)
            return dp[n];
        // faith
        int ans = Integer.MIN_VALUE;
        for (int j = 1; j <= n; j++) {
            int temp = maxSPRodCuttingMemo(n - j, arr, dp);
            temp += arr[j - 1];
            ans = Math.max(temp, ans);
        }
        return dp[n] = ans;
    }

    public static int maxSPRodCuttingTabu(int[] arr, int n) {
        int[] dp = new int[n + 1];
            if (n == 0)
                dp[n] = 0;
            else{
                int ans = Integer.MIN_VALUE;
                for (int j = 1; j <= n; j++) {
                    int temp = dp[n - j];
                    temp += arr[j - 1];
                    ans = Math.max(temp, ans);
                }
                dp[n] = ans;
            }    
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args) {

    }
}
