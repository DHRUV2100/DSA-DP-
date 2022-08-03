import java.util.*;
import java.io.*;
public class Solution{
    public static void main(String[] args) {
        int n=6;
        //bc
        int prev1=1;
        int prev2=0;
        int curr=0;
        for (int i = 2; i <=n; i++) {
            curr=prev1+prev2;
            //update
            prev2=prev1;
            prev1=curr;
        }
        System.out.println(curr);
    }
}