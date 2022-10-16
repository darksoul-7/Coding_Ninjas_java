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
public class Buy_The_Ticket {
    public static int buyticket(int[] input, int k){
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<input.length;i++){
            q.add(i);
            pq.add(input[i]);
        }
        int res=0;
        while(q.peek()!=k || pq.element()!=input[q.peek()]){
            if(pq.element()>input[q.peek()]){
                int x=q.poll();
                q.add(x);
            }
            else if(pq.element()==input[q.peek()]){
                q.poll();
                pq.remove();
                res++;
            }
        }
        return res+1;
    }
    public static void main(String[] args) {
//        int[] arr={2, 3, 2, 2, 4};
//        int k=3;
        int[] arr={3,9,4};
        int k=2;
        System.out.println(buyticket(arr, k));
    }
}
