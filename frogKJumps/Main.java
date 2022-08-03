import java.util.*;
import java.io.*;
public class Main {
    public static void main(String args[]) {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        String str=new String();
        str=scn.next();
        for(int i=1;i<str.length()-1;i++){
            int cnt=0;
            while(str.charAt(i)=='*'){
                cnt++;
                i++;
            }
            if(cnt>=1){
                System.out.print("J");
            }
            else{
                System.out.print("W");
            }
        }
    }
}