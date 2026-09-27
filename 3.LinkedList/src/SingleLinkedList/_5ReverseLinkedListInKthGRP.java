package SingleLinkedList;

import static java.util.Objects.isNull;

public class _5ReverseLinkedListInKthGRP {
	static ListNode head, current;

	//Reverse linked List in group of k using recursion
	public ListNode reverseInKthGRP(ListNode listNode, int k) {
		ListNode cur = listNode, pre = null, nxt = null;
		int count = 0;

		while(cur != null && count < k) {
			nxt = cur.next;
			cur.next = pre;
			pre = cur;
			cur = nxt;
			count++;
		}

		if(nxt != null) {
			listNode.next = reverseInKthGRP(nxt, k);
		}

		return pre;
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
		_5ReverseLinkedListInKthGRP list=new _5ReverseLinkedListInKthGRP();
		list.add(new ListNode(10));
		list.add(new ListNode(20));
		list.add(new ListNode(30));
		list.add(new ListNode(40));
		list.add(new ListNode(50));
		list.add(new ListNode(60));
		list.add(new ListNode(70));

		LinkedListUtils.printNode(head);
		head = list.reverseInKthGRP(head, 3);
		System.out.println("Reversed ");
		LinkedListUtils.printNode(head);
	}
}
