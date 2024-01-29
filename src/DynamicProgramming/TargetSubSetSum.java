package DynamicProgramming;

public class TargetSubSetSum {
    public static boolean TargetSubset(int nums[],int sum){
        boolean dp[][]=new boolean[nums.length+1][sum+1];

        for (int i=0;i< nums.length;i++){
            dp[i][0]=true;
        }

        for (int i=1;i<nums.length+1;i++){
            for (int j=1;j<sum+1;j++){
                int v=nums[i-1];

                if (v<=j && dp[i-1][j-v]){
                    dp[i][j]=true;
                }
                else if(dp[i-1][j]){
                    dp[i][j]=true;
                }
            }
        }

        return dp[nums.length][sum];
    }
    public static void main(String[] args) {
        int nums[]={4,2,7,1,3};
        int sum=10;
        System.out.println(TargetSubset(nums,sum));

    }
}
