package DynamicProgramming;

public class UnboundedKnapsack {

    static int UnBoundKnapSack(int v[],int wt[],int W){
        int n=v.length;
//        int w= wt.length;
        int dp[][]=new int[n+1][W+1];
        for (int i=1;i<n+1;i++){
            for (int j=1;j<W+1;j++){
                if (wt[i-1]<=j){
                    dp[i][j]=Math.max(v[i-1]+dp[i][j-wt[i-1]],dp[i-1][j]);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        for (int i=0;i<n+1;i++){
            for (int j=0;j<W+1;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        int val[]={15,14,10,45,30};
        int wt[]={2,5,1,3,4};
        System.out.println(UnBoundKnapSack(val,wt,7));

    }
}
