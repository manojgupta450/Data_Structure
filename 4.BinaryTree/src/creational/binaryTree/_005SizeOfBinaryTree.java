package creational.binaryTree;

public class _005SizeOfBinaryTree {
	Node root;

	_005SizeOfBinaryTree(){
		root = null;
	}

	public static int size(Node node) {
		if(node == null)
			return 0;
		int leftSize = size(node.left);
		int rightSize = size(node.right);
		return 1+leftSize+rightSize;
	}
	
	public static void main(String[] args) {
		_005SizeOfBinaryTree  bt =new _005SizeOfBinaryTree();
		bt.root=new Node(10);
		bt.root.left=new Node(2);
		bt.root.right=new Node(5);
		bt.root.left.left=new Node(6);
		bt.root.right.left=new Node(8);
		bt.root.right.right=new Node(3);
		
		//Size of tree
		System.out.println("size of tree is : " + size(bt.root)); 
		

	}

}
