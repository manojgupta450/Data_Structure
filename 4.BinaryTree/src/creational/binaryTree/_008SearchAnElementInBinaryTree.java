package creational.binaryTree;

public class _008SearchAnElementInBinaryTree {
	Node root;
	
	public _008SearchAnElementInBinaryTree() {
		root=null;
	}
	
	private boolean search(Node node, int data)
    {
        if (node.data == data)
            return true;
        if (node.left != null)
            if (search(node.left, data))
                return true;
        if (node.right != null)
            if (search(node.right, data))
                return true;
        return false;         
    }

	public static void main(String[] args) {
		_008SearchAnElementInBinaryTree bt = new _008SearchAnElementInBinaryTree();
		bt.root=new Node(10);
		bt.root.left=new Node(2);
		bt.root.right=new Node(5);
		bt.root.left.left=new Node(6);
		bt.root.right.left=new Node(8);
		bt.root.right.right=new Node(3);

		//Search an element
		int data=8;
		System.out.println(bt.search(bt.root, data));
		
	}

}
