import java.util.*;
import java.io.*;

public class Main {

    public static int maxCreditGot(int[][] givenArr,int row,int lastActivityIdx){
        //bc
        if(row==givenArr.length){
            return 0;
        }
        //exp
        int ans=0;
        //faith
        for(int j=0;j<3;j++){
            if(j!=lastActivityIdx){
                int thisActivityAns=maxCreditGot(givenArr, row+1, j)+givenArr[row][j];
                ans=Math.max(thisActivityAns, ans);
            }
        }
        return ans;
    }
    public static int maxCreditGotMemo(int[][] givenArr,int row,int lastActivityIdx,int[][] dp){
        //bc
        if(row==givenArr.length){
            return 0;
        }
        //subproblem
        if(dp[row][lastActivityIdx]!=-1)
        {
            return dp[row][lastActivityIdx];
        }
        //exp
        int ans=0;
        //faith
        for(int j=0;j<3;j++){
            if(j!=lastActivityIdx){
                int thisActivityAns=maxCreditGotMemo(givenArr, row+1, j,dp)+givenArr[row][j];
                ans=Math.max(thisActivityAns, ans);
            }
        }
        return dp[row][lastActivityIdx]=ans;
    }
    public static void main(String[] args) {
        int[][] arr={{1,10,50}};
        int[][] dp=new int[arr.length][4];//columns to be 0 1 2 3 as the options of last actcivity
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j]=-1;
            }
        }
        System.out.println(maxCreditGotMemo(arr, 0, 3, dp));       

    }
}