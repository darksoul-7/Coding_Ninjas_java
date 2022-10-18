/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tries;

/**
 *
 * @author Lenovo
 */
public class TrieUse {

    public static void main(String[] args) {
        Trie t = new Trie();
        t.add("this");
        t.add("news");
        t.add("new");
        System.out.println(t.countWord());
        System.out.println(t.search("news"));
        t.remove("new");
        System.out.println(t.search("new"));
    }

}
