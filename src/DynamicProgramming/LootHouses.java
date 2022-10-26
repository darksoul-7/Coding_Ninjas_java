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
public class LootHouses {

    public static int maxMoneyLooted_rec(int[] houses) {
        return maxMoneyLooted_rec(houses, houses.length, 0);
    }

    public static int maxMoneyLooted_rec(int[] houses, int length, int i) {
        if (houses.length == 0 || i >= length) {
            return 0;
        }
        int op1 = houses[i] + maxMoneyLooted_rec(houses, length, i + 2);
        int op2 = maxMoneyLooted_rec(houses, length, i + 1);
        return Math.max(op1, op2);
    }

    public static int maxMoneyLooted_dp(int[] houses) {
        if (houses.length == 0) {
            return 0;
        }
        int[] dp = new int[houses.length];
        dp[0] = houses[0];
        dp[1] = Math.max(dp[0], houses[1]);
        for (int i = 2; i < houses.length; i++) {
            dp[i] = Math.max(houses[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[houses.length - 1];
    }

    public static void main(String[] args) {
        int[] arr = {5, 5, 10, 100, 10, 5};
        System.out.println(maxMoneyLooted_rec(arr));
        System.out.println(maxMoneyLooted_dp(arr));
    }
}
