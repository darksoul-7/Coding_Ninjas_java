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
public class ImplaceHeapSort {

    public static void inplaceHeapSort(int arr[]) {
        /* Your class should be named Solution
		* Don't write main().
		* Don't read input, it is passed as function argument.
		* Change in the given input itself.
		* Taking input and printing output is handled automatically.
         */
        for (int i = 0; i < arr.length; i++) {
            insert(arr, i);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[arr.length - 1 - i] = removemin(arr, arr.length - i);
        }
    }

    public static void insert(int arr[], int i) {
        int childIndex = i;
        int parentIndex = (i - 1) / 2;
        while (childIndex > 0) {
            if (arr[childIndex] < arr[parentIndex]) {
                int temp = arr[childIndex];
                arr[childIndex] = arr[parentIndex];
                arr[parentIndex] = temp;
                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
            } else {
                return;
            }

        }
    }

    public static int removemin(int arr[], int heapsize) {
        int temp = arr[0];
        arr[0] = arr[heapsize - 1];
        heapsize--;
        int parentIndex = 0;
        int leftIndex = 1;
        int rightIndex = 2;
        int minIndex = parentIndex;
        while (leftIndex < heapsize) {
            if (arr[leftIndex] < arr[minIndex]) {
                minIndex = leftIndex;
            }
            if (rightIndex < heapsize && arr[rightIndex] < arr[minIndex]) {
                minIndex = rightIndex;
            }
            if (minIndex == parentIndex) {
                break;
            } else {
                int temp1 = arr[parentIndex];
                arr[parentIndex] = arr[minIndex];
                arr[minIndex] = temp1;
                parentIndex = minIndex;
                leftIndex = 2 * parentIndex + 1;
                rightIndex = 2 * parentIndex + 2;
            }

        }
        return temp;
    }
    public static void main(String[] args) {
        int[] arr={34,56,16,2,8,10,9};
        inplaceHeapSort(arr);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
}
