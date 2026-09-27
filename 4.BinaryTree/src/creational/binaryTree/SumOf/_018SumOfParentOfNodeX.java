package creational.binaryTree.SumOf;

import creational.binaryTree.Node;

public class _018SumOfParentOfNodeX
{
	Node root;
	int sum = 0;
	int SumOfNode(Node node,int n)
	{
		if (node == null) 
			return 0;
		if((node.left != null &&  node.left.data==n) || (node.right != null &&  node.right.data==n ))
			sum += node.data;
		SumOfNode(node.left, n);
		SumOfNode(node.right, n);
		return sum;
	}

	// Driver program
	public static void main(String args[]) 
	{
		_018SumOfParentOfNodeX tree = new _018SumOfParentOfNodeX();
		tree.root = new Node(4);
		tree.root.left = new Node(2);
		tree.root.right = new Node(5);
		tree.root.left.right = new Node(2);
		tree.root.left.left = new Node(7);
		tree.root.right.right = new Node(3);
		tree.root.right.left = new Node(2);

		System.out.println("The sum of node is " + 
									tree.SumOfNode(tree.root,2));
	}
}
