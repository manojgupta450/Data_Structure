package creational.binaryTree.SumOf;

import creational.binaryTree.Node;

public class _017SumOfAllLeftNode
{
	Node root;
	int SumOfNode(Node node)
	{
		if (node == null) 
			return 0;
		return node.data + SumOfNode(node.left);
	}

	// Driver program
	public static void main(String args[]) 
	{
		_017SumOfAllLeftNode tree = new _017SumOfAllLeftNode();
		tree.root = new Node(20);
		tree.root.left = new Node(9);
		tree.root.right = new Node(49);
		tree.root.left.right = new Node(12);
		tree.root.left.left = new Node(5);
		tree.root.right.left = new Node(23);
		tree.root.right.right = new Node(52);
		tree.root.left.right.right = new Node(12);
		tree.root.right.right.left = new Node(50);
		tree.root.right.right.right = new Node(8);

		System.out.println("The sum of node is " + 
									tree.SumOfNode(tree.root));
	}
}
