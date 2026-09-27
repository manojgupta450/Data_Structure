package com.BT_Test;

public class BTTest_RightView{
	Node root;
	MAX_LEVEL max=new MAX_LEVEL();
	public static void main(String args[]) {
		BTTest_RightView bt=new BTTest_RightView();
		bt.root = new Node(1);
		bt.root.left = new Node(2);
		bt.root.right = new Node(3);
		bt.root.left.left = new Node(4);
		bt.root.left.right = new Node(5);
		bt.root.right.left = new Node(6);
		bt.root.right.right = new Node(7);
		bt.root.right.left.right = new Node(8);
	     
	     bt.rightView(bt.root);
	}

	private void rightView(Node root) {
		rightView(root,max,1);
		
	}

	private void rightView(Node root2, MAX_LEVEL max,int level) {
		if(root2==null)
			return;
		if(max.max_level < level) {
			System.out.println(root2.data);
			max.max_level=level;
		}
		rightView(root2.right, max,level+1);
		rightView(root2.left,max, level+1);
	}
	
}

class MAX_LEVEL{
	int max_level;
}


