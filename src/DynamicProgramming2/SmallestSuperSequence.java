/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

Smallest Super-Sequence
Send Feedback
 Given two strings S and T with lengths M and N. Find and return the length of their shortest 'Super Sequence'.
 The shortest 'Super Sequence' of two strings is defined as the smallest string possible that will have both the given strings as its subsequences.
Note :
If the two strings do not have any common characters, then return the sum of the lengths of the two strings. 
Input Format:
The first only line of input contains a string, that denotes the value of string S. The following line contains a string, that denotes the value of string T.
Output Format:
Length of the smallest super-sequence of given two strings. 
Constraints :
0 <= M <= 10 ^ 3
0 <= N <= 10 ^ 3

Time Limit: 1 sec
Sample Input 1 :
ab
ac
Sample Output 1 :
3
Explanation of Sample Output 1 :
Their smallest super sequence can be "abc" which has length = 3.
Sample Input 2 :
pqqrpt
qerepct
Sample Output 2 :
9
 */
package DynamicProgramming2;

/**
 *
 * @author Lenovo
 */
public class SmallestSuperSequence {
    
    public static int smallestSuperSequence_rec(String str1, String str2) {
        
        int m = str1.length();
        int n = str2.length();
        
        if (m == 0) {
            return n;
        }
        if (n == 0) {
            return m;
        }
        if (str1.charAt(0) == str2.charAt(0)) {
            return 1 + smallestSuperSequence_rec(str1.substring(1), str2.substring(1));
        } else {
            int res1 = smallestSuperSequence_rec(str1.substring(1), str2);
            int res2 = smallestSuperSequence_rec(str1, str2.substring(1));
            return 1 + Math.min(res1, res2);
        }
    }
    
    public static int smallestSuperSequence_mem(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] storage = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                storage[i][j] = -1;
            }
        }
        return smallestSuperSequence_mem(str1, str2, storage);
    }
    
    public static int smallestSuperSequence_mem(String str1, String str2, int[][] storage) {
        int m = str1.length();
        int n = str2.length();
        
        if (m == 0) {
            storage[m][n] = n;
            return storage[m][n];
        }
        if (n == 0) {
            storage[m][n] = m;
            return storage[m][n];
        }
        if (storage[m][n] != -1) {
            return storage[m][n];
        }
        if (str1.charAt(0) == str2.charAt(0)) {
            storage[m][n] = 1 + smallestSuperSequence_mem(str1.substring(1), str2.substring(1), storage);
        } else {
            int res1 = smallestSuperSequence_mem(str1.substring(1), str2, storage);
            int res2 = smallestSuperSequence_mem(str1, str2.substring(1), storage);
            storage[m][n] = 1 + Math.min(res1, res2);
        }
        return storage[m][n];
    }
    
    public static int smallestSuperSequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String str1 = "pqqrpt";
        String str2 = "qerepct";
        System.out.println(smallestSuperSequence_rec(str1, str2));
        System.out.println(smallestSuperSequence_mem(str1, str2));
        System.out.println(smallestSuperSequence(str1, str2));
    }
}
