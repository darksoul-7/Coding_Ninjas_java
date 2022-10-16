/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BST2;

import java.util.*;


/**
 *
 * @author Lenovo
 */
public class LCAofBST {

    
    public static int findLCA(BinaryTreeNode<Integer> root, int a, int b) {
        if (root == null) {
            return -1;
        }
        if (root.data == a || root.data == b) {
            return root.data;
        }
        int leftans = findLCA(root.left, a, b);
        int rightans = findLCA(root.right, a, b);
        if (leftans == -1 && rightans != -1) {
            return rightans;
        } else if (leftans != -1 && rightans == -1) {
            return leftans;
        } else if (leftans != -1 && rightans != -1) {
            return root.data;
        }
        return -1;
    }
}
