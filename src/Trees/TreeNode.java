/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trees;

import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class TreeNode<T> {
    public T data;
    public ArrayList<TreeNode<T>> children;
    
    public TreeNode(T data){
        this.data=data;
        children=new ArrayList<>();   
    }
}
