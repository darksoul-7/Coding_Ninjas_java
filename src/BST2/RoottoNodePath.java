/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BST2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class RoottoNodePath {
    public static ArrayList<Integer> getPath(BinaryTreeNode<Integer> root, int node){
        
        if(root==null){
            return null;
        }
        if(root.data==node){
            ArrayList<Integer> path=new ArrayList<>();
            path.add(root.data);
            return path;
        }
        ArrayList<Integer> leftop=getPath(root.left,node);
        if(leftop!=null){
            leftop.add(root.data);
            return leftop;
        }
        ArrayList<Integer> rightop=getPath(root.right,node);
        if(rightop!=null){
            rightop.add(root.data);
            return rightop;
        }else{
            return null;
        }
    }
    public static ArrayList<Integer> getRootToNodePath(BinaryTreeNode<Integer> root, int data) {
		if (root == null) {
			return null;
		}
		
		if (root.data == data) {
			ArrayList<Integer> output = new ArrayList<>();
			output.add(root.data);
			return output;
		}
		
		ArrayList<Integer> leftOutput = getRootToNodePath(root.left, data);
		if (leftOutput != null) {
			leftOutput.add(root.data);
			return leftOutput;
		}
		
		ArrayList<Integer> rightOutput = getRootToNodePath(root.right, data);
		if (rightOutput != null) {
			rightOutput.add(root.data);
			return rightOutput;
		} else {
			return null;
		}
		
	}
    public static BinaryTreeNode<Integer> getinput(){
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the root data");
        int data=s.nextInt();
        if(data==-1){
            return null;
        }
        BinaryTreeNode<Integer> root=new BinaryTreeNode<>(data);
        Queue<BinaryTreeNode<Integer>> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            BinaryTreeNode<Integer> front=q.poll();
            System.out.println("Enter the leftchild of "+front.data);
            int l=s.nextInt();
            if(l!=-1){
                BinaryTreeNode<Integer> left=new BinaryTreeNode<>(l);
                front.left=left;
                q.add(left);
            }
            System.out.println("Enter the rightchild of "+front.data);
            int r=s.nextInt();
            if(r!=-1){
                BinaryTreeNode<Integer> right=new BinaryTreeNode<>(r);
                front.right=right;
                q.add(right);
            }
        }
        return root;
    }
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root=getinput();
        ArrayList<Integer> list=getPath(root,11);
        //ArrayList<Integer> list=getRootToNodePath(root, 11);
        if(list!=null){
            for(int i:list){
                System.out.println(i+" ");
            }
        }
    }
}
