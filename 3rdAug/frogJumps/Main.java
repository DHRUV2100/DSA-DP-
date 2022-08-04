
import java.io.*;
import java.util.*;
public class Main {
    public static int minE=Integer.MAX_VALUE;
    public static int minEnergy(int i,int n,int[] EnergyArr){
        //bc
        if(i==n){
            return 0;
        }
        int minAns1=Integer.MAX_VALUE;
        int minAns2=Integer.MAX_VALUE;
        //faith
        if(i+1<=n){
            minAns1=minEnergy(i+1, n,EnergyArr)+(int)Math.abs(EnergyArr[i]-EnergyArr[i+1]);
        }
        //2 jumps
        if(i+2<=n){
            minAns2=minEnergy(i+2, n,EnergyArr)+(int)Math.abs(EnergyArr[i]-EnergyArr[i+2]);
        }
        //exp
        int minAns=Math.min(minAns1,minAns2);
        return minAns;
    }
    public static int minEnergyMemo(int i,int n,int[] EnergyArr,int[] dp){
        //bc
        if(i==n){
            return dp[i]= 0;
        }
        //subroblem areadye xuists
        if(dp[i]!=0){
            return dp[i];
        }
        int minAns1=Integer.MAX_VALUE;
        int minAns2=Integer.MAX_VALUE;
        //faith
        if(i+1<=n){
            minAns1=minEnergyMemo(i+1, n,EnergyArr,dp)+(int)Math.abs(EnergyArr[i]-EnergyArr[i+1]);
        }
        //2 jumps
        if(i+2<=n){
            minAns2=minEnergyMemo(i+2, n,EnergyArr,dp)+(int)Math.abs(EnergyArr[i]-EnergyArr[i+2]);
        }
        //exp
        int minAns=Math.min(minAns1,minAns2);
        return dp[i]=minAns;
    }
    public static int frogJumpsTab(int n,int[] dp,int[] eArr){
        for(int i=dp.length;i>=0;i--){
            //base case
            if(i==n)
                dp[i]=0;
            else{
                int minAns1=Integer.MAX_VALUE;
                int minAns2=Integer.MAX_VALUE;
                if(i+1<=n){
                    minAns1=dp[i+1]+(int)Math.abs(eArr[i]-eArr[i+1]);
                }
                if(i+2<=n){
                    minAns2=dp[i+2]+(int)Math.abs(eArr[i]-eArr[i+2]);
                }
                dp[i]=Math.min(minAns1, minAns2);
            }
        }
        return dp[0];
    }
    public static void main(String[] args) {
        int n=4;
        int[] arr={10,20,30,10};
        //make frog's intila val and final stair value decrement by 1
        // System.out.println(minEnergy(0, n-1,arr));
        int[] dp=new int[n];
        // System.out.println(minEnergyMemo(0, n-1,arr,dp));
        // System.out.println(minEnergyMemo(0, n-1,arr,dp));
        //last step(space optimisisatkiojn)
        n=n-1;
        int next2=0;
        int next1=next2+(int)Math.abs(arr[n]-arr[n-1]);
        int curr=0;
        for(int i=n-2;i>=0;i--){
            curr=Math.min(next2+(int)Math.abs(arr[i]-arr[i+2]),next1+(int)Math.abs(arr[i]-arr[i+1]));
            //update
            next2=next1;
            next1=curr;
        }
        System.out.println(curr);
    }
}
