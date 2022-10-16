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
public class Priority_Queue {

    ArrayList<Integer> heap;

    public Priority_Queue() {
        heap = new ArrayList<>();
    }
    
    int size(){
        return heap.size();
    }
    boolean isEmpty() {
        return heap.isEmpty();
    }

    int getmin() throws PriorityQueueException {
        if (isEmpty()) {
            //throws Exception
            throw new PriorityQueueException();
        }
        return heap.get(0);
    }

    void insert(int e) {
        heap.add(e);
        int childIndex = heap.size() - 1;
        int ParentIndex = (childIndex - 1) / 2;
        while (childIndex > 0) {
            if (heap.get(childIndex) < heap.get(ParentIndex)) {
                int temp = heap.get(childIndex);
                heap.set(childIndex, heap.get(ParentIndex));
                heap.set(ParentIndex, temp);
                childIndex = ParentIndex;
                ParentIndex = (childIndex - 1) / 2;
            } else {
                return;
            }
        }
    }

    int removemin() throws PriorityQueueException {
        if (isEmpty()) {
            throw new PriorityQueueException();
        }
        int temp = heap.get(0);
        int parentIndex = 0;
        int leftIndex = 1;
        int RightIndex = 2;
        int minIndex = parentIndex;
        heap.set(parentIndex, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        while (leftIndex < heap.size()) {
            if (heap.get(leftIndex) < heap.get(minIndex)) {
                minIndex = leftIndex;
            }
            if (RightIndex < heap.size() && heap.get(RightIndex) < heap.get(minIndex)) {
                minIndex = RightIndex;
            }
            if (minIndex == parentIndex) {
                break;
            }
            int temp1 = heap.get(parentIndex);
            heap.set(parentIndex, heap.get(minIndex));
            heap.set(minIndex, temp1);
            parentIndex = minIndex;
            leftIndex = 2 * parentIndex + 1;
            RightIndex = 2 * parentIndex + 2;

        }
        return temp;
    }
}
