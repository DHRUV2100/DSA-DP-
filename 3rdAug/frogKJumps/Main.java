import java.util.*;
import java.io.*;
public class Main {
    public static int MinEnergy(int i, int n, int k, int[] earr){
        //bc
        if(i==n){
            return 0;
        }
        int minAns = 400;
        // int ans1 = Integer.MAX_VALUE;
        for(int j = 1; j <= k; j++){
            if(i+j<=n){
                // System.out.println("HI");
            int ans1 = MinEnergy(i+j, n, k, earr) + (int)(Math.abs(earr[i+j]-earr[i]));
            minAns = Math.min(minAns, ans1);
            }
        }
        return minAns;
    }
    public static void main(String[] args) {
        int[] arr={10,20,30,10};
        System.out.println(MinEnergy(0,3,2,arr));
    }
}