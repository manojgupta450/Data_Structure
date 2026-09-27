package creational.binaryTree.Traversals;

//Java program for printing vertical order of a given binary tree
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Map.Entry;

import creational.binaryTree.Node;

public class _00VerticalOrderTraversal
{
  
 // Utility function to store vertical order in map 'm'
 // 'hd' is horizontal distance of current node from root.
 // 'hd' is initially passed as 0
 static void getVerticalOrder(Node root, int hd,
                             TreeMap<Integer,ArrayList<Integer>> m)
 {
     if(root == null) return;

     ArrayList<Integer> list =  m.get(hd); //get the vector list at 'hd'

     if(list == null) { // Store current node in map 'm'
         list = new ArrayList<Integer>();
     }
     list.add(root.data);
      
     m.put(hd, list);
     getVerticalOrder(root.left, hd-1, m); // Store nodes in left subtree
     getVerticalOrder(root.right, hd+1, m); // Store nodes in right subtree
 }

 static void printVerticalOrder(Node root)
 {
     TreeMap<Integer,ArrayList<Integer>> m = new TreeMap<>();
     int hd =0;
     getVerticalOrder(root,hd,m);
      
     for (Entry<Integer, ArrayList<Integer>> entry : m.entrySet()) {
         System.out.println(entry.getValue());
     }
 }
  
 // Driver program to test above functions
 public static void main(String[] args) {
     Node root = new Node(1);
     root.left = new Node(2);
     root.right = new Node(3);
     root.left.left = new Node(4);
     root.left.right = new Node(5);
     root.right.left = new Node(6);
     root.right.right = new Node(7);
     root.right.left.right = new Node(8);
     root.right.right.right = new Node(9);
     System.out.println("Vertical Order traversal is");
     printVerticalOrder(root);
 }
}
