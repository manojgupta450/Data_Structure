package creational.binaryTree.View;

import creational.binaryTree.Node;

public class _011RightViewOfBinaryTree {
    Node root;
    public static int max_level = 0;

    public _011RightViewOfBinaryTree() {
        root = null;
    }

    public void rightView(Node node, int level) {
		if (node == null) {
			return;
		}
        if (max_level < level) {
            System.out.println(node.data);
            max_level = level;
        }

        rightView(node.right, level + 1);
        rightView(node.left, level + 1);
    }

    public static void main(String[] args) {
        _011RightViewOfBinaryTree bt = new _011RightViewOfBinaryTree();
        bt.root = new Node(1);
        bt.root.left = new Node(2);
        bt.root.right = new Node(3);
        bt.root.left.left = new Node(4);
        bt.root.left.right = new Node(5);
        bt.root.right.left = new Node(6);
        bt.root.right.right = new Node(7);
        bt.root.right.left.right = new Node(8);

        bt.rightView(bt.root, 1);
    }

}
