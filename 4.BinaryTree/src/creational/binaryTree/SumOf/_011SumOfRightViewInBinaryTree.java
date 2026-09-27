package creational.binaryTree.SumOf;

import creational.binaryTree.Node;

public class _011SumOfRightViewInBinaryTree {

    int MAX_LEVEL = 0;
    int sum = 0;

    public int sumOfRightViewNodes(Node root, int level) {
        if (root == null) return 0;

        if (MAX_LEVEL < level) {
            sum += root.data;
            System.out.println(root.data + " ");
            MAX_LEVEL = level;
        }
        sumOfRightViewNodes(root.right, level+1);
        sumOfRightViewNodes(root.left, level+1);

        return sum;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        System.out.println("Sum of right view nodes " + new _011SumOfRightViewInBinaryTree().sumOfRightViewNodes(root, 1));

    }
}
