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
public class AutoComplete {

    private TrieNode root;

    public AutoComplete() {
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
            root.childCount++;
        }
        add(child, word.substring(1));
    }

    public void add(String word) {
        add(root, word);
    }

    public TrieNode findword(TrieNode root, String word) {
        if (word.length() == 0) {
            return root;
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            return null;
        }
        return findword(child, word.substring(1));
    }

    public void allwords(TrieNode root, String word, String output) {
        if (root == null) {
            return;
        }
        if (root.childCount == 0) {
            if (output.length() > 0) {
                System.out.println(word + output);
            }
            return;
        }
        if (root.isTerminating) {
            System.out.println(word + output);
        }
        for (int i = 0; i < root.children.length; i++) {
            if (root.children[i] != null) {
                String res = output + root.children[i].data;
                allwords(root.children[i], word, res);
            }
        }
    }

    public void autocomplete(ArrayList<String> ip, String word) {
        for (int i = 0; i < ip.size(); i++) {
            add(ip.get(i));
        }
        if (root == null || root.childCount == 0) {
            return;
        }
        TrieNode res = findword(root, word);
        allwords(res, word, "");
    }
}

class Test2 {

    public static void main(String[] args) {
        ArrayList<String> ip = new ArrayList<>();
        AutoComplete ac = new AutoComplete();
        ip.add("do");
        ip.add("dont");
        ip.add("no");
        ip.add("not");
        ip.add("note");
        ip.add("notes");
        ip.add("den");
        ac.autocomplete(ip, "no");
    }
}
