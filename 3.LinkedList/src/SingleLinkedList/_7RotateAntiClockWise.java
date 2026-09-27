package SingleLinkedList;

import static java.util.Objects.isNull;

public class _7RotateAntiClockWise {

	static ListNode head, current;

	public static void add(ListNode newNode) {
		if (isNull(head)) {
			head = newNode;
			current = head;
			return;
		}

		current.next = newNode;
		current = current.next;
	}

	public void rotateAntiClockWise(int k) {
		ListNode cur=head;
		ListNode temp=null;
		int count=0;
		while(cur!=null && cur.next!=null ) {
			if(count < k-1) {
				cur=cur.next;
				count++;
				temp=cur;
			}else {
				cur=cur.next;
			}

		}
		cur.next=head;
		head=temp.next;
		temp.next=null;
	}

	//Size of the List
	public int size() {
		int count = 0;
		ListNode cur = head;
		while(cur != null) {
			cur = cur.next;
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		_7RotateAntiClockWise list=new _7RotateAntiClockWise();
		list.add(new ListNode(10));
		list.add(new ListNode(20));
		list.add(new ListNode(30));
		list.add(new ListNode(40));
		list.add(new ListNode(50));
		list.add(new ListNode(60));
		list.add(new ListNode(70));
		LinkedListUtils.printNode(head);
		list.rotateAntiClockWise(3);
		LinkedListUtils.printNode(head);
	}

}
