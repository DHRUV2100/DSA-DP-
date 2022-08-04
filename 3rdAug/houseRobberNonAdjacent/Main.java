package houseRobberNonAdjacent;

public class Main {
    public static int maxSumNonAdjacentSSCircular(int idx, int[] arr, boolean LTBP) {
        if (idx >= arr.length)
            return 0;
        // faith
        // yes
        int ans1 = 0;
        if (idx == 0)
            ans1 = maxSumNonAdjacentSSCircular(idx + 2, arr, false) + arr[idx];
        else if (idx == arr.length - 1) {
            if (LTBP == true)
                ans1 = maxSumNonAdjacentSSCircular(idx + 2, arr, LTBP) + arr[idx];
        } else {
            ans1 = maxSumNonAdjacentSSCircular(idx + 2, arr, LTBP) + arr[idx];
        }
        // no
        int ans2 = maxSumNonAdjacentSSCircular(idx + 1, arr, LTBP);
        return Math.max(ans1, ans2);
    }
    //wrong way to do memoisation for tjhis question

    // public static int maxSumNonAdjacentSSCircularMemo(int idx, int[] arr, boolean LTBP, int[] dp) {
    //     // bc
    //     if (idx == arr.length)
    //         return dp[idx] = 0;
    //     if (idx > arr.length)
    //         return 0;

    //     if (dp[idx] != 0) {
    //         return dp[idx];
    //     }
    //     // faith
    //     // yes
    //     int ans1 = 0;
    //     if (idx == 0)
    //         ans1 = maxSumNonAdjacentSSCircularMemo(idx + 2, arr, false, dp) + arr[idx];
    //     else if (idx == arr.length - 1) {
    //         if (LTBP == true)
    //             ans1 = maxSumNonAdjacentSSCircularMemo(idx + 2, arr, LTBP, dp) + arr[idx];
    //     } else {
    //         ans1 = maxSumNonAdjacentSSCircularMemo(idx + 2, arr, LTBP, dp) + arr[idx];
    //     }
    //     // no
    //     int ans2 = maxSumNonAdjacentSSCircularMemo(idx + 1, arr, LTBP, dp);
    //     return dp[idx] = Math.max(ans1, ans2);
    // }

    public static int maxSumNonAdjacentSSTabSO(int[] arr) {
        if(arr.length==1)
            return arr[0];
        int next2 = 0;
        int next1 = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            // yes
            int ans1 = next2 + arr[i];
            // no
            int ans2 = next1;
            int curr = Math.max(ans1, ans2);
            // update
            next2 = next1;
            next1 = curr;
        }
        return next1;
    }

    public static int HR(int[] arr) {
        if(arr.length==1)
            return arr[0];
        int[] arr1 = new int[arr.length - 1];
        int[] arr2 = new int[arr.length - 1];
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0)
                arr1[i1++] = arr[i];
            else if (i == arr.length-1)
                arr2[i2++] = arr[i];
            else{
                arr1[i1++]=arr[i];
                arr2[i2++]=arr[i];
            }    
        }
        int ansTakingFirstIndex=maxSumNonAdjacentSSTabSO(arr1);
        int ansTakingLastIndex=maxSumNonAdjacentSSTabSO(arr2);
        return Math.max(ansTakingFirstIndex,ansTakingLastIndex);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 1 };
        System.out.println(maxSumNonAdjacentSSCircular(0, arr, true));
        System.out.println(maxSumNonAdjacentSSCircularMemo(0, arr, true, new int[arr.length + 1]));
        System.out.println(HR(arr));
    }
}
