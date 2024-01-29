package DynamicProgramming;

public class RodCutting {

    public static int MaxProfitRod(int length[],int price[],int roadlength){
        int dp[][]=new int[length.length+1][roadlength+1];
        for (int i=1;i<length.length+1;i++){
            for (int j=1;j< roadlength+1;j++){
                if (length[i-1]<=j){
                    dp[i][j]=Math.max(price[i-1]+dp[i-1][j-length[i-1]],dp[i-1][j]);
                }
                else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        for (int i=0;i<length.length+1;i++){
            for (int j=0;j<roadlength+1;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

        return dp[length.length][roadlength];
    }

    public static void main(String[] args) {
        int length[]={1,2,3,4,5,6,7,8};
        int price[]={1,5,8,9,10,17,17,20};
        int rodlength=8;
        System.out.println(MaxProfitRod(length,price,rodlength));
    }
}
