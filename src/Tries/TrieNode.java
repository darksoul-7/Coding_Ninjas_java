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
public class TrieNode {

    char data;
    boolean isTerminating;
    TrieNode[] children;
    int childCount;

    public TrieNode(char data) {
        this.data = data;
        isTerminating = false;
        children = new TrieNode[26];
        childCount=0;
    }
}
