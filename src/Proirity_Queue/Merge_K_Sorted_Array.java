/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proirity_Queue;

import java.util.*;

/**
 *
 * @author Lenovo
 */
public class Merge_K_Sorted_Array {

    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> input) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < input.size(); i++) {
            ArrayList<Integer> mainin = input.get(i);
            for (int j = 0; j < mainin.size(); j++) {
                pq.add(mainin.get(j));
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.remove());
        }
        return res;
    }
}
