/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class CountLeafNodes {
    public static int countLeaf(TreeNode<Integer> root){
        int c=0;
        if(root.children.isEmpty()){
            c++;
        }
        for(int i=0;i<root.children.size();i++){
            c+=countLeaf(root.children.get(i));
        }
        return c;
    }
    public static TreeNode<Integer> input() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter root data");
        int data = s.nextInt();
        TreeNode<Integer> root = new TreeNode<>(data);
        Queue<TreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode<Integer> frontdata = q.poll();
            System.out.println("Enter No. of children for Node :" + frontdata.data);
            int noofc = s.nextInt();
            for (int i = 0; i < noofc; i++) {
                System.out.println("Enter " + (i + 1) + "th child of " + frontdata.data);
                int cdata = s.nextInt();
                TreeNode<Integer> childnode = new TreeNode<>(cdata);
                frontdata.children.add(childnode);
                q.add(childnode);
            }
        }
        return root;
    }
    public static void main(String[] args) {
        TreeNode<Integer> root=input();
        System.out.println(countLeaf(root));
    }
}
