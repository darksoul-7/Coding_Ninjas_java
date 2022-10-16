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
public class HashmapUse {
    public static void main(String[] args) {
        HashMap<String ,Integer> h=new HashMap<>();
        h.put("abc", 1);
        h.put("def", 2);
        if(h.containsKey("abc")){
            System.out.println("has abc");
        }
        if(h.containsKey("abcd")){
            System.out.println("has abcd");
        }
    }
}
