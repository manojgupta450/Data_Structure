package com.test;

//Java program to extract leaf nodes from binary tree
//using double linked list

//A binay tree node
class Node11 
{
 int data;
 Node11 left;
 Node11 right;

 Node11(int item) 
 {
     data = item;
     right = left = null;
 }
}

public class BinaryTree111 
{
 Node11 root;
 Node11 head; // will point to head of DLL  
 Node11 prev; // temporary pointer 

 // The main fuction that links the list list to be traversed
 public Node11 extractLeafList(Node11 root) 
 {
     if (root == null)
         return null;
     if (root.left == null && root.right == null) 
     {
         if (head == null) 
         {
             head = root;
             prev = root;
         } 
         else
         {
             prev.right = root;
             root.left = prev;
             prev = root;
         }
         return null;
     }
     root.left = extractLeafList(root.left);
     root.right = extractLeafList(root.right);
     return root;
 }

 //Prints the DLL in both forward and reverse directions.
 public void printDLL(Node11 head) 
 {
     //Node11 last = null;
     while (head != null) 
     {
         System.out.print(head.data + " ");
         //last = head;
         head = head.right;
     }
 }

 void inorder(Node11 node) 
 {
     if (node == null)
         return;
     inorder(node.left);
     System.out.print(node.data + " ");
     inorder(node.right);
 }

 // Driver program to test above functions
 public static void main(String args[]) 
 {
     BinaryTree111 tree = new BinaryTree111();
     tree.root = new Node11(1);
     tree.root.left = new Node11(2);
     tree.root.right = new Node11(3);

     tree.root.left.left = new Node11(4);
     tree.root.left.right = new Node11(5);
     tree.root.right.right = new Node11(6);
     tree.root.left.left.left = new Node11(7);
     tree.root.left.left.right = new Node11(8);
     tree.root.right.right.left = new Node11(9);
     tree.root.right.right.right = new Node11(10);

     System.out.println("Inorder traversal of given tree is : ");
     tree.inorder(tree.root);
     tree.extractLeafList(tree.root);
     System.out.println("");
     System.out.println("Extracted double link list is : ");
     tree.printDLL(tree.head);
     System.out.println("");
     System.out.println("Inorder traversal of modified tree is : ");
     tree.inorder(tree.root);
 }
}

//This code has been contributed by Mayank Jaiswal(mayank_24)
