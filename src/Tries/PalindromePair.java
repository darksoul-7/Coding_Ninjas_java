/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tries;

import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class PalindromePair {

    private TrieNode root;

    public PalindromePair() {
        root = new TrieNode('\0');
    }

    private void add(TrieNode root, String word) {
        if (word.length() == 0) {
            root.isTerminating = true;
            return;
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            child = new TrieNode(word.charAt(0));
            root.children[childIndex] = child;
        }
        add(child, word.substring(1));
    }

    public void add(String word) {
        add(root, word);
    }

    private boolean search(TrieNode root, String word) {
        if (word.length() == 0 || root.isTerminating == true) {
            return true;
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            return false;
        }
        return search(child, word.substring(1));
    }

    public boolean search(String word) {
        return search(root, word);
    }

    public boolean palindromePair(ArrayList<String> ip) {
        ArrayList<String> reverseip = new ArrayList<>();
        for (int i = 0; i < ip.size(); i++) {
            add(ip.get(i));
            String str = reverse(ip.get(i));
            reverseip.add(str);
        }
        for (int i = 0; i < reverseip.size(); i++) {
            if (search(reverseip.get(i))) {
                return true;
            }
        }
        return false;
    }

    public String reverse(String str) {
        String res = "";
        while (str.length() != 0) {
            res = str.charAt(0) + res;
            str = str.substring(1);
        }
        return res;
    }
}

class Test1 {

    public static void main(String[] args) {
        ArrayList<String> ip = new ArrayList<>();
        ip.add("abc");
        ip.add("def");
        ip.add("ghi");
        ip.add("cba");
        PalindromePair p = new PalindromePair();
        System.out.println(p.palindromePair(ip));
    }
}
