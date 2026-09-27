package creational.binaryTree.Traversals;

import java.util.Stack;

import creational.binaryTree.Node;

public class _00DepthFirstSearchOrInPrePostOrderTraversalUsingIterative {
	
	public static void preOrder(Node node) {
		if(node == null)
			return;
		Stack<Node> st=new Stack<Node>();
		st.push(node);
		while (st.size() != 0) {
			node=st.pop();
			System.out.print(node.data+" ");
			if(node.right !=null) {
				st.push(node.right);
			}
			
			if(node.left != null) {
				st.push(node.left);
			}	
		}
	}
	
	public static void inOrder(Node node) {
		if(node == null)
			return;
		Stack<Node> st=new Stack<Node>();
		while (true) {
			if(node != null) {
				st.push(node);
				node = node.left;
			}else {
				if(st.isEmpty())
					break;
				node = st.pop();
				System.out.print(node.data+" ");
				node = node.right;
			}
		}
	}
	
	public static void postOrder(Node node) {
		if(node == null )
			return;
		Stack<Node> st =new Stack<Node>();
		Node current = node;
		while (current != null || !st.isEmpty()) {
			if(current != null) {
				st.push(current);
				current=current.left;
			}else {
				Node temp=st.peek().right;
				if(temp == null) {
					temp =st.pop();
					System.out.print(temp.data + " ");
					while(!st.isEmpty() && temp == st.peek().right) {
						temp=st.pop();
						System.out.print(temp.data + " ");
					}
				}else {
					current=temp;
				}	
			}
		}
	}

	// Print DFS using recursion
	public static void printPostorder(Node node)
	{
		if (node != null){
			printPostorder(node.left);
			printPostorder(node.right);
			System.out.print(node.data + " ");
		}
	}

	public static void printInorder(Node node)
	{
		if (node != null) {
			printInorder(node.left);
			System.out.print(node.data + " ");
			printInorder(node.right);
		}
	}

	public static void printPreorder(Node node)
	{
		if (node != null) {
			System.out.print(node.data + " ");
			printPreorder(node.left);
			printPreorder(node.right);
		}
	}
	
	
	public static void main(String[] args) {
		Node root=new Node(10);
		root.left=new Node(2);
		root.right=new Node(5);
		root.left.left=new Node(6);
		root.left.right=new Node(9);
		root.left.left.right=new Node(7);
		root.right.left=new Node(8);
		root.right.right=new Node(3);
		
		System.out.print("PreOrder traversal : ");
		preOrder(root);
		System.out.println();
		System.out.print("InOrder traversal : ");
		inOrder(root);
		System.out.println();
		System.out.print("PostOrder traversal : ");
		postOrder(root);

		System.out.println();
		System.out.print("PreOrder traversal using recursion : ");
		printPreorder(root);
		System.out.println();
		System.out.print("InOrder traversal using recursion : ");
		printInorder(root);
		System.out.println();
		System.out.print("PostOrder traversal using recursion : ");
		printPostorder(root);

	}

}
