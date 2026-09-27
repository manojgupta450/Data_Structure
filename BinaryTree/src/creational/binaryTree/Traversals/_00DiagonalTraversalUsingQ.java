package creational.binaryTree.Traversals;

import java.util.LinkedList;
import java.util.Queue;

import creational.binaryTree.Node;

public class _00DiagonalTraversalUsingQ {

 static void diagonalPrintUtil(Node root) {
     if (root == null) return;

     // inbuilt queue of Treenode
     Queue<Node> q= new LinkedList<Node>();
     q.add(root); // add root
     q.add(null); // add delimiter

     while (q.size()>0) {
         Node temp = q.peek();
         q.remove();
         // if current is delimiter then insert another for next diagonal and cout nextline
         if (temp == null) {
             if (q.size()==0) return; // if queue is empty return
             System.out.println(); // output nextline
             q.add(null); // add delimiter again
         } else {
             while (temp!=null) {
                 System.out.print( temp.data + " ");
                 if (temp.left!=null) // if left child is present add into queue
                     q.add(temp.left);
                 temp = temp.right;// current equals to right child
             }
         }
     }
 }

 public static void main(String[] args) {
     Node root = new Node(8);
     root.left = new Node(3);
     root.right = new Node(10);
     root.left.left = new Node(1);
     root.left.right = new Node(6);
     root.right.right = new Node(14);
     root.right.right.left = new Node(13);
     root.left.right.left = new Node(4);
     root.left.right.right = new Node(7);
     diagonalPrintUtil(root);
 }
}