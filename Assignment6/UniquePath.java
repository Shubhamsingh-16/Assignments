import java.util.*;
public class UniquePath{
    public static void main(String [] args){
        int [][] arr = {{0,0},{0,1}};
        int dp [][] = new int [arr.length][arr[0].length];
        for(int [] x : dp){
            Arrays.fill(x,-1);
        }
        if(arr[arr.length-1] [arr[0].length-1]==1) System.out.println(0);
        else System.out.println(paths(arr , dp , 0 , 0));
    }
    static int paths(int [][]arr , int [] []dp , int x , int y){
        if(x== arr.length-1 && y==arr[0].length-1) return 1;
        if(x>=arr.length|| y>=arr[0].length ||arr[x][y]==1) return 0;
        if(dp[x][y]!= -1)return dp[x][y];
        dp[x][y] = paths(arr, dp , x+1,y) + paths(arr, dp , x , y+1);
        System.out.println("dp["+x+"] [ "+y+"] =" +dp[x][y]);
        return dp[x][y];
    }
}