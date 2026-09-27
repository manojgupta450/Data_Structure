package creational.binaryTree.Traversals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

import creational.binaryTree.Node;

public class Test {

    public static void main(String[] args) {
        Node root=new Node(10);
        root.left=new Node(2);
        root.right=new Node(5);
        root.left.left=new Node(6);
        root.left.right=new Node(9);
        root.left.left.right=new Node(7);
        root.right.left=new Node(8);
        root.right.right=new Node(3);
        System.out.print("InOrder traversal using recursion: ");
        inOrder(root);

        System.out.println();
        System.out.print("PreOrder traversal using recursion: ");
        preOrder(root);

        System.out.println();
        System.out.print("PostOrder traversal using recursion: ");
        postOrder(root);

        System.out.println();
        System.out.print("InOrder traversal using iteration: ");
        inOrderIt(root);

        System.out.println();
        System.out.print("PreOrder traversal using iteration: ");
        preOrderIt(root);

        System.out.println();
        System.out.print("PostOrder traversal using iteration: ");
        postOrderIt(root);


        System.out.println("diagonalPrint :");
        Node root1 = new Node(8);
        root1.left = new Node(3);
        root1.right = new Node(10);
        root1.left.left = new Node(1);
        root1.left.right = new Node(6);
        root1.right.right = new Node(14);
        root1.right.right.left = new Node(13);
        root1.left.right.left = new Node(4);
        root1.left.right.right = new Node(7);
        diagonalPrint(root1);


        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.left.right = new Node(5);
        root2.right.left = new Node(6);
        root2.right.right = new Node(7);
        root2.right.left.right = new Node(8);
        root2.right.right.right = new Node(9);
        System.out.println("Vertical Order traversal is");
        printVerticalOrder(root2);

    }

    private static void printVerticalOrder(final Node node) {
        if (node == null) return;
        Map<Integer, List<Integer>> map = new TreeMap<>();
        vertical(node, 0, map);

        Iterator<Map.Entry<Integer, List<Integer>>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer,List<Integer>> entry = it.next();
            System.out.println(entry.getValue() + " ");
        }

    }

    private static void vertical(Node node, int d, Map<Integer, List<Integer>> map) {
        if (node == null) return;

        List<Integer> list = map.get(d);

        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(node.data);
        map.put(d, list);

        vertical(node.left, d-1, map);
        vertical(node.right, d+1, map);
    }

    private static void diagonalPrint(final Node node) {
        if (node == null) return;
        Map<Integer, List<Integer>> map = new HashMap<>();
        diagonal(node, 0, map);

        Iterator<Map.Entry<Integer, List<Integer>>> it = map.entrySet().iterator();
        while (it.hasNext()) {
           Map.Entry<Integer,List<Integer>> entry = it.next();
            System.out.println(entry.getValue() + " ");
        }

    }

    private static void diagonal(Node node, int d, Map<Integer, List<Integer>> map) {
        if (node == null) return;

        List<Integer> list = map.get(d);

        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(node.data);
        map.put(d, list);

        diagonal(node.left, d+1, map);
        diagonal(node.right, d, map);
    }

    private static void postOrderIt(final Node node) {
        if (node == null) return;

        Stack<Node> st = new Stack<>();
        Node current = node;

        while (current != null || !st.isEmpty()) {

            if (current != null) {
                st.add(current);
                current = current.left;
            } else {
                Node tempNode = st.peek().right;

                if (tempNode == null) {
                    tempNode = st.pop();
                    System.out.print(tempNode.data + " ");
                    while (!st.isEmpty() && tempNode == st.peek().right) {
                        tempNode = st.pop();
                        System.out.print(tempNode.data + " ");
                    }

                } else {
                    current = tempNode;
                }
            }
        }

    }

    // root,left,right
    private static void preOrderIt(final Node node) {
        if (node == null) return;

        Stack<Node> st = new Stack<>();
        st.add(node);

        while (!st.isEmpty()) {
            Node tempNode = st.pop();
            System.out.print(tempNode.data + " ");

            if (tempNode.right != null) {
                st.add(tempNode.right);
            }

            if (tempNode.left != null) {
                st.add(tempNode.left);
            }
        }

    }

    private static void inOrderIt(Node node) {
        if (node == null) return;
        Stack<Node> st = new Stack<>();
        while (true) {
            if (node != null) {
                st.push(node);
                node = node.left;
            } else {
                if (st.isEmpty()) break;
                node = st.pop();
                System.out.print(node.data + " ");
                node = node.right;
            }
        }
    }


    private static void postOrder(final Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    private static void preOrder(final Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    private static void inOrder(final Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }


}
