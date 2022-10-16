/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proirity_Queue;

import java.util.*;

/**
 *
 * @author Lenovo
 */
public class KSmallest {

    public static ArrayList<Integer> kSmallest(int n, int[] input, int k) {
        // Write your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(input[i]);
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(pq.remove());
        }
        return res;

    }
    public static void main(String[] args) {
        int[] arr={2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6 };
        ArrayList<Integer> res=kSmallest(arr.length, arr, 4);
        for(int i:res){
            System.out.println(i);
        }
    }
}
