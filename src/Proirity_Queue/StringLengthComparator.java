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
public class StringLengthComparator implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        if(o1.length()<o2.length()){
            return -1;
        }
        else if(o1.length()>o2.length()){
            return 1;
        }
        else{
            return 0;
        }
    }
    
}
class Test{
    public static void main(String[] args) {
        StringLengthComparator strlength=new StringLengthComparator();
        PriorityQueue<String> pq=new PriorityQueue<>(strlength);
        String[] arr={"this","at","a","their","queues"};
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
        }
        while(!pq.isEmpty()){
            System.out.print(pq.remove()+" ");
        }
    }
}
