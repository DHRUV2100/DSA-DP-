package ClimbStairs;

import java.io.*;
import java.util.*;

public class Main {
    // public static int allWaysClimbStairs(int i, int n) {
    //     // bc
    //     if (i == n) {
    //         return 1;// we have got one path
    //     }
    //     // faith
    //     System.out.println("f->"+i);
    //     int ans1 = 0, ans2 = 0, ans3 = 0;
    //     if (i + 1 <= n) {
    //         ans1 = allWaysClimbStairs(i + 1, n);
    //     }
    //     if (i + 2 <= n) {
    //         ans2 = allWaysClimbStairs(i + 2, n);
    //     }
    //     if (i + 3 <= n) {
    //         ans3 = allWaysClimbStairs(i + 3, n);
    //     }
    //     // exp
    //     int ans = ans1 + ans2 + ans3;
    //     return ans;
    // }

    public static int allWaysClimbStairsMem(int i, int n, int[] dp) {
        // bc
        if (i == n) {
            return dp[i] = 1;// we have got one path
        }
        // if subproblem already calculated
        if (dp[i] != 0) {
            System.out.println("f->"+i);
            return dp[i];
        }
        // faith
        int ans1 = 0, ans2 = 0, ans3 = 0;
        if (i + 1 <= n) {
            ans1 = allWaysClimbStairsMem(i + 1, n,dp);
        }
        if (i + 2 <= n) {
            ans2 = allWaysClimbStairsMem(i + 2, n,dp);
        }
        if (i + 3 <= n) {
            ans3 = allWaysClimbStairsMem(i + 3, n,dp);
        }
        // exp
        int ans = ans1 + ans2 + ans3;
        return dp[i] = ans;
    }
    public static int allWaysClimbStairsTab(int n,int [] dp){
        for(int i=n;i>=0;i--){
            if(i==n)
            {
                dp[i]=1;
            }
            else{
                int ans=0;
                if(i+1<=n){
                    ans+=dp[i+1];
                }
                if(i+2<=n){
                    ans+=dp[i+2];
                }
                if(i+3<=n){
                    ans+=dp[i+3];
                }
                dp[i]=ans;
            }
        }        
        return dp[0];
    }

    public static void main(String[] args) {
        int n=2;
        int[] dp = new int[n+1];
        // System.out.println(allWaysClimbStairs(0, 35));
        // System.out.println(allWaysClimbStairsTab(n,dp));
        int n3=1;
        int n2=1;
        int n1=2;
        int curr=0;
        for(int i=n-3;i>=0;i--){
            curr=n1+n2+n3;
            n3=n2;
            n2=n1;
            n1=curr;
        }
        System.out.println(curr);
    }
}
