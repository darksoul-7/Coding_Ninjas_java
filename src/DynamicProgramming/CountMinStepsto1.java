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
public class CountMinStepsto1 {

    public static int countMinStepsToOne_rec(int n) {
        if (n == 1) {
            return 0;
        }
        int sub = countMinStepsToOne(n - 1);
        int res = sub;
        if (n % 3 == 0) {
            int res3 = countMinStepsToOne(n / 3);
            if (res3 < res) {
                res = res3;
            }
        }
        if (n % 2 == 0) {
            int res2 = countMinStepsToOne(n / 2);
            if (res2 < res) {
                res = res2;
            }
        }
        return res + 1;
    }

    public static int countMinStepsToOne(int n) {
        int[] storage = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            storage[i] = -1;
        }
        return countMinStepsToOne(n, storage);
    }

    public static int countMinStepsToOne(int n, int[] storage) {
        //Your code goes here
        if (n == 1) {
//	storage[1]=0;
//	return storage[1];
            return 0;
        }
        if (storage[n] != -1) {
            return storage[n];
        }
        int resn = countMinStepsToOne(n - 1, storage);
        int res = resn;
        if (n % 3 == 0) {
            int res3 = countMinStepsToOne(n / 3, storage);
            if (res > res3) {
                res = res3;
            }
        }
        if (n % 2 == 0) {
            int res2 = countMinStepsToOne(n / 2, storage);
            if (res > res2) {
                res = res2;
            }
        }
        storage[n] = res + 1;
        return storage[n];
    }

    //O(n) TC
    public static int getMinSteps_dp(int n) {
        int[] storage = new int[n + 1];
        storage[1] = 0;
        for (int i = 2; i <= n; i++) {
            int op = storage[i - 1];
            if (i % 2 == 0) {
                op = Math.min(op, storage[i / 2]);
            }
            if (i % 3 == 0) {
                op = Math.min(op, storage[i / 3]);
            }
            storage[i] = op + 1;
        }
        return storage[n];
    }

    public static void main(String[] args) {
        System.out.println(getMinSteps_dp(100000));
        System.out.println(countMinStepsToOne(100000));
    }

}
