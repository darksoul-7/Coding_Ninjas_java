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
public class PatternMatching {
    private TrieNode root;
    public PatternMatching(){
        root=new TrieNode('\0');
    }
    private void add(TrieNode root,String word){
        if(word.length()==0){
            root.isTerminating=true;
            return;
        }
        int childIndex=word.charAt(0)-'a';
        TrieNode child=root.children[childIndex];
        if(child==null){
            child=new TrieNode(word.charAt(0));
            root.children[childIndex]=child;
        }
        add(child,word.substring(1));
    }
    public void add(String word){
        add(root,word);
    }
    private boolean search(TrieNode root, String word){
        if(word.length()==0){
            return true;
        }
        int childIndex=word.charAt(0)-'a';
        TrieNode child=root.children[childIndex];
        if(child==null){
            return false;
        }
        return search(child,word.substring(1));
    }
    public boolean search(String word){
        return search(root,word);
    }
    public boolean patternmatch(ArrayList<String> ip,String pattern){
        for(int i=0;i<ip.size();i++){
            String s=ip.get(i);
            for(int j=0;j<s.length();j++){
                add(s.substring(j));
            }
        }
        return search(pattern);
    }
    
}
class Test{
    public static void main(String[] args) {
        ArrayList<String> ip=new ArrayList<>();
        ip.add("abc");
        ip.add("def");
        ip.add("ghi");
        ip.add("cpa");
        String str="a";
        PatternMatching p=new PatternMatching();
        System.out.println(p.patternmatch(ip,str));
    }
}