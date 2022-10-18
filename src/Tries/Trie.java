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
public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode('\0');
    }

    private void add(TrieNode root, String str) {
        if (str.length() == 0) {
            root.isTerminating = true;
            return;
        }
        int childIndex = str.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            child = new TrieNode(str.charAt(0));
            root.children[childIndex] = child;
            root.childCount++;
        }
        add(child, str.substring(1));
    }

    public void add(String str) {
        add(root, str);
    }

    private boolean search(TrieNode root, String str) {
        if (str.length() == 0) {
            return root.isTerminating == true;
        }
        int childIndex = str.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            return false;
        }
        return search(child, str.substring(1));
    }

    public boolean search(String str) {
        return search(root, str);
    }

    private void remove(TrieNode root, String str) {
        if (str.length() == 0) {
            root.isTerminating = false;
            return;
        }
        int ChildIndex = str.charAt(0) - 'a';
        TrieNode child = root.children[ChildIndex];
        if (child == null) {
            return;
        }
        remove(child, str.substring(1));

        //We can only remove childNode only if its non terminating and its number of child are 0
        if (!child.isTerminating && child.childCount == 0) {
            root.children[ChildIndex] = null;
            root.childCount--;
        }

//        if(!child.isTerminating){
//            int numChild=0;
//            for(int i=0;i<26;i++){
//                if(child.children[i]!=null){
//                    numChild++;
//                }
//            }
//            if(numChild==0){
//                root.children[ChildIndex]=null;
//                child=null;
//                
//            }
//        }
    }

    public void remove(String str) {
        remove(root, str);
    }

    private int countWord(TrieNode root) {
        int res = 0;
        if (root.isTerminating) {
            res++;
        }
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                res += countWord(root.children[i]);
            }
        }
        return res;
    }

    public int countWord() {
        return countWord(root);
    }
}
