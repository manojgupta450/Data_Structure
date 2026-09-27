package com.test;

public class BinaryTree {
		Node root;
	public BinaryTree() {
		root=null;
	}

	public static void main(String[] args) {
		BinaryTree bt=new BinaryTree();
		bt.root=new Node(10);
		bt.root.left=new Node(2);
		bt.root.right=new Node(5);
		bt.root.left.left=new Node(6);
		bt.root.right.left=new Node(8);
		bt.root.right.right=new Node(3);
		//bt.inOrder();
		bt.preOrder();
		//bt.postOrder();
	}
	
	void inOrder() {
		inOrder(root);
	}
	
	void preOrder() {
		preOrder(root);
	}
	
	void postOrder() {
		postOrder(root);
	}
	public void inOrder(Node root) {
		if(root==null)
			return;
		inOrder(root.left);
		System.out.println(root.data);
		inOrder(root.right);
	}
	public void preOrder(Node root) {
		if(root!=null)
		{
		System.out.println(root.data);
		preOrder(root.left);
		preOrder(root.right);
		}
	}
	public void postOrder(Node root) {
		if(root==null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.data);
	}

}
