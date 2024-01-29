package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class Catalan_02 {

    public static int CatalanTabu(int n,int dp[]){
        if (n==0||n==1){
            return 1;
        }
        if (dp[n]!=-1){
            return dp[n];
        }
        int ans=0;
        for (int i=0;i<n;i++){
            ans+=CatalanTabu(i,dp)*CatalanTabu(n-i-1,dp);
        }
        return dp[n]=ans;
    }

    public static void main(String[] args) {
       int n=30;
       int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(CatalanTabu(n,dp));
    }
}
