package com.leetcode.premium.fb;

import com.ds.Node;
import com.ds.Tree;
import org.junit.Test;

import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;

public class TreeToDoublyLinkedList {
    
    

    @Test
    public void byRecurrsion(){

    }

    @Test
    public void byIterative(){


        Tree.TNode head = Tree.mine(), root = head;
        Tree.print(root);

        ArrayDeque<Tree.TNode> stack = new ArrayDeque<>();

        while(root!=null){
            stack.push(root);
            root = root.left;
        }

        Tree.TNode dummy = new Tree.TNode(), prev = dummy;


        while(!stack.isEmpty()){
            Tree.TNode curr = stack.pop();
            prev.right = curr;
            curr.left = prev;


            if(curr.right!=null){
                Tree.TNode right = curr.right;
                while(right!=null){
                    stack.push(right);
                    right = right.left;
                }
            }
            prev = curr;
        }



        Tree.TNode n = dummy.right;
        while (n!=null){
            System.out.print(n.val+",");
            n =  n.right;
        }

        System.out.println();
        while (prev!=null){
            System.out.print(prev.val+",");
            prev =  prev.left;
        }

    /*
        if(dummy.right!=null){
            dummy.right.left = prev;
            prev.right = dummy.right;
        }*/
    }

    @Test
    public void usingStack(){

    }
}

