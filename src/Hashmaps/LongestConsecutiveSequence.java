/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hashmaps;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Lenovo
 */
public class LongestConsecutiveSequence {

    public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {
        ArrayList<Integer> output = new ArrayList<>();
        HashMap<Integer, Boolean> map = new HashMap<>();
        HashMap<Integer, Integer> lenMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], true);
        }
        int maxStart = -1, maxLen = 0;
        boolean startCheck = true;

        for (int i : arr) {
            if (map.get(i)) {
                int currStart = i, currLen = 1;

                boolean flag = true;
                map.put(i, false);

                int ahead = i + 1;

                while (flag) {
                    if (map.containsKey(ahead)) {

                        currLen = currLen + 1;
                        map.put(ahead, false);
                        ahead = ahead + 1;

                    } else {
                        flag = false;
                    }
                }
                flag = true;
                int before = i - 1;

                while (flag) {
                    if (map.containsKey(before)) {

                        currLen = currLen + 1;
                        currStart = before;
                        map.put(before, false);
                        before = before - 1;

                    } else {
                        flag = false;
                    }
                }

                System.out.println();
                if (currLen >= maxLen) {
                    maxLen = currLen;
                    maxStart = currStart;
                    lenMap.put(maxStart, maxLen);
                }
            }

        }

        for (int i = 0; i < arr.length; i++) {
            if (lenMap.containsKey(arr[i]) && lenMap.get(arr[i]) >= maxLen) {
                maxStart = arr[i];
                maxLen = lenMap.get(arr[i]);
                break;
            }
        }
        output.add(maxStart);
        output.add(maxStart + maxLen - 1);
        return output;

    }

    public static ArrayList<Integer> longestconssubsequence(int[] arr) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, true);
        }
        for (int i : arr) {
            if (map.containsKey(i - 1)) {
                map.put(i, false);
            }
        }
        int maxlength = 0;
        int start = 0;
        for (int i : arr) {
            if (map.get(i)) {
                int tstart = i;
                int length = 1;
                while (map.containsKey(tstart + length)) {
                    length++;
                }
                if (length > maxlength) {
                    start = tstart;
                    maxlength = length;
                }
            }
        }
        ArrayList<Integer> op = new ArrayList<>();
        op.add(start);
        op.add(start + maxlength - 1);
        return op;
    }
}
