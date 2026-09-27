package creational.binaryTree;

public class _004SameBinaryTree {
	Node root;
	
	_004SameBinaryTree(){
		root = null;
	}
	
	boolean sameBinaryTree(Node node1, Node node2) {
		if(node1 == null && node2 == null) {
			return true;
		}
		if(node1 == null || node2 == null) {
			return false;
		}
		return node1.data == node2.data && sameBinaryTree(node1.left,node2.left)
				&& sameBinaryTree(node1.right, node2.right);
		
	}
	public static void main(String[] args) {
		_004SameBinaryTree bt=new _004SameBinaryTree();
		bt.root=new Node(11);
		bt.root.left=new Node(15);
		bt.root.right=new Node(18);
		bt.root.right.left=new Node(21);
		
		_004SameBinaryTree bt1=new _004SameBinaryTree();
		bt1.root=new Node(11);
		bt1.root.left=new Node(15);
		bt1.root.right=new Node(18);
		bt1.root.right.left=new Node(21);

		System.out.println("Is the given tree same : "+bt.sameBinaryTree(bt.root, bt1.root));
	}

}
