/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proirity_Queue;

/**
 *
 * @author Lenovo
 */
import java.util.*;

public class RunningMedian {

    public static void findMedian(int[] arr) {
        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();
        left.add(arr[0]);
        System.out.print(left.element() + " ");
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > left.element()) {
                right.add(arr[i]);
            } else {
                left.add(arr[i]);
            }
            if (left.size() - right.size() == 2) {
                right.add(left.remove());
            } else if (right.size() - left.size() == 2) {
                left.add(right.remove());
            }
            if (left.size() > right.size()) {
                System.out.print(left.element() + " ");
            } else if (left.size() == right.size()) {
                System.out.print((left.element() + right.element()) / 2);
                System.out.print(" ");
            } else if (right.size() > left.size()) {
                System.out.print(right.element() + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        int[] arr1 = {6, 2, 1, 3, 7, 5};
        findMedian(arr);
        System.out.println();
        findMedian(arr1);
    }
}
