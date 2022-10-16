/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proirity_Queue;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 *
 * @author Lenovo
 */
public class KLargest {

    //Actual Solution
    public static void printKLargest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0;
        while (i < k) {
            pq.add(arr[i]);
            i++;
        }
        while (i < arr.length) {
            int min = pq.element();
            if (min < arr[i]) {
                pq.remove();
                pq.add(arr[i]);
            }
            i++;
        }
        while (!pq.isEmpty()) {
            System.out.println(pq.remove() + " ");
        }
    }

    //my Code
    public static ArrayList<Integer> kLargest(int input[], int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < input.length; i++) {
            pq.add(input[i]);
        }
        for (int i = 0; i < input.length - k; i++) {
            pq.remove();
        }
        ArrayList<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.remove());
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 15, 8, 9, 12, 12, 20, 13};
        printKLargest(arr, 3);
        ArrayList<Integer> res = kLargest(arr, 2);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
