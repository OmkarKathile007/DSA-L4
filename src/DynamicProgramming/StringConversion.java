package DynamicProgramming;

public class StringConversion {

    public static int lcs(String s1,String s2){
        int n=s1.length();
        int m=s2.length();
        int dp[][]=new int[n+1][m+1];
        for (int i=1;i<n+1;i++){
            for (int j=1;j<m+1;j++){
                if (s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    int a1=dp[i-1][j];
                    int a2=dp[i][j-1];
                    dp[i][j]=Math.max(a1,a2);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String s1="abcdef";
        String s2="aceg";
        int n=s1.length();
        int m=s2.length();

        int lcs=lcs(s1,s2);
        int minOp=n-lcs+m-lcs;
        System.out.println(minOp);
    }
}
