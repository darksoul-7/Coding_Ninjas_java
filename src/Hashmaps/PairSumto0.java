/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hashmaps;

import java.util.HashMap;

/**
 *
 * @author Lenovo
 */
public class PairSumto0 {

    public static int pairsumZero(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(-arr[i])) {
                count += map.get(-arr[i]);
            }
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, -2, -1, 2, 3};
        System.out.println(pairsumZero(arr));
    }
}
