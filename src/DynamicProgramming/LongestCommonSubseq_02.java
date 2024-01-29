package DynamicProgramming;

public class LongestCommonSubseq_02 {

    public static int CommonSubseq(String s1,int n,String s2,int m,int dp[][]){
        if (n==0 || m==0){
            return 0;
        }

        if (dp[n][m]!=-1){
            return dp[n][m];
        }
        if (s1.charAt(n-1)==s2.charAt(m-1)){
            return dp[n][m]= CommonSubseq(s1,n-1,s2,m-1,dp)+1;
        }
        else{
            int max1=CommonSubseq(s1,n-1,s2,m,dp);
            int max2=CommonSubseq(s1,n,s2,m-1,dp);
            return dp[n][m]= Math.max(max1,max2);
        }
    }

    public static void main(String[] args) {
        String t1="ABCD";
        String t2="ACED";

        int n=t1.length();
        int m=t2.length();
        int dp[][]=new int[n+1][m+1];

        for (int i=0;i<n+1;i++){
            for (int j=0;j<m+1;j++){
                dp[i][j]=-1;
            }
        }

        System.out.println(CommonSubseq(t1,t1.length(),t2,t2.length(),dp));

        for (int i=0;i<n+1;i++){
            for (int j=0;j<m+1;j++){
                System.out.print( dp[i][j]+" ");
            }
            System.out.println();
        }
    }
}
