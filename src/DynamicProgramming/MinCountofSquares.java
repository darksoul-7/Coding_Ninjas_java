/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicProgramming;

/**
 *
 * @author Lenovo
 */
public class MinCountofSquares {
    public static int mincount_rec(int n){
        if(n<=3){
            return n;
        }
        int res=n;
        for(int i=1;i<=n;i++){
            int temp=i*i;
            if(temp>n){
                break;
            }else{
                res=Math.min(res, 1+mincount_rec(n-temp));
            }
        }
        return res;
    }
    
    public static int mincount_mem(int n){
        int[] storage=new int[n+1];
        for(int i=0;i<=n;i++){
            storage[i]=-1;
        }
        return mincount_mem(n, storage);
    }
    public static int mincount_mem(int n,int[] capacity){
        if(n<=3){
            capacity[n]=n;
            return capacity[n];
        }
        if(capacity[n]!=-1){
            return capacity[n];
        }
        int res=n;
        for(int i=1;i<=n;i++){
            int temp=i*i;
            if(temp>n){
                break;
            }else{
                res=Math.min(res, 1+mincount_mem(n-temp, capacity));
                capacity[n]=res;
            }
        }
        return capacity[n];
    }
    
    public static int mincount_dp(int n){
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        dp[3]=3;
        for(int i=4;i<=n;i++){
            dp[i]=i;
            for(int x=1;x<=Math.sqrt(i);x++){
                int temp=x*x;
                if(temp>i){
                    break;
                }else{
                    dp[i]=Math.min(dp[i], 1+dp[i-temp]);
                }
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        System.out.println(mincount_dp(17));
        System.out.println(mincount_mem(17));
        System.out.println(mincount_rec(17));
    }
}
