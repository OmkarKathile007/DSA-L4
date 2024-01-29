package DynamicProgramming;

public class CoinsExchange {
    public static int CoinsExchange(int coins[],int s){
        int n= coins.length;
        int dp[][]=new int[n+1][s+1];

        for (int i=0;i< n+1;i++){
            dp[i][0]=1;
        }

        for (int i=1;i< n+1;i++){
            for (int j=1;j< s+1;j++){
                if (coins[i-1]<=j){
                    dp[i][j]=dp[i][j-coins[i-1]]+dp[i-1][j];
                }
                else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        for (int i=0;i< coins.length+1;i++){
            for (int j=0;j< s+1;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }


        return dp[n][s];
    }

    public static void main(String[] args) {
        int coins[]={2,5,3,6};
        int sum=10;
        System.out.println(CoinsExchange(coins,sum));
    }
}
