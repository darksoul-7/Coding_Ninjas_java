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
public class KnapSack {

    public static int knapsack_rec(int[] weight, int[] value, int n, int maxWeight) {
        if (n == 0 || maxWeight == 0) {
            return 0;
        }
        if (weight[n - 1] > maxWeight) {
            return knapsack_rec(weight, value, n - 1, maxWeight);
        } else {
            return Math.max(value[n - 1] + knapsack_rec(weight, value, n - 1, maxWeight - weight[n - 1]), knapsack_rec(weight, value, n - 1, maxWeight));
        }
    }

    public static int knapsack_mem(int[] weight, int[] value, int n, int maxWeight) {
        int[][] storage = new int[n + 1][maxWeight + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= maxWeight; j++) {
                storage[i][j] = -1;
            }
        }
        return knapsack_mem(weight, value, n, maxWeight, storage);
    }

    public static int knapsack_mem(int[] weight, int[] value, int n, int maxWeight, int[][] storage) {
        if (n == 0 || maxWeight == 0) {
            return 0;
        }
        if (storage[n][maxWeight] != -1) {
            return storage[n][maxWeight];
        }
        if (weight[n - 1] > maxWeight) {
            storage[n][maxWeight] = knapsack_mem(weight, value, n - 1, maxWeight, storage);
        } else {
            storage[n][maxWeight] = Math.max(value[n - 1] + knapsack_mem(weight, value, n - 1, maxWeight - weight[n - 1], storage), knapsack_mem(weight, value, n - 1, maxWeight, storage));
        }
        return storage[n][maxWeight];
    }

    public static int knapsack_dp(int[] weight, int[] value, int n, int maxWeight) {
        int[][] dp = new int[n + 1][maxWeight + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= maxWeight; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (weight[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(value[i - 1] + dp[i - 1][j - weight[i - 1]], dp[i - 1][j]);
                }
            }
        }
        return dp[n][maxWeight];
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4, 5};
        int[] arr2 = {5, 4, 8, 6};
        int[] arr3 = {4, 1, 4, 5};
        int[] arr4 = {4, 5, 10, 1};
        System.out.println(knapsack_rec(arr3, arr4, 4, 5));
        System.out.println(knapsack_mem(arr3, arr4, 4, 5));
        System.out.println(knapsack_dp(arr3, arr4, 4, 5));
    }

}
