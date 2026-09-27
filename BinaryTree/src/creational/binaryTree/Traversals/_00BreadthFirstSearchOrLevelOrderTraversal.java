package creational.binaryTree.Traversals;

import java.util.LinkedList;
import java.util.Queue;
import creational.binaryTree.Node;

public class _00BreadthFirstSearchOrLevelOrderTraversal {

	public void breadthFirstTraversal(Node root) {
		if (root == null) return;

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		while(!queue.isEmpty()) {
			Node tempNode = queue.poll();
			System.out.print(tempNode.data + " ");
			if(tempNode.left != null) {
				queue.add(tempNode.left);
			}
			if(tempNode.right != null) {
				queue.add(tempNode.right);
			}
		}
	}

	public static void main(String[] args) {
		Node root=new Node(10);
		root.left=new Node(21);
		root.left.right=new Node(15);
		root.left.right.left=new Node(18);
		root.right=new Node(19);
		root.right.left=new Node(-6);
		root.right.left.right=new Node(17);
		root.right.right=new Node(0);
		root.right.right.right=new Node(12);
		
		System.out.println("Breadth first traversal : ");
		new _00BreadthFirstSearchOrLevelOrderTraversal().breadthFirstTraversal(root);
	}

}
