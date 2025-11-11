import java.util.*;
public class MinClimbCost {
    public static void main(String[] args) {
        int cost[] = {10, 15, 20};
        int [] dp = new int[cost.length];
        Arrays.fill(dp , -1);
        int [] dp1 = new int[cost.length];
        Arrays.fill(dp1 , -1);
        int zero = mincost(cost, 0 , dp);
        int one = mincost(cost , 1, dp1);
        System.out.println(Math.min(zero, one));
    }
    static int mincost(int cost[], int i , int[]dp){
        if(i==cost.length-1) return cost[cost.length-1];
        if(i>=cost.length) return 0;
        if(dp[i]!= -1) return dp[i];
        int a = cost[i]+ mincost(cost , i+1, dp);
        int b = cost[i]+ mincost(cost , i+2, dp);
        dp[i]=Math.min(a,b);
        return dp[i];
    }
}

