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
class MinPQComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        if(o1<o2){
            return -1;
        }
        if(o1>o2){
            return 1;
        }
         return 0;
    }
    
}
class MaxPQComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        if(o1<o2){
            return 1;
        }
        if(o1>o2){
            return -1;
        }
         return 0;
    }
    
}
public class PriorityQueueUse {
    public static void main(String[] args) throws PriorityQueueException {
        Priority_Queue q=new Priority_Queue();
        int[] arr={5,1,9,2,0};
        for(int i=0;i<arr.length;i++){
            q.insert(arr[i]);
        }
        while(!q.isEmpty()){
            System.out.print(q.removemin()+" ");  //heap sort
        }
        System.out.println("");
        //MinPQComparator mincomparator=new MinPQComparator();
        //MaxPQComparator maxcomparator=new MaxPQComparator();
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder()); //Here Collections.reverseOrder() as max comparator.
        int arr1[]={9,1,0,4,7,3};
        for(int i=0;i<arr1.length;i++){
            pq.add(arr1[i]);
        }
        while(!pq.isEmpty()){
            System.out.print(pq.remove()+" ");
        }
    }
}
