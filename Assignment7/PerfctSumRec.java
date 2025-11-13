import java.util.*;
public class PerfctSumRec {
    public static void main(String[] args) {
        int arr[] = {2, 3, 5, 6, 8, 10};
        int sum = 10;
        System.out.println(perfctSum(arr, sum, 0));
        int dp[][] = new int[arr.length+1][sum+1];
        for (int [] i : dp) {
            Arrays.fill(i, -1);;
        }

        System.out.println(perfctSumCount(arr, dp, sum, 0));
        for (int [] i : dp) {
            System.out.println(Arrays.toString(i));
        }
        int dp2[][] = new int[arr.length+1][sum+1];
        System.out.println(helper(arr, dp2, sum)); 
        for (int [] i : dp2) {
            System.out.println(Arrays.toString(i));
        }       
    }
    static int perfctSum(int arr[], int sum, int i) {
        if (sum == 0) return 1;
        if(i>=arr.length || sum < 0) return 0;
        int include = perfctSum(arr, sum - arr[i], i+1);
        int exclude = perfctSum(arr, sum, i + 1);
        return include + exclude;
    }
    static int perfctSumCount(int arr[],int [][] dp, int sum, int i ) {
        if (sum == 0) return 1;
        if(i>=arr.length || sum < 0) return 0;
        if(dp[i][sum] != -1) return dp[i][sum];
        int include = perfctSumCount(arr, dp,sum - arr[i], i+1);
        int exclude = perfctSumCount(arr,dp, sum, i + 1);
        dp[i][sum] = exclude+include;
        return dp[i][sum];
    }
    static int helper (int [] arr,int [][] dp , int t){
        for(int i =0 ; i<arr.length+1;i++){
            dp[i][0]=1;
        }
        for(int i=1 ; i<arr.length+1;i++){
            for(int j = 0 ; j<t+1;j++){
                dp[i][j] = dp[i-1][j];
                if(arr[i-1]<=j){
                    dp[i][j] =dp[i][j] + dp[i-1][j-arr[i-1]];
                }
            }
        }
        return dp[arr.length][t];
    }
}
