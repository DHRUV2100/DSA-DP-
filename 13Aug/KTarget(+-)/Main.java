
// package 13Aug.KTarget(+-);
import java.util.*;

public class Main {
    public static int targetSumPlusMinus(int i, int targ, int[] arr) {
        // bc
        if (i == 0) {
            // taking first element as +ve
            if (targ - arr[i] == 0)
                return 1;
            // taking first element as -ve
            else if (targ + arr[i] == 0)
                return 1;
            else
                return 0;
        }
        // faith
        // plus
        // int ansPlus=0;
        int ansPlus = targetSumPlusMinus(i - 1, targ - arr[i], arr);
        int ansMinus = targetSumPlusMinus(i - 1, targ + arr[i], arr);
        // exp
        int ans = ansMinus + ansPlus;
        return ans;
    }

    public static void main(String[] args) {

    }
}
