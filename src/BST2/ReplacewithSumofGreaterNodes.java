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
public class ReplacewithSumofGreaterNodes {
    public static int helper(BinaryTreeNode<Integer> root, int sum){
        if(root == null){
            return 0;
        }
        
        int right = helper(root.right ,sum);
        int rootdata = root.data;
        root.data = root.data + right + sum;
        int left = helper(root.left ,root.data);
        
        return rootdata + right + left;
    }
	public static void replaceWithLargerNodesSum(BinaryTreeNode<Integer> root) {
		// Write your code here
        if(root==null){
            return;
        }
		int ans=helper(root,0);
        
	}
}
