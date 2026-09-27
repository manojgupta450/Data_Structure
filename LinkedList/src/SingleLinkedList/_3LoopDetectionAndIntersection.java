package SingleLinkedList;

import static java.util.Objects.isNull;

public class _3LoopDetectionAndIntersection {
	ListNode head, current;
	
	//Two pointers (slow and fast) can meet anywhere in the loop
	public boolean detectLoop() {
		ListNode fast = head, slow = head;
		while(slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				return true;
			}
		}
		return false;
	}
	
	//Intersection point of the loop 
	public ListNode findIntersectionPoint() {
		ListNode fast = head, slow = head;
			while(slow != null && fast != null && fast.next != null) {
				slow = slow.next;
				fast = fast.next.next;
				if(slow == fast) {
					fast = head;
					while(fast != slow) {
						fast = fast.next;
						slow = slow.next;
					}
					return slow;
				}
			}
			return head;
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
		_3LoopDetectionAndIntersection list = new _3LoopDetectionAndIntersection();
		list.add(new ListNode(10));
		list.add(new ListNode(20));
		list.add(new ListNode(30));
		list.add(new ListNode(40));
		list.add(new ListNode(50));

		list.head.next.next.next.next.next = list.head.next;

		System.out.println("Is list having loop : " + list.detectLoop());
		System.out.println("Intersection of the loop : " + list.findIntersectionPoint().data);
	}

}
