package DynamicProgramming;

public class Catalan_01 {
    public static int Catalan(int n){
        if (n==1||n==0){
            return 1;
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=Catalan(i)*Catalan(n-i-1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int n=100;
        System.out.println(Catalan(n));
    }
}
