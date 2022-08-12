

public class Main {
    public static boolean[] kSumSubsetTabuSO(int[] arr, int k) {
        // direc -->
        // -->
        boolean[] prev = new boolean[k + 1];
        boolean[] curr = new boolean[k + 1];
        // first row
        for (int targ = 0; targ < prev.length; targ++) {
            if (targ == 0)
                prev[targ] = true;
            else if (targ - arr[0] == 0)
                prev[targ] = true;
            else
                prev[targ]=false;
        }
        //1->n-1 rows
        for (int i = 1; i < arr.length; i++) {
            for (int targ = 0; targ < curr.length; targ++) {
                if(targ==0)
                    curr[targ]=true;
                else{
                    boolean ansY=false;
                    boolean ansN=false;
                    //yes
                    if(targ-arr[i]>=0)
                        ansY=prev[targ-arr[i]];
                    //no
                    ansN=prev[targ];
                    //exp
                    curr[targ]=ansY||ansN;
                }    
            }
            //update
            for (int j = 0; j < prev.length; j++) {
                prev[j]=curr[j];
            }
        }
        return prev;
    }

    public static int minSubsetSumDifference(int[] arr, int n) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        // s1
        int targ = sum / 2;
        // get the last row of the KSubSetSum with array and target as sum/2 --> this is
        // for s1
        boolean[] lastRowDp = kSumSubsetTabuSO(arr, targ);
        for (int i = lastRowDp.length-1; i >=0; i--) {
            if(lastRowDp[i]==true){
                // return sum-i;
                int s1=i;
                int s2=sum-i;
                return s1-s2;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        // System.out.println(kSumSubsetTabuSO(arr,30));
    }
}
