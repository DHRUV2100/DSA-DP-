package 9Aug.partitionSubsetWithEquaulSum;
import java.util.*;
public class Main {
    //METHOD 1(WITHOUT DP)
    public static boolean isPartitionIn2SetsEqualSum(int[] arr,int i,int sumSS1,int sumSS2){
        //bc
        if(i==0)
        {
            //adding this element in ss1
            if(sumSS1+arr[0]==sumSS2)
                return true;
            //adding this element in ss2
            if(sumSS2+arr[0]==sumSS1)
                return true;
            return false;    
        }
        //faith
        //adding this element in SS1
        boolean ans1=isPartitionIn2SetsEqualSum(arr, i-1, sumSS1+arr[i], sumSS2);
        //adding this element in SS2
        boolean ans2=isPartitionIn2SetsEqualSum(arr, i-1, sumSS1, sumSS2+arr[i]);
        //exp
        boolean ans=ans1||ans2;
        return ans;
    }
    //METHOD2 
    public static boolean canPartition(int[] arr, int n) {
        int arrSum=0;
        for(int i:arr)
            arrSum+=i;
        if(arrSum%2==0){
            boolean ans=isTargetPresentInSubseqTabuSO(arr, arrSum/2);
            return ans;
        }   
        else{
            //sum is odd cant divide in 2 sums
            return false;
        } 
	}
    
    public static boolean isTargetPresentInSubseqTabuSO(int[] arr,int targ){
        //prev and curr
        boolean[] prev=new boolean[targ+1];
        boolean[] curr=new boolean[targ+1];
        //bc first row
        for (int k = 0; k < prev.length; k++) {
            if(k==0)
                prev[k]=true;
            if(k-arr[0]==0)
                prev [k]=true;
        }
        //normal
        for(int i=1;i<arr.length;i++){
            for (int k = 0; k < curr.length; k++) {
                boolean ansY=false;
                boolean ansN=false;
                if(k-arr[i]>=0)
                {
                    ansY=prev[k-arr[i]];
                }    
                ansN=prev[k];
                curr[k]=ansY||ansN;
            }
            //update
            prev=curr;
        }
        return prev[prev.length-1];
    }
    public static void main(String[] args) {
        
    }
}
