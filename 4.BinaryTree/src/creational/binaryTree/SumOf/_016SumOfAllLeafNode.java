package creational.binaryTree.SumOf;

import creational.binaryTree.Node;

public class _016SumOfAllLeafNode
{
	Node root;
	//int sum = 0;
	int LeavesSum(Node node)
	{
		if (node == null)
			return 0;
		else if (node.left == null && node.right == null) {
			return node.data;
		}
		return LeavesSum(node.left) + LeavesSum(node.right);

		/*if (node == null)
			return 0;

		if (node.left == null && node.right == null) {
			sum += node.data;
			}
		LeavesSum(node.left);
		LeavesSum(node.right);

		return sum;*/
	}

	// Driver program
	public static void main(String args[]) 
	{
		_016SumOfAllLeafNode tree = new _016SumOfAllLeafNode();
		tree.root = new Node(20);
		tree.root.left = new Node(9);
		tree.root.right = new Node(49);
		tree.root.left.right = new Node(12);
		tree.root.left.left = new Node(5);
		tree.root.right.left = new Node(23);
		tree.root.right.right = new Node(52);
		tree.root.left.right.right = new Node(12);
		tree.root.right.right.left = new Node(50);

		System.out.println("The sum of leaves is " + 
									tree.LeavesSum(tree.root));
	}
}

