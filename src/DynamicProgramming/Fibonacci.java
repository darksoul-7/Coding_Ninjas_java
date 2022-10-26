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
public class Fibonacci {

    //Time Complexity: O(2^n)
    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static int fib_dp(int n) {
        int[] storage = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            storage[i] = -1;
        }
        return fib_dp(n, storage);
    }

    public static int fib_dp(int n, int[] storage) {
        if (n == 0 || n == 1) {
            storage[n] = n;
            return storage[n];
        }
        if (storage[n] != -1) {
            return storage[n];
        }
        storage[n] = fib_dp(n - 1, storage) + fib_dp(n - 2, storage);
        return storage[n];
    }
    public static int fibdp(int n) {
        int[] storage=new int[n+1];
        storage[0]=0;
        storage[1]=1;
        for(int i=2;i<=n;i++){
            storage[i]=storage[i-1]+storage[i-2];
        }
        return storage[n];
    }
    public static void main(String[] args) {
        System.out.println(fib_dp(1000));
        System.out.println(fibdp(1000));
        System.out.println(fib(1000));
    }
}
