/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proirity_Queue;

import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class MaxHeap {
    // Complete this class

    private final ArrayList<Integer> heap;

    public MaxHeap() {
        heap = new ArrayList<>();
    }

    boolean isEmpty() {
        // Implement the isEmpty() function here
        return heap.isEmpty();
    }

    int getSize() {
        // Implement the getSize() function here
        return heap.size();
    }

    int getMax() {
        // Implement the getMax() function here
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return heap.get(0);
    }

    void insert(int element) {
        // Implement the insert() function here
        heap.add(element);
        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1) / 2;
        while (childIndex > 0) {
            if (heap.get(childIndex) > heap.get(parentIndex)) {
                int temp = heap.get(parentIndex);
                heap.set(parentIndex, heap.get(childIndex));
                heap.set(childIndex, temp);
                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
            } else {
                return;
            }
        }
    }

    int removeMax() {
        // Implement the removeMax() function here
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        int temp = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        int parentIndex = 0;
        int leftIndex = 1;
        int rightIndex = 2;
        int minIndex = parentIndex;
        while (leftIndex < heap.size()) {
            if (heap.get(leftIndex) > heap.get(minIndex)) {
                minIndex = leftIndex;
            }
            if (rightIndex < heap.size() && heap.get(rightIndex) > heap.get(minIndex)) {
                minIndex = rightIndex;
            }
            if (minIndex == parentIndex) {
                break;
            }
            int temp1 = heap.get(parentIndex);
            heap.set(parentIndex, heap.get(minIndex));
            heap.set(minIndex, temp1);
            parentIndex = minIndex;
            leftIndex = 2 * parentIndex + 1;
            rightIndex = 2 * parentIndex + 2;
        }
        return temp;
    }
}
