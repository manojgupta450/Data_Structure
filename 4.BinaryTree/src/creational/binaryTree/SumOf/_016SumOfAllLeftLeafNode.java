package creational.binaryTree.SumOf;

import creational.binaryTree.Node;

public class _016SumOfAllLeftLeafNode
{
	Node root;
	//int sum = 0;
	int leftLeavesSum(Node node)
	{
		if (node == null)
			return 0;
		if (node.left != null && (node.left.left == null && node.left.right == null))
			return node.left.data + leftLeavesSum(node.right);
		return leftLeavesSum(node.right) + leftLeavesSum(node.left);

		/*if (node == null)
			return 0;

		if (node.left != null && node.left.left == null && node.left.right == null)
			sum += node.left.data;
		leftLeavesSum(node.left);
		leftLeavesSum(node.right);
		return sum;*/
	}

	// Driver program
	public static void main(String args[]) 
	{
		_016SumOfAllLeftLeafNode tree = new _016SumOfAllLeftLeafNode();
		tree.root = new Node(20);
		tree.root.left = new Node(9);
		tree.root.right = new Node(49);
		tree.root.left.right = new Node(12);
		//tree.root.left.right.left = new Node(10);
		tree.root.left.left = new Node(5);
		tree.root.right.left = new Node(23);
		tree.root.right.right = new Node(52);
		tree.root.left.right.right = new Node(12);
		tree.root.right.right.left = new Node(50);

		System.out.println("The sum of leaves is " + 
									tree.leftLeavesSum(tree.root));
	}
}
