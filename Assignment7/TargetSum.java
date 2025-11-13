import java.util.*;
public class TargetSum {
    public static void main(String[] args) {
        int [] nums = {1,1,1,1,1};
        int target = 3;
        System.out.println(findTargetSumWays(nums, target, 0));
        int [][]dp = new int[nums.length+1][target+1];
        for(int [] x : dp){
            Arrays.fill(x,-1);
        }  
        System.out.println(memo(nums,dp, target, 0));
        int [][]dp2 = new int[nums.length+1][target+1];
        for(int [] x : dp2){
            Arrays.fill(x,-1);
        }  
        // System.out.println(tabu(nums,dp2, target, 0));
    }
    static int findTargetSumWays(int[] nums, int target, int i) {
        if(target==0 && i>=nums.length){
            return 1;
        }
        if(target!=0 && i>=nums.length){
            return 0;
        }
        int a = findTargetSumWays(nums, target - nums[i], i + 1);
        int b = findTargetSumWays(nums, target + nums[i], i + 1);
        return a + b;
    }
    static int memo(int[] nums,int [][] dp, int target, int i) {
        if(target==0 && i>=nums.length){
            return 1;
        }
        if(target!=0 && i>=nums.length){
            return 0;
        }
        if(dp[i][target]!=-1) return dp[i][target];
        int a = findTargetSumWays(nums, target - nums[i], i + 1);
        int b = findTargetSumWays(nums, target + nums[i], i + 1);
        dp[i][target] = a + b;
        return dp[i][target];
    }
    static int tabu(int[] nums,int [][] dp, int target) {
        dp[0][0]=1;
        for(int i =0 ; i<nums.length+1;i++){
            for(int j = 0 ; j<target+1;j++){
                if(i==0 && j!=0){ 
                    dp[i][j]=0;
                    continue;
                }
                dp[i][j] = dp[i-1][j]+dp[i][j];

            }
        }
        return dp[nums.length][target];
    }

}
