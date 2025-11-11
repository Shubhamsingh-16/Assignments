import java.util.*;
public class Tribonacci {
    public static void main(String[] args){
        int n = 25;
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(tri(n , dp));
    }
    static int tri(int n , int [] dp){
        if(n==0||n==1)return n;
        if(n==2)return 1;
        if(dp[n]!=-1) return dp[n];
        dp[n]=(tri(n-1,dp)+tri(n-2,dp)+tri(n-3,dp));
        return dp[n];
    }
}
