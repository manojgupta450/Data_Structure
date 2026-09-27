package com.BT_Test;

public class BTTest_LeftView{
	Node root;
	static int max_level=0;
	public static void main(String args[]) {
		BTTest_LeftView bt=new BTTest_LeftView();
		 bt.root = new Node(4);
	     bt.root.left = new Node(5);
	     bt.root.right = new Node(2);
	     bt.root.right.left = new Node(3);
	     bt.root.right.right = new Node(1);
	     bt.root.right.left.left = new Node(6);
	     bt.root.right.left.right = new Node(7);
	     
	     leftView(bt.root);
	}

	private static void leftView(Node root) {
		leftView(root,1);
		
	}

	private static void leftView(Node root2, int level) {
		if(root2==null)
			return;
		if(max_level < level) {
			System.out.println(root2.data);
			max_level=level;
		}
		leftView(root2.left, level+1);
		leftView(root2.right, level+1);
	}
	
}

class Node {
	Node left;
	int data;
	Node right;
	
	Node(int data){
		this.data=data;
		left=null;
		right=null;
	}
}
