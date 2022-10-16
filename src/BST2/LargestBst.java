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
public class LargestBst {
    public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
		// Write your code here
        Pair result=largestBSTsubtreeHelper(root);
        return result.height;
	}
    public static Pair largestBSTsubtreeHelper(BinaryTreeNode<Integer> root){
        if(root==null){
            Pair res=new Pair();
            res.min=Integer.MAX_VALUE;
            res.max=Integer.MIN_VALUE;
            res.isBst=true;
            res.height=0;
            return res;
        }
        Pair leftans=largestBSTsubtreeHelper(root.left);
        Pair rightans=largestBSTsubtreeHelper(root.right);
        if(!(leftans.max<root.data)){
            leftans.isBst=false;
        }
        if(!(rightans.min>root.data)){
            rightans.isBst=false;
        }
        if(!leftans.isBst || !rightans.isBst || root.data>rightans.min || root.data<leftans.max){
            if(leftans.height>rightans.height){
                leftans.isBst=false;
                return leftans;
            }
            else{
                rightans.isBst=false;
                return rightans;
            }
        }
        Pair output=new Pair();
        output.min=Math.min(leftans.min, Math.min(root.data,rightans.min));
        output.max=Math.max(leftans.max, Math.max(root.data,rightans.max));
        output.isBst=true;
        output.height=Math.max(leftans.height,rightans.height)+1;
        return output;
    }
}
class Pair{
    int min;
    int max;
    boolean isBst;
    int height;
}