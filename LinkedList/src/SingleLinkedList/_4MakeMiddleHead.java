package SingleLinkedList;

import static java.util.Objects.isNull;

public class _4MakeMiddleHead {
	static ListNode head, current;

	public void makeMiddleHead() {
		ListNode cur = head, mid = head, pre = null;

		if(head == null)
			return;
		while(cur != null) {
			pre = mid;
			mid = mid.next;
			cur = cur.next.next;
		}
		pre.next = mid.next;
		mid.next = head;
		head = mid;
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
		_4MakeMiddleHead list=new _4MakeMiddleHead();
		list.add(new ListNode(10));
		list.add(new ListNode(50));
		list.add(new ListNode(60));
		list.add(new ListNode(70));
		list.add(new ListNode(80));
		list.add(new ListNode(90));
		
		LinkedListUtils.printNode(head);
		list.makeMiddleHead();
		LinkedListUtils.printNode(head);
	}
}
