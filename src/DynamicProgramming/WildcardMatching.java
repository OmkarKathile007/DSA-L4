package DynamicProgramming;

import java.util.Scanner;

public class WildcardMatching {


//    TC -> O(n*m)
    public static boolean WildCard(String s1,String p){
        int n=s1.length();
        int m=p.length();

        boolean dp[][]=new boolean[n+1][m+1];
        dp[0][0]=true;
        for (int i=1;i<n+1;i++){
            dp[i][0]=false;
        }
        for (int j=1;j<m+1;j++){
            if (p.charAt(j-1)=='*'){
                dp[0][j]=dp[0][j-1];
            }
        }
        for (int i=1;i<n+1;i++){
            for (int j=1;j<m+1;j++){
                if (s1.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }
                else if(p.charAt(j-1)=='*'){
                    dp[i][j]=dp[i-1][j]||dp[i][j-1];
                }
                else{
                    dp[i][j]=true;
                }
            }
        }

        return dp[n][m];
    }


    public static void main(String[] args) {
//        String s1="baaabab";
//        String s2="*****ba****ab";
        String s1="abc";
        String s2="**d";
        System.out.println(WildCard(s1,s2));
    }
}
