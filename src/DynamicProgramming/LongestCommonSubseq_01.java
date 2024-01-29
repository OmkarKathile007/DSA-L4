package DynamicProgramming;

public class LongestCommonSubseq_01 {
    public static int CommonSubseq(String s1,int n,String s2,int m){
        if (n==0 || m==0){
            return 0;
        }
        if (s1.charAt(n-1)==s2.charAt(m-1)){
            return CommonSubseq(s1,n-1,s2,m-1)+1;
        }
        else{
            int max1=CommonSubseq(s1,n-1,s2,m);
            int max2=CommonSubseq(s1,n,s2,m-1);
            return Math.max(max1,max2);
        }
    }

    public static void main(String[] args) {
        String t1="abcdge";
        String t2="abedg";
        char ch[]=new char[Math.max(t1.length(),t2.length())+1];
        System.out.println(CommonSubseq(t1,t1.length(),t2,t2.length()));
    }
}
