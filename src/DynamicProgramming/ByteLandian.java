/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicProgramming;

import java.util.HashMap;

/**
 *
 * @author Lenovo
 */
public class ByteLandian {

    public static long bytelandian_rec(long n, HashMap<Long, Long> memo) {
        if (n == 0) {
            return 0;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        long res = Math.max(n, bytelandian_rec(n / 2, memo) + bytelandian_rec(n / 3, memo) + bytelandian_rec(n / 4, memo));
        memo.put(n, res);
        return res;
    }

    //heap space error at large input
    public static long bytelandian_dp(long n, HashMap<Long, Long> memo) {
        long[] dp = new long[(int) n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(i, dp[i / 2] + dp[i / 3] + dp[i / 4]);
        }
        return dp[(int) n];
    }

    public static void main(String[] args) {
        HashMap<Long, Long> memo = new HashMap<>();
        long n = 1000000000;
        System.out.println(bytelandian_rec(n, memo));
        System.out.println(bytelandian_dp(n, memo));
    }
}
