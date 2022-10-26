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
public class CoinTower {

    public static String cointower(int n, int x, int y) {
        boolean[] dp = new boolean[n + 1];
        dp[0] = false;
        dp[1] = true;
        for (int i = 2; i <= n; i++) {
            if (i - 1 >= 0 && dp[i - 1] == false) {
                dp[i] = true;
            } else if (i - x >= 0 && dp[i - x] == false) {
                dp[i] = true;
            } else if (i - y >= 0 && dp[i - y] == false) {
                dp[i] = true;
            }
        }
        if (dp[n]) {
            return "Beerus";
        } else {
            return "Whis";
        }
    }

    public static void main(String[] args) {
        System.out.println(cointower(10, 2, 4));
        System.out.println(cointower(4, 2, 3));
        System.out.println(cointower(89, 5, 6));
    }
}
