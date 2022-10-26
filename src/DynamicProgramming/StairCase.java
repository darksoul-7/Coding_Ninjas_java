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
public class StairCase {

    public static long staircase(int n) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        }
        return staircase(n - 1) + staircase(n - 2) + staircase(n - 3);
    }

    public static long staircase_mem(int n) {
        long[] storage = new long[n + 1];
        for (int i = 0; i <= n; i++) {
            storage[i] = -1;
        }
        return staircase_mem(n, storage);
    }

    public static long staircase_mem(int n, long[] storage) {
        if (n == 0) {
            storage[n] = 1;
            return storage[n];
        } else if (n < 0) {
            return 0;
        }

        if (storage[n] != -1) {
            return storage[n];
        }
        storage[n] = staircase_mem(n - 1, storage) + staircase_mem(n - 2, storage) + staircase_mem(n - 3, storage);
        return storage[n];
    }

    public static long staircase_dp(int n) {
        long[] storage = new long[n + 1];
        storage[0] = 1;
        storage[1] = 1;
        storage[2] = 2;
        for (int i = 3; i <= n; i++) {
            storage[i] = storage[i - 1] + storage[i - 2] + storage[i - 3];
        }
        return storage[n];
    }

    public static void main(String[] args) {

        System.out.println(staircase_mem(100));
        System.out.println(staircase_dp(100));
        System.out.println(staircase(100));
    }
}
