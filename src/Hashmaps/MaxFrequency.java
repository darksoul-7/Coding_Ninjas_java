/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hashmaps;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Lenovo
 */
public class MaxFrequency {
    public static int maxFrequencyNumber(int[] arr){ 
	Map<Integer,Integer> map=new HashMap<>();
        
        for(int i:arr){
            if(map.containsKey(i)){
                map.put(i, map.get(i)+1);
            }else{
                map.put(i, 1);
            }
        }
        int max=0, res=arr[0];
        for(int i:arr){
            if(max<map.get(i)){
                max=map.get(i);
                res=i;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4,2,5,6,7};
        System.out.println(maxFrequencyNumber(arr));
    }
}
