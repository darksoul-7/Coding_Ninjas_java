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
public class MaximumSquareMatrixWithAllZeros {

    public static int findMaxSquareWithAllZeros(int[][] input) {

        /* Your class should be named Solution.
	 * Don't write main() function.
	 * Don't read input, it is passed as function argument.
	 * Return output and don't print it.
	 * Taking input and printing output is handled automatically.
         */
        if (input.length == 0) {
            return 0;
        }
        int m = input.length;
        int n = input[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        for (int i = 0; i < dp[0].length; i++) {
            if (input[0][i] == 0) {
                dp[0][i] = 1;
            } else {
                dp[0][i] = 0;
            }
        }

        for (int i = 0; i < dp.length; i++) {
            if (input[i][0] == 0) {
                dp[i][0] = 1;
            } else {
                dp[i][0] = 0;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (input[i][j] == 0) {

                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] > max) {
                    max = dp[i][j];
                }
            }
        }
        return max;
    }
    
    public static void main(String[] args){
        int[][] arr={{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
        System.out.println(findMaxSquareWithAllZeros(arr));
    }

}
