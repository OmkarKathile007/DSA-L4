import java.util.Arrays;

public class ClimbingStairs {
    static int ClimbingStairs(int n,int dp[]){
        if (n==0){
            return 1;
        }
        if (n<0){
            return 0;
        }
        if (dp[n]!=-1){
            return dp[n];
        }
        dp[n]=ClimbingStairs(n-1,dp)+ClimbingStairs(n-2,dp);
        return dp[n];
    }

    static int ClimbingStairTabu(int n){
        int dp[]=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for (int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n=5;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(ClimbingStairs(n,dp));
        System.out.println(ClimbingStairTabu(5));
    }
}
