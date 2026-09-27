package SingleLinkedList;

import static java.util.Objects.isNull;

public class _6RotateClockWise {
	static ListNode head, current;

	public void rotateClockWise(int k) {
		ListNode cur = head;
		ListNode temp = null;
		int count = 0;
		if(k == 0)
			return;

		int size = LinkedListUtils.size(head);
		k = k % size;
		while(cur != null && cur.next != null) {
			if(count < size-k-1) {
				cur = cur.next;
				count++;
				temp = cur;
			}else {
				cur = cur.next;
			}
		}
		cur.next = head;
		head = temp.next;
		temp.next = null;
	}

	public static void add(ListNode newNode) {
		if (isNull(head)) {
			head = newNode;
			current = head;
			return;
		}

		current.next = newNode;
		current = current.next;
	}

	public static void main(String[] args) {
		_6RotateClockWise list=new _6RotateClockWise();
		list.add(new ListNode(10));
		list.add(new ListNode(20));
		list.add(new ListNode(30));
		list.add(new ListNode(40));
		list.add(new ListNode(50));
		list.add(new ListNode(60));
		list.add(new ListNode(70));
		LinkedListUtils.printNode(head);
		list.rotateClockWise(10);
		LinkedListUtils.printNode(head);
	}
}
