package DynamicProgramming;

public class LongestCommonSubseq_04 {
// Longest Common Contigous Subsequence TC-> O(n*m)
    static int LCSTabu(String s1,String s2){
        int n=s1.length();
        int m=s2.length();
        int dp[][]=new int[n+1][m+1];
        String str="";
        int max=0;
        for (int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if (s1.charAt(i-1)==s2.charAt(j-1)){

                    dp[i][j]=dp[i-1][j-1]+1;
                    max=Math.max(max,dp[i][j]);
                }

                else{
                    dp[i][j]=0;
                }
            }
        }
//        System.out.println(str+" "+max);

        return max;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
