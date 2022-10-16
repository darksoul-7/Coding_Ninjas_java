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
public class PairsWithDifferenceK {

    public static int pairdifferenceK(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i : arr) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        if (k != 0) {
            for (int i : arr) {
                if (map.containsKey(i - k) && map.get(i) != 0) {
                    count = count + map.get(i) * map.get(i - k);
                }
                if (map.containsKey(i + k) && map.get(i) != 0) {
                    count = count + map.get(i) * map.get(i + k);
                }

            }
        } else {
            for (int i : arr) {
                if (map.containsKey(i) && map.get(i) != 0) {
                    count = 2 * (map.get(i) - 1);
                }
                map.put(i, 0);
            }
        }
        return count;
    }
}
