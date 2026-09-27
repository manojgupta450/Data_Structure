package creational.binaryTree.Delete;

import creational.binaryTree.Node;

public class DeleteAllNodeInBinaryTree {
	Node root;
	
	public DeleteAllNodeInBinaryTree() {
		root=null;
	}

	//Do postOrder to delete node
	public static void deleteNode(Node data){
		if (data == null)
			return;
		deleteNode(data.left);
		deleteNode(data.right);
		System.out.println("Deleted node is : " + data.data);
		data.left = null;
		data.right = null;
			
	}
	
	public static void main(String[] args) {
		DeleteAllNodeInBinaryTree bt = new DeleteAllNodeInBinaryTree();
		bt.root=new Node(10);
		bt.root.left=new Node(2);
		bt.root.right=new Node(5);
		bt.root.left.left=new Node(6);
		bt.root.right.left=new Node(8);
		bt.root.right.right=new Node(3);
		
		//Delete tree
		deleteNode(bt.root);
		bt.root=null;
		System.out.println("Tree is deleted");
				
	}

}
