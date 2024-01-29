package DynamicProgramming;

import java.util.Arrays;

public class MCM_01 {
    public static int MCM(int arr[],int i,int j){
        if (i==j){
            return 0;
        }
        int ans=Integer.MAX_VALUE;
        for (int k=i;k<=j-1;k++){
            int c1=MCM(arr,i,k);
            int c2=MCM(arr,k+1,j);
            int c3=arr[i-1]*arr[k]*arr[j];
            int finalcost=c1+c2+c3;
            ans=Math.min(ans,finalcost);
        }

        return ans;
    }

    public static int MCMMemo(int arr[],int i,int j,int dp[][]){
        if (i==j){
            return 0;
        }
        if (dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=Integer.MAX_VALUE;
        for (int k=i;k<=j-1;k++){
            int c1=MCMMemo(arr,i,k,dp);
            int c2=MCMMemo(arr,k+1,j,dp);
            int c3=arr[i-1]*arr[k]*arr[j];
            ans=Math.min(ans,c1+c2+c3);
            dp[i][j]=ans;
        }



        return dp[i][j];
    }


    public static void main(String[] args) {
      int arr[]={1,2,3,4,3};
      int n= arr.length;

//        System.out.println(MCM(arr,1,n-1));
        int dp[][]=new int[n+1][n+1];

        for (int i=1;i< dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        System.out.println(MCMMemo(arr,1, arr.length-1, dp));
        for (int i=0;i< dp.length;i++){
            for (int j=0;j<dp.length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
}
