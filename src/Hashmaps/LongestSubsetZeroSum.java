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
public class LongestSubsetZeroSum {

    public static int lengthoflongestSubsetZeroSum(int[] arr) {
        int sum = 0, maxlength = 0, i = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (i < arr.length - 1) {
            i++;
            sum += arr[i];
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            } else {
                int len = i - map.get(sum);
                if (len > maxlength) {
                    maxlength = len;
                }
            }
        }
        return maxlength;
    }
}
