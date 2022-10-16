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
public class CheckMaxHeap {

    public static boolean checkMaxHeap(int arr[]) {
        int childIndex = arr.length - 1;
        int parentIndex = (childIndex - 1) / 2;
        while (childIndex > 0) {
            if (arr[childIndex] > arr[parentIndex]) {
                return false;
            }
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }
        return true;
    }
}
