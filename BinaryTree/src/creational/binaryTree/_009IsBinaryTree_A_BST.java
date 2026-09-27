package creational.binaryTree;


public class _009IsBinaryTree_A_BST {
	Node root;
	
	public _009IsBinaryTree_A_BST() {
		root=null;
	}
	
	public boolean isBinaryTree_A_BST(Node node,int min,int max){
		if(node==null)
		return true;
		
		if(node.data <= min || node.data > max) {
			return false;
		}
		
		 return isBinaryTree_A_BST(node.left, min, node.data) &&
				 isBinaryTree_A_BST(node.right, node.data, max);
		
	}
	public static void main(String[] args) {
		_009IsBinaryTree_A_BST bst=new _009IsBinaryTree_A_BST();
		bst.root=new Node(10);
		bst.root.left=new Node(-5);
		bst.root.left.left=new Node(-10);
		bst.root.left.right=new Node(5);
		bst.root.right=new Node(25);
		bst.root.right.right=new Node(36);
		
		System.out.println(bst.isBinaryTree_A_BST(bst.root,-100,100));
		
	}

}
