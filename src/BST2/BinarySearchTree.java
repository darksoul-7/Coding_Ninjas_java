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
public class BinarySearchTree {
    private  BinaryTreeNode<Integer> root;
    
    public void insertData(int data){
        
        root=insertDataHelper(root,data);
    }
    private static BinaryTreeNode<Integer> insertDataHelper(BinaryTreeNode<Integer> root, int data){
        if(root==null){
            BinaryTreeNode<Integer> node=new BinaryTreeNode<>(data);
            return node;
        }
        if(root.data>=data){
            
            root.left=insertDataHelper(root.left, data);
        }else{
            root.right=insertDataHelper(root.right, data);
        }
        return root;
    }
    
    

    public  void deleteData(int data){
        root=deleteDataHelper(root,data);
    }
    
    private BinaryTreeNode<Integer> deleteDataHelper(BinaryTreeNode<Integer> root,int data){
        if(root==null){
            return root;
        }
        if(root.data>data){
            root.left=deleteDataHelper(root.left, data);
        }else if(root.data<data){
            root.right=deleteDataHelper(root.right,data);
        }else{
            if(root.left==null){
                return root.right;
            }
            if(root.right==null){
                return root.left;
            }
            root.data=min(root.right);
            root.right=deleteDataHelper(root.right, root.data);
        }
        return root;
    }
    private int min(BinaryTreeNode<Integer> root){
        int minval=root.data;
        while(root.left!=null){
            minval=root.left.data;
            root=root.left;
        }
        return minval;
    }
    private  boolean hasDataHelper(int data, BinaryTreeNode<Integer> node){
        if(node==null){
            return false;
        }
        if(node.data==data){
            return true;
        }else if(root.data>data){
            return hasDataHelper(data, node.left);
        }else{
            return hasDataHelper(data, node.right);
        }
    }
    public  boolean hasData(int data){
        return hasDataHelper(data, root);
    }
    
    public  void print(){
        printdata(root);
    }

    private  void printdata(BinaryTreeNode<Integer> root) {
        if(root==null){
            return;
        }
        System.out.print(root.data+": ");
        if(root.left!=null){
            System.out.print("L: "+root.left.data);
        }
        if(root.right!=null){
            System.out.print(", R: "+root.right.data);
        }
        System.out.println();
        printdata(root.left);
        printdata(root.right);

    }
    public static void main(String[] args) {
        BinarySearchTree bst=new BinarySearchTree();
        bst.insertData(35);
        bst.insertData(15);
        bst.insertData(10);
        bst.insertData(20);
        bst.insertData(20);
//        bst.deleteData(35);
        bst.print();
        System.out.println(bst.hasData(35));
        bst.deleteData(35);
        System.out.println(bst.hasData(35));
    }
}
