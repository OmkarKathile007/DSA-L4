package DynamicProgramming;

import java.util.HashSet;

public class LongestIncreasingSubseq {
    public static int IncreasingSubsequence(int arr1[],int arr2[],int n,int m){
        int dp[][]=new int[n+1][m+1];
        int max=0;
        for (int i=1;i<n+1;i++){
            for (int j=1;j<m+1;j++){
                if (arr1[i-1]==arr2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                    max=Math.max(dp[i][j],max);
                }
                else{
                    int a1=dp[i-1][j];
                    int a2=dp[i][j-1];
                    dp[i][j]=Math.max(a1,a2);
                }
            }
        }
        return max;
    }

    public static int LongestIncSubseq(int arr[]){
        int n= arr.length;
        HashSet<Integer> hs = new HashSet<>();
        for (int i=0;i<n+1;i++){
            hs.add(arr[i]);
        }
        int arr2[]=new int[hs.size()];
        int k=0;
        for (int i:hs){
            arr[k++]=i;
        }
        int m= arr2.length;
         int x=IncreasingSubsequence(arr,arr2,n,m);
         return x;
    }

    public static void main(String[] args) {
        int arr[]={50,3,10,7,40,80};
        LongestIncSubseq(arr);


    }
}
