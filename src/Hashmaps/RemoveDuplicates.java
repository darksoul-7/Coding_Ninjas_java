/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hashmaps;
import java.util.*;
/**
 *
 * @author Lenovo
 */
public class RemoveDuplicates {
    public static ArrayList<Integer> removeDuplicates(int[] arr){
        ArrayList<Integer> result=new ArrayList<>();
        HashMap<Integer,Boolean> res=new HashMap<>();
        for(int i:arr){
            if(res.containsKey(i)){
//            if(!res.get(i)){
//                res.put(i, true);
//                
//            }
                continue;
            }
            
                res.put(i,true);
                result.add(i);
        }
        return result;
    }
    
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
        int[] arr={1,2,1,2,3,3,4,5,6,7,7,8,2,7,7,7,2,2};
        ArrayList<Integer> op=removeDuplicates(arr);
        op.forEach((i) -> {
            System.out.print(i+" ");
        });
        int max=maxFrequencyNumber(arr);
        System.out.println(max);
    }
    
}
