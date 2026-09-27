package creational.binaryTree;

public class _023InorderSuccessorPredecessor {
	static int successor, predecessor;

	public void successorPredecessor(Node root, int val) {
		if (root != null) {
			if (root.data == val) {
				// go to the right most element in the left subtree, it will the
				// predecessor.
				if (root.left != null) {
					Node t = root.left;
					if (t.right != null) {
						t = t.right;
					}
					predecessor = t.data;
				}
				if (root.right != null) {
					// go to the left most element in the right subtree, it will
					// the successor.
					Node t = root.right;
					if (t.left != null) {
						t = t.left;
					}
					successor = t.data;
				}
			}else if (root.data < val) {
				predecessor = root.data;
				successorPredecessor(root.right, val);
			} else if (root.data > val) {
				successor = root.data;
				successorPredecessor(root.left, val);
			} 
		}
	}

	public static void main(String args[]) {
		Node root = new Node(20);
		root.left = new Node(10);
		root.right = new Node(30);
		root.left.left = new Node(5);
		root.left.left.right = new Node(7);
		root.left.right = new Node(15);
		root.right.left = new Node(25);
		root.right.right = new Node(35);
		root.left.right.left = new Node(13);
		root.left.right.right = new Node(18);
		_023InorderSuccessorPredecessor i = new _023InorderSuccessorPredecessor();
		i.successorPredecessor(root, 10);
		System.out.println("Inorder Successor of 10 is : " + successor
				+ " and predecessor is : " + predecessor);
		i.successorPredecessor(root, 30);
		System.out.println("Inorder Successor of 30 is : " + successor
				+ " and predecessor is : " + predecessor);
	}
}


