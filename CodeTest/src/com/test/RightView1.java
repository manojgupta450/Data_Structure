package com.test;

public class RightView1 {
	
	Node3 root;
	
	public RightView1() {
		this.root=null;
	}

	public static void main(String[] args) {
		RightView1 rv=new RightView1();
		rv.root=new Node3(10);
		rv.root.left=new Node3(20);
		rv.root.right=new Node3(30);
		rv.root.left.right=new Node3(40);
		rv.root.right.left=new Node3(50);
		
		rv.rightViewUtil(rv.root);

	}

	private void rightViewUtil(Node3 root2) {
		//rightView(root2,)
		
	}

	private void rightView(Node3 root2) {
		// TODO Auto-generated method stub
		
	}

	void Max(){
		int max;
	}
}

class Node3{
	Node3 left;
	Node3 right;
	int data;
	
	public Node3(int data) {
		super();
		this.left = null;
		this.right = null;
		this.data = data;
	}
	
	
}