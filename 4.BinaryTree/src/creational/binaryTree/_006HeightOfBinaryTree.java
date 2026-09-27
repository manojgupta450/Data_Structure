package creational.binaryTree;

public class _006HeightOfBinaryTree {
	Node root;
	
	public _006HeightOfBinaryTree() {
		root=null;
	}

	public static int height(Node node) {
		if(node == null)
			return 0;
		int leftHeight = height(node.left);
		int rightHeight = height(node.right); 
		return 1 + max(leftHeight,rightHeight);
		
	}
	
	public static int max(int left,int right) {
		if(left >= right)
			return left;
		else 
			return right;
	}

	public static void main(String[] args) {
		_006HeightOfBinaryTree bt = new _006HeightOfBinaryTree();
		bt.root=new Node(10);
		bt.root.left=new Node(2);
		bt.root.right=new Node(5);
		bt.root.left.left=new Node(6);
		bt.root.right.left=new Node(8);
		bt.root.right.right=new Node(3);
		
		//Height of tree
		System.out.println("Height of tree is : " + height(bt.root)); 
				

	}

}
