package DynamicProgramming;

public class FractionalKnapsack_03 {
    public static int FractionalTabu(int v[],int wt[],int W){
        int dp[][]=new int[v.length+1][W+1];
        for (int i=0;i< dp.length;i++){
            dp[i][0]=0;
        }
        for (int j=0;j<dp[0].length;j++){
            dp[0][j]=0;
        }

        for (int i=1;i<v.length+1;i++){
            for (int j=1;j<W+1;j++){
                int v1=v[i-1];
                int w=wt[i-1];
                if(w<=j){
                   int inprofit=v1+dp[i-1][j-w];
                   int exProfit=dp[i-1][j];
                   dp[i][j]=Math.max(inprofit,exProfit);
                }
                else{
                    int exProfit=dp[i-1][j];
                    dp[i][j]=exProfit;
                }
            }
        }
        return dp[v.length][W];
    }

    public static void main(String[] args) {
        int val[]={15,14,10,45,30};
        int wt[]={2,5,1,3,4};
        System.out.println(FractionalTabu(val,wt,7));


    }
}
