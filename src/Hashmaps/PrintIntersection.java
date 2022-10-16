/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hashmaps;

/**
 *
 * @author Lenovo
 */
import java.util.*;

public class PrintIntersection {

    public static void intersection(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            if (map.containsKey(arr1[i])) {
                map.put(arr1[i], map.get(arr1[i]) + 1);
            } else {
                map.put(arr1[i], 1);
            }
        }
        for (int i = 0; i < arr2.length; i++) {
            if (map.containsKey(arr2[i])) {
                if (map.get(arr2[i]) != 0) {
                    System.out.println(arr2[i]);
                    map.put(arr2[i], map.get(arr2[i]) - 1);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int[] arr1={2 ,6 ,8 ,5 ,4 ,3};
        int[] arr2={2 ,3 ,4 ,7};
        intersection(arr1, arr2);
    }
}
