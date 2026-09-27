package creational.binaryTree.View;

import java.util.*;

import creational.binaryTree.QNode;

public class _013TopViewBinaryTree {

	public _013TopViewBinaryTree() {}

	public void printTopView(QNode root) {
		if (root == null) return;

		int hd = 0;
		Map<Integer, Integer> map = new TreeMap<>();
		Queue<QNode> queue = new LinkedList<>();
		root.hd = hd;
		queue.add(root);

		while (!queue.isEmpty()) {
			QNode tempQ = queue.poll();
			hd = tempQ.hd;

			if (!map.containsKey(hd)) {
				map.put(hd, tempQ.data);
			}

			if (tempQ.left != null) {
				tempQ.left.hd = hd - 1;
				queue.add(tempQ.left);
			}

			if (tempQ.right != null) {
				tempQ.right.hd = hd + 1;
				queue.add(tempQ.right);
			}
		}

		Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Integer, Integer> e = it.next();
			System.out.println(e.getValue() + " ");
		}
	}

	public static void main(String[] args)
	{
		QNode root = new QNode(1);
		root.left = new QNode(2);
		root.right = new QNode(3);
		root.left.left = new QNode(4);
		root.left.right = new QNode(5);
		root.right.left = new QNode(6);
		root.right.right = new QNode(7);
		System.out.println("Top view of the given binary tree:");
		new _013TopViewBinaryTree().printTopView(root);

	}
}
