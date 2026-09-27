package BinarySearchTree;

public class _2BinarySearchTreeInsertion {
	Node root;
	
	public _2BinarySearchTreeInsertion() {
		root=null;
	}

	public Node insertInBST(Node node,int key) {
		Node newNode=new Node(key);
		if(node == null) {
			return newNode;
		}
		Node current = node;
		Node parent = null;;
		
		while(current != null) {
			parent=current;
			if(current.data <= key) {
				current=current.right;
			}else {
				current=current.left;
			}
		}
		
		if(parent.data <= key) {
			parent.right = newNode;
		}else {
			parent.left = newNode;
		}
		return node;
	}
	public static void main(String[] args) {
		_2BinarySearchTreeInsertion bst=new _2BinarySearchTreeInsertion();
		bst.root=new Node(10);
		bst.root.left=new Node(-5);
		bst.root.left.left=new Node(-10);
		bst.root.left.right=new Node(5);
		bst.root.right=new Node(25);
		bst.root.right.right=new Node(36);

		System.out.println(bst.insertInBST(bst.root, 16));
	}

}
