
// package 7Aug.maxCostPath2D;
import java.util.*;
import java.io.*;

public class Main {
    public static int maxCost(int i, int j, int[][] maze) {
        // bc
        if (i == maze.length - 1)
            return maze[i][j];
        // faith
        int ansDL = Integer.MIN_VALUE;
        int ansD = Integer.MIN_VALUE;
        int ansDR = Integer.MIN_VALUE;
        // OOB DL
        if (j - 1 >= 0)
            ansDL = maxCost(i + 1, j - 1, maze);
        // D
        ansD = maxCost(i + 1, j, maze);
        // OOB DR
        if (j + 1 < maze[0].length)
            ansDR = maxCost(i + 1, j + 1, maze);
        // exp
        int ans = Math.max(ansDL, Math.max(ansD, ansDR)) + maze[i][j];
        return ans;

    }

    public static int maxCostMemo(int i, int j, int[][] maze, int[][] dp) {
        // bc
        if (i == maze.length - 1)
            return dp[i][j] = maze[i][j];
        // subprob
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        // faith
        int ansDL = Integer.MIN_VALUE;
        int ansD = Integer.MIN_VALUE;
        int ansDR = Integer.MIN_VALUE;
        // OOB DL
        if (j - 1 >= 0)
            ansDL = maxCostMemo(i + 1, j - 1, maze, dp);
        // D
        ansD = maxCostMemo(i + 1, j, maze, dp);
        // OOB DR
        if (j + 1 < maze[0].length)
            ansDR = maxCostMemo(i + 1, j + 1, maze, dp);
        // exp
        int ans = Math.max(ansDL, Math.max(ansD, ansDR)) + maze[i][j];
        return dp[i][j] = ans;

    }

    public static int maxCostTabu(int[][] maze, int[][] dp) {
        // direc
        for (int i = maze.length - 1; i >= 0; i--) {
            for (int j = 0; j < maze[0].length; j++) {
                if (i == maze.length - 1)
                    dp[i][j] = maze[i][j];
                else {
                    int ansDL = Integer.MIN_VALUE;
                    int ansD = Integer.MIN_VALUE;
                    int ansDR = Integer.MIN_VALUE;
                    // OOB DL
                    if (j - 1 >= 0)
                        ansDL = dp[i + 1][j - 1];
                    // D
                    ansD = dp[i + 1][j];
                    // OOB DR
                    if (j + 1 < maze[0].length)
                        ansDR = dp[i + 1][j + 1];
                    // exp
                    int ans = Math.max(ansDL, Math.max(ansD, ansDR)) + maze[i][j];
                    dp[i][j] = ans;
                }
            }
        }
        //get the max answer fromt he first row of dp
        int maxAns=Integer.MIN_VALUE;
        for(int j=0;j<dp[0].length;j++){
            maxAns=Math.max(dp[0][j], maxAns);
        }
        return maxAns;
    }
    public static int maxCostTabuSO(int[][] maze){
        int[] prev=new int[maze[0].length];
        int[] curr=new int[maze[0].length];
        //bc
        for(int j=0;j<maze[0].length;j++){
            prev[j]=maze[maze.length-1][j];
        }
        //normal
        for (int i = maze.length-2; i>=0; i--) {
            for (int j = 0; j < maze[0].length; j++) {
                int ansDL = Integer.MIN_VALUE;
                    int ansD = Integer.MIN_VALUE;
                    int ansDR = Integer.MIN_VALUE;
                    // OOB DL
                    if (j - 1 >= 0)
                        ansDL = prev[j - 1];
                    // D
                    ansD = prev[j];
                    // OOB DR
                    if (j + 1 < maze[0].length)
                        ansDR = prev[j + 1];
                    // exp
                    int ans = Math.max(ansDL, Math.max(ansD, ansDR)) + maze[i][j];
                    curr[j] = ans;
            }
            //update prev to curr
            for (int j = 0; j < curr.length; j++) {
                prev[j]=curr[j];
            }
        }
        //max
        int maxAns=Integer.MIN_VALUE;
        for (int i = 0; i < prev.length; i++) {
            maxAns=Math.max(prev[i], maxAns);
        }
        return maxAns;
    }
    public static void main(String[] args) {
        for(){
            //dp update 
        }
        //ans
        //dp first row max answer 
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
}
