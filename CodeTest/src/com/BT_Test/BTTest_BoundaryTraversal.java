package com.BT_Test;

import com.BT_Test.Node;

public class BTTest_BoundaryTraversal{
	Node root;
	public BTTest_BoundaryTraversal(){
		this.root=null;
	}
	
	public static void main(String args[]) {
		BTTest_BoundaryTraversal tree = new BTTest_BoundaryTraversal();
	      tree.root = new Node(20);
	      tree.root.left = new Node(8);
	      tree.root.left.left = new Node(4);
	      tree.root.left.right = new Node(12);
	      tree.root.left.right.left = new Node(10);
	      tree.root.left.right.left.left = new Node(5);
	      tree.root.left.right.right = new Node(14);
	      tree.root.right = new Node(22);
	      tree.root.right.right = new Node(25);
	      tree.printBoundary(tree.root);
	}

	private void printBoundary(Node node) {
		printLeftView(node);
		printLeafNode(node);
		printRightNode(node.right);	
	}

	private void printRightNode(Node node) {
		if(node==null)
			return;
		if(node.right!=null) {
			System.out.println(node.data);
			printRightNode(node.right);
		}
		if(node.left!=null)
			printRightNode(node.left.right);
	}

	private void printLeafNode(Node node) {
		if(node==null)
			return;
		if(node.left==null && node.right==null) {
			System.out.println(node.data);
		}
		printLeafNode(node.left);
		printLeafNode(node.right);
	}

	private void printLeftView(Node node) {
		if(node==null)
			return;
		if(node.left!=null) {
			System.out.println(node.data);
			printLeftView(node.left);
		}
		if(node.right!=null)
		printLeftView(node.right.left);
	}
}
