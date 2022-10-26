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
public class SubsetSum {

    static boolean isSubsetPresent_rec(int[] arr, int n, int sum) {

        /* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
         */
        if (sum == 0) {
            return true;
        }
        if (n == 0) {
            return false;
        }

        if (arr[n - 1] > sum) {
            return isSubsetPresent_rec(arr, n - 1, sum);
        } else {
            return isSubsetPresent_rec(arr, n - 1, sum) || isSubsetPresent_rec(arr, n - 1, sum - arr[n - 1]);
        }
    }

    static boolean isSubsetPresent(int[] arr, int n, int sum) {
        boolean[][] dp = new boolean[sum + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = true;
        }
        for (int j = 1; j <= sum; j++) {
            dp[j][0] = false;
        }
        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1];
                if (i >= arr[j - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - arr[j - 1]][j - 1];
                }
            }
        }
        return dp[sum][n];
    }
    
    public static void main(String[] args) {
        int[] arr={4,3,5,2};
        int n=4;
        int sum=13;
        System.out.println(isSubsetPresent_rec(arr, n, sum));
        System.out.println(isSubsetPresent(arr, n, sum));
    }

}
