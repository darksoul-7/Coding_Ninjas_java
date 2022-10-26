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
public class NumberOfBlancedBTS {

    //TC :O(2^n)
    public static long countbalancedBTS_rec(int height) {
        long mod = (long) (Math.pow(10, 9) + 7);
        return countbalancedBTS_rec(height, mod);
    }

    public static long countbalancedBTS_rec(int height, long mod) {
        if (height == 0 || height == 1) {
            return 1;
        }
        long x = countbalancedBTS_rec(height - 1, mod);
        long y = countbalancedBTS_rec(height - 2, mod);
        long a = (x * x) % mod;
        long b = (2 * x * y) % mod;
        return (a + b) % mod;

    }

    //O(n)
    public static int countbalancedBTS_dp(int height) {
        long mod = (long) (Math.pow(10, 9) + 7);
        long[] dp = new long[height + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= height; i++) {
            dp[i] = ((dp[i - 1] * dp[i - 1]) % mod + (2 * dp[i - 2] * dp[i - 1]) % mod) % mod;
        }
        return (int) dp[height];
    }

    //O(n)
    public static long countbalanceBTS_mem(int height) {
        long mod = (long) (Math.pow(10, 9) + 7);
        long[] storage = new long[height + 1];
        for (int i = 0; i <= height; i++) {
            storage[i] = -1;
        }
        return countbalanceBTS_mem(height, storage, mod);
    }

    public static long countbalanceBTS_mem(int height, long[] storage, long mod) {
        if (height == 0 || height == 1) {
            storage[height] = 1;
            return storage[height];
        }
        if (storage[height] != -1) {
            return storage[height];
        }
        long x = countbalanceBTS_mem(height - 1, storage, mod);
        long y = countbalanceBTS_mem(height - 2, storage, mod);
        long a = (x * x) % mod;
        long b = (2 * x * y) % mod;
        storage[height] = (a + b) % mod;
        return storage[height];
    }

    public static void main(String[] args) {
        System.out.println(countbalancedBTS_dp(1000));
        System.out.println(countbalanceBTS_mem(1000));
        System.out.println(countbalancedBTS_rec(100));
    }
}
