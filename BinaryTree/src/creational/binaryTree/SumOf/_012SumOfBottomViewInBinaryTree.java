package creational.binaryTree.SumOf;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import creational.binaryTree.QNode;

public class _012SumOfBottomViewInBinaryTree
{
	int hd = 0;

	public int sumOfBottomView(QNode root) {
		if (root == null) return 0;

		Map<Integer, Integer> map = new TreeMap<>();
		Queue<QNode> queue = new LinkedList<>();

		root.hd = hd;
		queue.add(root);

		while (!queue.isEmpty()) {
			QNode tempQ = queue.poll();
			hd = tempQ.hd;
			map.put(hd, tempQ.data);

			if (tempQ.left != null) {
				tempQ.left.hd = hd -1;
				queue.add(tempQ.left);
			}

			if (tempQ.right != null) {
				tempQ.right.hd = hd + 1;
				queue.add(tempQ.right);
			}
		}

		Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
		int sum = 0;
		while (it.hasNext()) {
			Map.Entry entry = it.next();
			sum += Integer.parseInt(entry.getValue().toString());
			System.out.println(entry.getValue() + " ");
		}
		return sum;
	}

	public static void main(String[] args)
	{
		QNode root = new QNode(20);
		root.left = new QNode(8);
		root.right = new QNode(22);
		root.left.left = new QNode(5);
		root.left.right = new QNode(3);
		root.right.left = new QNode(4);
		root.right.right = new QNode(25);
		root.left.right.left = new QNode(10);
		root.left.right.right = new QNode(14);
		System.out.println("Sum of Bottom view in the given binary tree: " + new _012SumOfBottomViewInBinaryTree().sumOfBottomView(root));

	}
}


