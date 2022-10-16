/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proirity_Queue;

import java.util.PriorityQueue;

/**
 *
 * @author Lenovo
 */
public class Ksort {
    public static void sortksorted(int[] arr, int k){
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int i=0;
        while(i<k){
            pq.add(arr[i]);
            i++;
        }
        while(i<arr.length){
            arr[i-k]=pq.remove();
            pq.add(arr[i]);
            i++;
        }
        int j=arr.length-k;
        while(j<arr.length){
            arr[j]=pq.remove();
            j++;
        }
    }
    public static void main(String[] args) {
        int[] arr={2,4,1,9,6,8};
        int k=3;
        sortksorted(arr, k);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
}
