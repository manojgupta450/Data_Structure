package creational.binaryTree.SumOf;

import creational.binaryTree.Node;

public class _016SumOfAllRightLeafNode
{
	Node root;
	int sum = 0;
	int leftLeavesSum(Node node)
	{
		/*if (node == null)
			return 0;
	
		if (node.right != null && node.right.left == null && node.right.right == null)
			sum += node.right.data;
		
		leftLeavesSum(node.left);
		leftLeavesSum(node.right);
		return sum;*/

		if (node == null)
			return 0;
		if (node.right != null && (node.right.left == null && node.right.right == null))
			return node.right.data + leftLeavesSum(node.left);
		return leftLeavesSum(node.right) + leftLeavesSum(node.left);
	}

	// Driver program
	public static void main(String args[]) 
	{
		_016SumOfAllRightLeafNode tree = new _016SumOfAllRightLeafNode();
		tree.root = new Node(20);
		tree.root.left = new Node(9);
		tree.root.right = new Node(49);
		tree.root.left.right = new Node(12);
		tree.root.left.left = new Node(5);
		tree.root.right.left = new Node(23);
		tree.root.right.right = new Node(52);
		tree.root.left.right.right = new Node(12);
		tree.root.right.right.left = new Node(50);
		//tree.root.right.right.right = new Node(8);

		System.out.println("The sum of leaves is " + 
									tree.leftLeavesSum(tree.root));
	}
}
