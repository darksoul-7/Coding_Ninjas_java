/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BST2;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Lenovo
 */
public class FindPairSum {

    static void covertBstToArr(BinaryTreeNode<Integer> root, ArrayList<Integer> arr) {
        if (root == null) {
            return;
        }
        arr.add(root.data);
        covertBstToArr(root.left, arr);
        covertBstToArr(root.right, arr);
    }

    static void pairSum(BinaryTreeNode<Integer> root, int sum) {
        ArrayList<Integer> arr = new ArrayList<>();
        covertBstToArr(root, arr);
        int i = 0;
        int j = arr.size() - 1;
        Collections.sort(arr);
        while (i < j) {
            if (arr.get(i) + arr.get(j) == sum) {
                System.out.println(arr.get(i) + " " + arr.get(j));
                i++;
                j--;
            } else if (arr.get(i) + arr.get(j) > sum) {
                j--;
            } else {
                i++;
            }
        }
    }
}
