package creational.binaryTree.SumOf;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import creational.binaryTree.QNode;

public class _013VSumOfTopViewInBinaryTree {

	public _013VSumOfTopViewInBinaryTree() {}

	int hd = 0;

	public int printTopView(QNode root) {
		if (root == null) return 0;

		Map<Integer, Integer> map = new TreeMap<>();
		Queue<QNode> queue = new LinkedList<>();

		root.hd = hd;
		queue.add(root);

		while (!queue.isEmpty()) {
			QNode tempQ = queue.poll();
			hd =  tempQ.hd;
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

		int sum = 0;
		Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry entry = it.next();
			System.out.println(entry.getValue() + " ");
			sum += Integer.parseInt(entry.getValue().toString());
		}

		return sum;
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
		System.out.println("Sum of Top view of the given binary tree: " + new _013VSumOfTopViewInBinaryTree().printTopView(root));

	}
}
