/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicProgramming2;

/**
 *
 * @author Lenovo
 */
public class EditDistance {
    //TC O(3^m)
    public static int editdistance_rec(String s, String t){
        int m=s.length();
        int n=t.length();
        if(m==0){
            return n;
        }
        if(n==0){
            return m;
        }
        if(s.charAt(0)==t.charAt(0)){
            return editdistance_rec(s.substring(1), t.substring(1));
        }
        else{
            int res1=editdistance_rec(s.substring(1), t.substring(1));
            int res2=editdistance_rec(s.substring(1), t);
            int res3=editdistance_rec(s, t.substring(1));
            return 1+Math.min(res1, Math.min(res2, res3));
        }
    }
    public static int editdistance_mem(String s, String t){
        int m=s.length();
        int n=t.length();
        int[][] storage=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                storage[i][j]=-1;
            }
        }
        return editdistance_mem(s, t,storage);
    }
    
    public static int editdistance_mem(String s, String t, int[][] storage){
        int m=s.length();
        int n=t.length();
        if(m==0){
            storage[m][n]=n;
            return storage[m][n];
        }
        if(n==0){
            storage[m][n]=m;
            return storage[m][n];
        }
        if(storage[m][n]!=-1){
            return storage[m][n];
        }
        if(s.charAt(0)==t.charAt(0)){
            storage[m][n]=editdistance_mem(s.substring(1), t.substring(1), storage);
        }else{
            int res1=editdistance_mem(s.substring(1), t.substring(1), storage); //Replace
            int res2=editdistance_mem(s, t.substring(1), storage); //Insert
            int res3=editdistance_mem(s.substring(1), t, storage); //Delete
            storage[m][n]=1+Math.min(res1, Math.min(res2, res3));
        }
        return storage[m][n];
    }
    
    //TC O(m*n)
    public static int editdistance_dp(String s, String t){
        int m=s.length();
        int n=t.length();
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0){
                    dp[i][j]=j;
                }
                else if(j==0){
                    dp[i][j]=i;
                }
                else if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=1+Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
                }
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args) {
        String s="whgtdwhgtdg";
        String t="aswcfg";
        System.out.println(editdistance_rec(s, t));
        System.out.println(editdistance_mem(s, t));
        System.out.println(editdistance_dp(s, t));
    }
}
