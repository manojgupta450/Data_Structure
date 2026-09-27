package creational.binaryTree.Traversals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import creational.binaryTree.Node;

public class _00DiagonalTraversalUsingRecursion {

 static void diagonalPrintUtil(Node root,int d, HashMap<Integer,List<Integer>> diagonalMap) {
     if (root == null) return;

     List<Integer> dList = diagonalMap.get(d); // get the list at the particular d value
     if (dList == null) { // k is null then create a vector and store the data else just data in list
         dList = new ArrayList<>();
     }
     dList.add(root.data);

     diagonalMap.put(d, dList); // Store all nodes of same line together as a vector
     diagonalPrintUtil(root.left, d + 1, diagonalMap); // Increase the vertical distance if left child
     diagonalPrintUtil(root.right, d, diagonalMap);  // Vertical distance remains same for right child
 }
  
 static void diagonalPrint(Node root)
 {
     HashMap<Integer,List<Integer>> diagonalPrint = new HashMap<>();
     diagonalPrintUtil(root, 0, diagonalPrint);
      
     System.out.println("Diagonal Traversal of Binnary Tree");
     for (Entry<Integer, List<Integer>> entry : diagonalPrint.entrySet())
     {
         System.out.println(entry.getValue());
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
     diagonalPrint(root);
 }
}