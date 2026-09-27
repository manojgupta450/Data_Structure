package creational.binaryTree.Traversals;

import java.util.*;

import creational.binaryTree.Node;

//Time Complexity: O(n)
//Space Complexity: O(n)+(n)=O(n)
public class _00ZigZagTreeTraversal {
	void printZigZagTraversal(Node rootNode) {
		if (rootNode == null) return;

		Stack<Node> currentLevel = new Stack<>();
		Stack<Node> nextLevel = new Stack<>();

		currentLevel.push(rootNode);
		boolean leftToRight = true;

		while (!currentLevel.isEmpty()) {
			Node node = currentLevel.pop();
			System.out.print(node.data + " ");

			// store data according to current order.
			if (leftToRight) {
				if (node.left != null) {
					nextLevel.push(node.left);
				}

				if (node.right != null) {
					nextLevel.push(node.right);
				}
			} else {
				if (node.right != null) {
					nextLevel.push(node.right);
				}

				if (node.left != null) {
					nextLevel.push(node.left);
				}
			}

			if (currentLevel.isEmpty()) { // If current level is empty swap stack
				leftToRight = !leftToRight;
				Stack<Node> temp = currentLevel;
				currentLevel = nextLevel;
				nextLevel = temp;
			}
		}
	}

	public static void main(String[] args) {
		Node rootNode = new Node(1);
		rootNode.left = new Node(2);
		rootNode.right = new Node(3);
		rootNode.left.left = new Node(7);
		rootNode.left.right = new Node(6);
		rootNode.right.left = new Node(5);
		rootNode.right.right = new Node(4);

		System.out.println("ZigZag Order traversal of binary tree is");
		new _00ZigZagTreeTraversal().printZigZagTraversal(rootNode);
	}
}
