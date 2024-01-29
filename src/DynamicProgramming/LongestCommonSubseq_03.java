package DynamicProgramming;

import java.util.ArrayList;
import java.util.Locale;

public class LongestCommonSubseq_03 {

    static int LCSTabu(String s1,String s2){
        int n=s1.length();
        int m=s2.length();
        int dp[][]=new int[n+1][m+1];
        String str="";
        int max=0;
        for (int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if (s1.charAt(i-1)==s2.charAt(j-1)){
                    str+=s1.charAt(i-1);
                    dp[i][j]=dp[i-1][j-1]+1;
                }

                else{
                    int m1=dp[i-1][j];
                    int m2=dp[i][j-1];
                    dp[i][j]=Math.max(m1,m2);
                }
            }
        }
//        System.out.println(str+" "+max);

        return dp[n][m];
    }

    public static void main(String[] args) {
        String t1="ABCDE";
        String t2="ABGCE";
        System.out.println(LCSTabu(t1,t2));
    }
}
