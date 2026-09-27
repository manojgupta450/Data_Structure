package creational.binaryTree.SumOf;

import creational.binaryTree.Node;

public class _010SumOfLeftViewInBinaryTree {

    int MAX_LEVEL = 0;
    int sum = 0;

    public int sumOfLeftViewNodes(Node root, int level) {
        if (root == null) return 0;

        if (MAX_LEVEL < level) {
            sum += root.data;
            System.out.println(root.data + " ");
            MAX_LEVEL = level;
        }
        sumOfLeftViewNodes(root.left, level+1);
        sumOfLeftViewNodes(root.right, level+1);

        return sum;
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(5);
        root.right = new Node(2);
        root.right.left = new Node(3);
        root.right.right = new Node(1);
        root.right.left.left = new Node(6);
        root.right.left.right = new Node(7);
        System.out.println("Sum of left view nodes " + new _010SumOfLeftViewInBinaryTree().sumOfLeftViewNodes(root, 1));

    }
}
