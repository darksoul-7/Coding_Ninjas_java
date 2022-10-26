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
public class LCS {

    public static int lcs_rec(String s, String t) {
        //Your code goes here
        if (s.length() == 0 || t.length() == 0) {
            return 0;
        }
        if (s.charAt(0) == t.charAt(0)) {
            return 1 + lcs_rec(s.substring(1), t.substring(1));
        } else {
            int res2 = lcs_rec(s, t.substring(1));
            int res3 = lcs_rec(s.substring(1), t);
            return Math.max(res2, res3);
        }
    }

    public static int lcs_mem(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] storage = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                storage[i][j] = -1;
            }
        }
        return lcs_mem(s, t, storage);
    }

    public static int lcs_mem(String s, String t, int[][] storage) {
        int m = s.length();
        int n = t.length();

        if (m == 0 || n == 0) {
            storage[m][n] = 0;
            return storage[m][n];
        }

        if (storage[m][n] != -1) {
            return storage[m][n];
        }
        if (s.charAt(0) == t.charAt(0)) {
            storage[m][n] = 1 + lcs_mem(s.substring(1), t.substring(1), storage);
        } else {
            int res1 = lcs_mem(s.substring(1), t, storage);
            int res2 = lcs_mem(s, t.substring(1), storage);
            storage[m][n] = Math.max(res1, res2);
        }
        return storage[m][n];

    }

    public static int lcs_dp(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(m - i) == t.charAt(n - j)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
    
    public static void main(String[] args) {
        String s="adebc";
        String t="dcadb";
        System.out.println(lcs_rec(s, t));
        System.out.println(lcs_mem(s,t));
        System.out.println(lcs_dp(s,t));
    }
}
