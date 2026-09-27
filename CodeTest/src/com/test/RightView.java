package com.test;

//Java program to print right view of binary tree 

//A binary tree node
class Node2 {

 int data;
 Node2 left;
Node2 right;

 Node2(int item) {
     data = item;
     left = right = null;
 }
}

//class to access maximum level by reference
class Max_level {

 int max_level;
}

public class RightView {

 Node2 root;
 Max_level max = new Max_level();

 // Recursive function to print right view of a binary tree.
 void rightViewUtil(Node2 node, int level, Max_level max_level) {

     // Base Case
     if (node == null) 
         return;

     // If this is the last Node of its level
     if (max_level.max_level < level) {
         System.out.print(node.data + " ");
         max_level.max_level = level;
     }

     // Recur for right subtree first, then left subtree
     rightViewUtil(node.right, level + 1, max_level);
     rightViewUtil(node.left, level + 1, max_level);
 }

 void rightView()
 {
     rightView(root);
 }

 // A wrapper over rightViewUtil()
 void rightView(Node2 node) {

     rightViewUtil(node, 1, max);
 }

 // Driver program to test the above functions
 public static void main(String args[]) {
     RightView tree = new RightView();
     tree.root = new Node2(1);
     tree.root.left = new Node2(2);
     tree.root.right = new Node2(3);
     tree.root.left.left = new Node2(4);
     tree.root.left.right = new Node2(5);
     tree.root.right.left = new Node2(6);
     tree.root.right.right = new Node2(7);
     tree.root.right.left.right = new Node2(8);
      
     tree.rightView();

     }
}

//This code has been contributed by Mayank Jaiswal
