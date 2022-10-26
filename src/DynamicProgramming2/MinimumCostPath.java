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
public class MinimumCostPath {

    public static int minCostPath_rec(int[][] input) {
        return minCostPath_rec(input, 0, 0);
    }

    public static int minCostPath_rec(int[][] input, int i, int j) {
        int m = input.length;
        int n = input[0].length;
        if (i >= m || j >= n) {
            return Integer.MAX_VALUE;
        }
        if (i == m - 1 && j == n - 1) {
            return input[i][j];
        }
        int res1 = minCostPath_rec(input, i + 1, j);
        int res2 = minCostPath_rec(input, i + 1, j + 1);
        int res3 = minCostPath_rec(input, i, j + 1);
        int res = input[i][j] + Math.min(res1, Math.min(res2, res3));
        return res;
    }

    public static int minCostPath_mem(int[][] input) {
        int m = input.length;
        int n = input[0].length;
        int[][] storage = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                storage[i][j] = -1;
            }
        }
        return minCostPath_mem(input, 0, 0, storage);
    }

    public static int minCostPath_mem(int[][] input, int i, int j, int[][] storage) {
        int m = input.length;
        int n = input[0].length;
        if (i >= m || j >= n) {
            return Integer.MAX_VALUE;
        }
        if (i == m - 1 && j == n - 1) {
            storage[i][j] = input[i][j];
            return storage[i][j];
        }
        if (storage[i][j] != -1) {
            return storage[i][j];
        }
        int res1 = minCostPath_mem(input, i + 1, j, storage);
        int res2 = minCostPath_mem(input, i + 1, j + 1, storage);
        int res3 = minCostPath_mem(input, i, j + 1, storage);
        int res = input[i][j] + Math.min(res1, Math.min(res2, res3));
        storage[i][j] = res;
        return storage[i][j];
    }

    public static int minCostPath_dp(int[][] dp) {
        int row = dp.length;
        int col = dp[0].length;

        for (int i = 1; i < row; i++) {
            dp[i][0] += dp[i - 1][0];
        }
        for (int j = 1; j < col; j++) {
            dp[0][j] += dp[0][j - 1];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] += Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1]));
            }
        }
        return dp[row - 1][col - 1];
    }
    //Coding Ninja DP solution
    public  static int minCostPathDP(int arr[][]){
		int m = arr.length;
		int n = arr[0].length;
		int storage[][] = new int[m][n];
		
		storage[m - 1][n - 1] = arr[m - 1][n - 1];
		// Last Row
		for(int j = n - 2; j >= 0; j--){
			storage[m - 1][j] = storage[m - 1][j + 1] + arr[m - 1][j];
		}
		// Last Column
		for(int i = m - 2; i >= 0; i--){
			storage[i][n - 1] = storage[i + 1][n - 1] + arr[i][n - 1];
		}
		
		for(int i = m - 2; i >= 0; i--){
			for(int j = n - 2; j >= 0; j--){
				storage[i][j] = arr[i][j] +  Math.min(storage[i][j + 1], 
						Math.min(storage[i + 1][j + 1], storage[i + 1][j]));
			}
		}
		return storage[0][0];
	}
    public static void main(String[] args) {
        int[][] arr = {{9, 6, 0, 12, 90, 1}, {2, 7, 8, 5, 78, 6}, {1, 6, 0, 5, 10, -4}, {9, 6, 2, -10, 7, 4}, {10, -2, 0, 5, 5, 7}};
        System.out.println(minCostPath_rec(arr));
        System.out.println(minCostPath_mem(arr));
        System.out.println(minCostPath_dp(arr));
    }
}
