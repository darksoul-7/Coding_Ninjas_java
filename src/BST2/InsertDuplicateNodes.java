/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BST2;

/**
 *
 * @author Lenovo
 */
public class InsertDuplicateNodes {

    public static void insertDuplicateNode(BinaryTreeNode<Integer> root) {
        //Your code goes here
        if (root == null) {
            return;
        }
        BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>(root.data);
        BinaryTreeNode<Integer> prev = root.left;
        root.left = newNode;
        newNode.left = prev;
        insertDuplicateNode(prev);
        insertDuplicateNode(root.right);
    }
}
