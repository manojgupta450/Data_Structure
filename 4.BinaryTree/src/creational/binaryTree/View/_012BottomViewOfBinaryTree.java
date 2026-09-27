package creational.binaryTree.View;

import java.util.*;
import java.util.Map.Entry;

import creational.binaryTree.QNode;

public class _012BottomViewOfBinaryTree
{
	public void bottomView(QNode root)
	{
		if (root == null)
			return;

		// Initialize a variable 'hd' with 0 for the root element.
		int hd = 0;

		// TreeMap which stores key value pair sorted on key value
		Map<Integer, Integer> map = new TreeMap<>();

		// Queue to store tree nodes in level order traversal
		Queue<QNode> queue = new LinkedList<QNode>();

		// Assign initialized horizontal distance value to root
		// node and add it to the queue.
		root.hd = hd;
		queue.add(root);

		// Loop until the queue is empty (standard level order loop)
		while (!queue.isEmpty())
		{
			QNode temp = queue.remove();

			// Extract the horizontal distance value from the
			// dequeued tree node.
			hd = temp.hd;

			// Put the dequeued tree node to TreeMap having key
			// as horizontal distance. Every time we find a node
			// having same horizontal distance we need to replace
			// the data in the map.
			map.put(hd, temp.data);

			// If the dequeued node has a left child add it to the
			// queue with a horizontal distance hd-1.
			if (temp.left != null)
			{
				temp.left.hd = hd-1;
				queue.add(temp.left);
			}
			// If the dequeued node has a right child add it to the
			// queue with a horizontal distance hd+1.
			if (temp.right != null)
			{
				temp.right.hd = hd+1;
				queue.add(temp.right);
			}
		}

		Iterator<Entry<Integer, Integer>> it = map.entrySet().iterator();
		while (it.hasNext())
		{
			Map.Entry<Integer, Integer> me = it.next();
			System.out.print(me.getValue()+" ");
		}
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
		System.out.println("Bottom view of the given binary tree:");
		new _012BottomViewOfBinaryTree().bottomView(root);
	}
}


