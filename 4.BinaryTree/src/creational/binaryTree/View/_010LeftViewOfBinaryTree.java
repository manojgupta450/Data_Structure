package creational.binaryTree.View;

import creational.binaryTree.Node;

public class _010LeftViewOfBinaryTree {
    Node root;
    public static int max_level = 0;

    public _010LeftViewOfBinaryTree() {
        root = null;
    }

    public void leftView(Node node, int level) {
		if (node == null) {
			return;
		}
        if (max_level < level) {
            System.out.println(node.data);
            max_level = level;
        }

        leftView(node.left, level + 1);
        leftView(node.right, level + 1);
    }

    public static void main(String[] args) {
        _010LeftViewOfBinaryTree bt = new _010LeftViewOfBinaryTree();
        bt.root = new Node(4);
        bt.root.left = new Node(5);
        bt.root.right = new Node(2);
        bt.root.right.left = new Node(3);
        bt.root.right.right = new Node(1);
        bt.root.right.left.left = new Node(6);
        bt.root.right.left.right = new Node(7);
        bt.leftView(bt.root, 1);
    }

}
