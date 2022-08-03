import java.util.*;
import java.io.*;

public class Main {
    public static int maxSumNonAdjacentSS(int[] arr, int idx) {
        // bc
        if (idx >= arr.length)
            return 0;
        // faith
        // yes
        int ans1 = maxSumNonAdjacentSS(arr, idx + 2) + arr[idx];
        // no
        int ans2 = maxSumNonAdjacentSS(arr, idx + 1);
        return Math.max(ans1, ans2);
    }

    public static int maxSumNonAdjacentSSMem(int[] arr, int idx, int[] dp) {
        // bc
        if (idx == arr.length) {
            return dp[idx] = 0;
        }
        if (dp[idx] != 0) {
            return dp[idx];
        }
        System.out.println("f->" + idx);
        // faith
        // yes
        int ans1 = arr[idx], ans2 = 0;
        if (idx + 2 <= arr.length)
            ans1 += maxSumNonAdjacentSSMem(arr, idx + 2, dp);
        // no
        if (idx + 1 <= arr.length)
            ans2 = maxSumNonAdjacentSSMem(arr, idx + 1, dp);
        return dp[idx] = Math.max(ans1, ans2);
    }

    public static int maxSumNonAdjacentSSTab(int[] arr, int[] dp) {
        for (int i = arr.length; i >= 0; i--) {
            // base case
            if (i == arr.length)
                dp[i] = 0;
            else {
                int ans1 = arr[i];
                int ans2 = 0;
                // yes
                if (i + 2 <= arr.length) {
                    ans1 += dp[i + 2] ;
                }
                // no
                if (i + 1 <= arr.length) {
                    ans2 = dp[i + 1];
                }
                dp[i] = Math.max(ans1, ans2);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 25 };
        int n = arr.length;
        int[] dp = new int[n + 1];
        // System.out.println(maxSumNonAdjacentSS(arr, 0));
        // System.out.println(maxSumNonAdjacentSSMem(arr, 0, dp));
        // System.out.println(maxSumNonAdjacentSSTab(arr, dp));
        //space optimisation
        int next2=0;
        int next1=arr[arr.length-1];
        int curr=0;
        for(int i=arr.length-2;i>=0;i--){
            //yes
            int ans1=next2+arr[i];
            //no
            int ans2=next1;
            curr=Math.max(ans1, ans2);
            //update
            next2=next1;
            next1=curr;
        }
        System.out.println(curr);
    }
}
