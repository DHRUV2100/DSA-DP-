
// package 12Aug.NoOfPartitionsWithDDifference;
import java.util.*;

public class Main {
    public static int countPartitions(int n, int d, int[] arr) {
        // Write your code here.
        // get the sum of elems of the array
        int totSum=0;
        for (int i = 0; i < arr.length; i++) {
            totSum+=arr[i];
        }
        int s1=totSum/2;
        int s2=totSum-s1;
        //even odd check
        if(totSum%2==0){
            if(d%2==0){
                while(s2-s1!=d){
                    s1--;
                    s2++;
                }
            }
            else{
                return 0;
            }
        }
        else if(totSum%2!=0){
            if(d%2==0){
                return 0;
            }
            else{
                while(s2-s1!=d){
                    s1--;
                    s2++;
                }
            }
        }
        //we got valid values for s1 ans s2
        //now all we need to do is get the no of subsets having value of s1 
        int ans=getSubSetsWithSumKTabuSO(arr,s1);
        return ans;
    }
    public static int getSubSetsWithSumKTabuSO(int[] arr,int targ){
        int[] prev=new int[targ+1];
        int[] curr=new int[targ+1];
        //first row fill
        for (int k = 0; k < prev.length; k++) {
            if(k==0 && k==arr[0])
                prev[k]=2;
            else if(k==0 || k==arr[0])
                prev[k]=1;    
            else{
                prev[k]=0;
            }
        }
        //rows 1-> n-1
        for (int i = 1; i < arr.length; i++) {
            for (int k = 0; k < curr.length; k++) {
                int ans1WithYes=0;
                int ans2WithNo=0;
                if(k-arr[i]>=0){
                    ans1WithYes=prev[k-arr[i]];
                }
                ans2WithNo=prev[k];
                int ans=ans1WithYes+ans2WithNo;
                curr[k]=ans;
            }
            //update
            for (int k = 0; k < prev.length; k++) {
                prev[k]=curr[k];
            }
        }
        // display(prev);
        return prev[targ];
    }
    public static void display(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr={0,1,2};
        System.out.println(getSubSetsWithSumKTabuSO(arr, 2));
        
    }
}
