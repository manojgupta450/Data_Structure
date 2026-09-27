package creational.binaryTree.Traversals;

import creational.binaryTree.Node;

public class _000BoundaryTraversal {

  static void printLeaves(Node node) {
      if (node == null) return;
      printLeaves(node.left);
      if (node.left == null && node.right == null) {// Print it if it is a leaf node
          System.out.print(node.data + " ");
      }
      printLeaves(node.right);
  }

  // A function to print all left boundary nodes, except a leaf node.Print the nodes in TOP DOWN manner
  static void printLeftBoundary(Node node) {
      if (node == null) return;

      if (node.left != null) { // to ensure top down order, print the node before calling itself for left subtree
          System.out.print(node.data + " ");
          printLeftBoundary(node.left);
      } else if (node.right != null) {
          System.out.print(node.data + " ");
          printLeftBoundary(node.right);
      }
      // do nothing if it is a leaf node, this way we avoid duplicates in output
  }

  // A function to print all right boundry nodes, except a leaf node Print the nodes in BOTTOM UP manner
  static void printRightBoundary(Node node) {
      if (node == null) return;

      if (node.right != null) { // to ensure bottom up order, first call for right subtree, then print this node
          printRightBoundary(node.right);
          System.out.print(node.data + " ");
      } else if (node.left != null) {
          printRightBoundary(node.left);
          System.out.print(node.data + " ");
      }
      // Note : Do nothing if it is a leaf node, this way we avoid duplicates in output
  }

  // A function to do boundary traversal of a given binary tree
  static void printBoundary(Node node) {
      if (node == null) return;
      System.out.print(node.data + " "); // 1. Print root node
      printLeftBoundary(node.left); // 2. Print the left boundary in top-down manner.
      printLeaves(node.left);  // 3. Print all leaf nodes (Print left leaves
      printLeaves(node.right); // and then right leaves)
      printRightBoundary(node.right); // 4. Print the right boundary in bottom-up manner
  }
  
  public static void main(String args[]) {
      Node root = new Node(20);
      root.left = new Node(8);
      root.left.left = new Node(4);
      root.left.right = new Node(12);
      root.left.right.left = new Node(10);
      root.left.right.right = new Node(14);
      root.right = new Node(22);
      root.right.right = new Node(25);
      printBoundary(root);

  }
}
