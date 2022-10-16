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
public class HashMapimpuse {

    public static void main(String[] args) {
        HashMapimp<String, Integer> map = new HashMapimp<>();
        for (int i = 0; i < 20; i++) {
            map.insert("abc" + i, i + 1);
            System.out.println("i = " + i + " lf = " + map.loadfactor());
        }
        map.removeKey("abc3");
        for (int i = 0; i < 20; i++) {
            System.out.println("abc" + i + " : " + map.getvalue("abc" + i));
        }
       
    }
}
