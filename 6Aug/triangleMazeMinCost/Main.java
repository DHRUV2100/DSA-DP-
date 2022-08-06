import java.io.*;
import java.util.*;

public class Main {
    public static int minCostTriangleMaze(int i, int j, int[][] maze) {
        // bc
        if (i == maze.length - 1)
            return maze[maze.length - 1][j];
        // faith
        // down
        int ansD = minCostTriangleMaze(i + 1, j, maze);
        // downright
        int ansDR = minCostTriangleMaze(i + 1, j + 1, maze);
        // exp
        int ans = Math.min(ansD, ansDR) + maze[i][j];
        return ans;
    }

    public static int minCostTriangleMazeMemo(int i, int j, int[][] maze, int[][] dp) {
        // bc
        if (i == maze.length - 1)
            return dp[i][j] = maze[maze.length - 1][j];
        // subProblem
        if (dp[i][j] != 0)
            return dp[i][j];
        // faith
        // down
        int ansD = minCostTriangleMazeMemo(i + 1, j, maze, dp);
        // downright
        int ansDR = minCostTriangleMazeMemo(i + 1, j + 1, maze, dp);
        // exp
        int ans = Math.min(ansD, ansDR) + maze[i][j];
        return dp[i][j] = ans;
    }

    public static int minCostTriangleMazeTabu(int[][] maze, int[][] dp) {
        // dir
        for (int i = maze.length - 1; i >= 0; i--) {
            for (int j = 0; j < dp[i].length; j++) {
                if (i == maze.length - 1)
                    dp[i][j] = maze[maze.length - 1][j];
                else {
                    //down
                    int ansD = dp[i + 1][j];
                    // downright
                    int ansDR = dp[i + 1][ j + 1];
                    // exp
                    int ans = Math.min(ansD, ansDR) + maze[i][j];
                    dp[i][j] = ans;
                }
            }
        }
        return dp[0][0];
    }
    public static int minCostTriangleMazeTabuSO(int[][] maze){
        int[] prev=new int[maze[maze.length-1].length]; 
        int[] curr=new int[maze[maze.length-1].length];
        //last row base case
        for (int i = 0; i < prev.length; i++) {
            prev[i]=maze[maze.length-1][i];
        } 
        //normal
        for(int i=maze.length-1;i>=0;i--){
            for(int j=0;j<=i;j++){
                int ansD=prev[j];
                int ansDR=prev[j+1];
                int ans=Math.min(ansD,ansDR)+maze[i][j];
                curr[j]=ans;
            }
            //update
            for (int j = 0; j < curr.length; j++) {
                prev[j]=curr[j];
            }
        }
        return curr[0];
    }
    public static void main(String[] args) {
        // int[][] trinagle
        int[][] triangle = { { 10 }, { 10, 12 }, { 10, 3, 32 } };
        int[][] dp = new int[triangle.length][];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new int[i + 1];
        }

    }
}