package BinarySearchTree;

public class _1BinarySearchTree {
	Node root;
	
	public _1BinarySearchTree() {
		root=new Node();
	}

	public Node search(Node node,int key)
	{
		if(node==null) {
			return null;
		}	
		if(node.data==key) {
			return node;
		}
		else if(node.data < key) {
			return search(node.right,key);
		}
		else{
			return search(node.left,key);
		}
	}
	public static void main(String[] args) {
		_1BinarySearchTree bst=new _1BinarySearchTree();
		bst.root=new Node(10);
		bst.root.left=new Node(-5);
		bst.root.left.left=new Node(-10);
		bst.root.left.right=new Node(5);
		bst.root.right=new Node(25);
		bst.root.right.right=new Node(36);
		Node node=bst.search(bst.root, 5);
		System.out.println("Key Found "+node.data);
		node=bst.search(bst.root,22);
		if(node!=null) {
			System.out.println("Key Found "+node.data);
		}
		else {
			System.out.println("Key not Found in BST");
		}
		
	}

}
