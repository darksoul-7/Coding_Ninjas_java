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

public class ExtractUniqueCharacter {

    public static String unique(String str) {
        String res = "";
        HashMap<Character, Boolean> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                continue;
            }
            map.put(str.charAt(i), true);
            res += str.charAt(i);
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "ababacd";
        System.out.println(unique(str));
    }
}
