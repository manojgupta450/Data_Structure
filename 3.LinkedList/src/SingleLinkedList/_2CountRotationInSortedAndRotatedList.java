package SingleLinkedList;

import static java.util.Objects.isNull;

public class _2CountRotationInSortedAndRotatedList {
	static ListNode head, current;

	public int findNoOfRotation() {
		if (head == null) {
			return 0;
		}

		ListNode cur = head;
		int count = 1;

		while (cur.next != null && cur.data <= cur.next.data) {
			count++;
			cur = cur.next;
		}
		return count;
	}

	public void add(ListNode newNode) {
		if (isNull(head)) {
			head = newNode;
			current = head;
			return;
		}

		current.next = newNode;
		current = current.next;
	}

	public static void main(String[] args) {
		_2CountRotationInSortedAndRotatedList list=new _2CountRotationInSortedAndRotatedList();
		list.add(new ListNode(15));
		list.add(new ListNode(16));
		list.add(new ListNode(18));
		list.add(new ListNode(5));
		list.add(new ListNode(8));
		list.add(new ListNode(11));
		list.add(new ListNode(12));
		
		LinkedListUtils.printNode(head);
		System.out.println("No of rotation "+ list.findNoOfRotation());
		LinkedListUtils.printNode(head);
	}

}
