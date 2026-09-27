package SingleLinkedList;

import static java.util.Objects.isNull;

public class _1LinkedList {
	static ListNode head, current;

	public static void insert(ListNode newNode) {
		if (isNull(head)) {
			head = newNode;
			current = head;
			return;
		}

		current.next = newNode;
		current = current.next;
	}

	public void insertAtFront(ListNode newNode) {
		if (isNull(head)) {
			head = newNode;
			return;
		}

		newNode.next = head;
		head = newNode;
	}

	public void insertNodeAtTheEnd(ListNode newNode) {
		if (isNull(head)) {
			head = newNode;
			return;
		}

		ListNode curr = head;

		while(curr.next != null) {
			curr = curr.next;
		}

		curr.next = newNode;
	}

	public void insertAtGivenPosition(ListNode newNode, int pos) {
		ListNode cur = head;
		int count=1;
		if(head==null)
			return;
		int size = LinkedListUtils.size(head);
		while(cur!=null && count < pos && pos <= size) {
			cur=cur.next;
			count++;
		}
		newNode.next=cur.next;
		cur.next=newNode;
	}

	public void insertAtGivenP(ListNode newNode, int p) {
		if (head == null) {
			return;
		}
		int count = 1;
		ListNode curr = head;
		while (curr != null && count < p) {
			curr = curr.next;
			count++;
		}

		if (curr != null) {
			newNode.next = curr.next;
			curr.next = newNode;
		}
	}

	public void insertAtGivenPUsingTwoPointers(ListNode newNode, int p) {
		if (head == null) {
			return;
		}

		int count = 1;
		ListNode curr = head;
		ListNode prev = null;

		while (curr.next != null && count < p) {
			prev = curr;
			curr = curr.next;
			count++;
		}

		if (curr.next != null) {
			prev.next = newNode;
			newNode.next = curr;
		}
	}

	public void deleteFirstNode() {
		if (head == null) {
			return;
		}

		ListNode cur = head;
		ListNode pre;

		pre = cur;
		cur = cur.next;
		head = cur;

		pre.next = null;
	}

	public void deleteLastNode() {
		if (head == null) {
			return;
		}
		ListNode cur = head;
		ListNode pre = null;

		while (cur.next != null) {
			pre = cur;
			cur = cur.next;
		}

		pre.next = null;
	}

	public void deleteNode(int key) {
		if (head == null) {
			return;
		}

		ListNode cur = head;
		ListNode pre = null;

		if( cur != null && cur.data == key) {
			head = cur.next;
			cur.next = null;
			return;
		}
		while(cur != null && cur.data != key) {
			pre = cur;
			cur = cur.next;
		}
		pre.next = cur.next;
		cur.next = null;
	}

	public void deleteNodeAtGivenPos(int pos) {
		ListNode cur=head;
		ListNode pre=null;
		int count=1;
		int size = LinkedListUtils.size(head);

		while (cur != null && count <= pos && pos <= size) {
			pre = cur;
			cur = cur.next;
			count++;
		}

		pre.next = cur.next;
		cur.next = null;
	}

	public void deleteNodeAtGivenP(int pos) {
		if (head == null) {
			return;
		}

		ListNode cur = head;
		ListNode pre = null;
		int count = 1;

		while (cur != null &&  count <= pos) {
			pre = cur;
			cur = cur.next;
			count++;
		}

		if (cur == null && count >= pos) {
			return;
		}
		pre.next = cur.next;
		cur.next = null;
	}
	
	//Swap 2 elements
	public void swapNodes(int x, int y)
	{
		// Nothing to do if x and y are same
		if (x == y) return;

		// Search for x (keep track of prevX and CurrX)
		ListNode prevX = null, currX = head;
		while (currX != null && currX.data != x)
		{
			prevX = currX;
			currX = currX.next;
		}

		// Search for y (keep track of prevY and currY)
		ListNode prevY = null, currY = head;
		while (currY != null && currY.data != y)
		{
			prevY = currY;
			currY = currY.next;
		}

		// If either x or y is not present, nothing to do
		if (currX == null || currY == null)
			return;

		// If x is not head of linked list
		if (prevX != null)
			prevX.next = currY;
		else //make y the new head
			head = currY;

		// If y is not head of linked list
		if (prevY != null)
			prevY.next = currX;
		else // make x the new head
			head = currX;

		// Swap next pointers
		ListNode temp = currX.next;
		currX.next = currY.next;
		currY.next = temp;
	}
	
	//Search an element in a linkedList
	public boolean search(int key) {
		ListNode cur = head;   
        while (cur != null)
        {
            if (cur.data == key)
                return true;    
            cur = cur.next;
        }
        return false;    
	}
	
	//Get nth node 
	public int getNth(int nodeP) {
		ListNode cur=head;
		int count=0;
		if(cur==null)
			return 0;
		while(cur!=null && count < nodeP){
			cur=cur.next;
			count++;
		}
		return cur.data;
	}
	
	//getNth Node From END
	public int getNthNodeFromEND(int k) {
		ListNode main=head;
		ListNode ref=head;
		int count=0;
		if(head==null)
			return 0;
		while(ref!=null) {
			if(count < k) {
				count++;
				ref=ref.next;
			}else {
				main=main.next;
				ref=ref.next;
			}
		}
		return main.data;
	}
	
	
	//Print middle of the linked list
	public int printMiddle() {
		ListNode fast=head;
		ListNode slow=head;
		
		if(head==null)
			return 0;
		while(fast!=null && fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow.data;
	}
	
	
	//Delete list
	public void deleteList() {
		head=null;
	}
	
	
	//Count number of occurrence of a given key in a linked list
	public int countNoOfOccurrence(int key) {
		ListNode cur=head;
		int count =0;
		if(head==null)
			return 0;
		while(cur!= null) {
			if(cur.data == key)
			count++;
			cur=cur.next;
		}
		return count;
	}
	
	//Reverse a linked list
	public void reverse() {
		ListNode cur=head;
		ListNode pre=null;
		ListNode nxt=null;
		if(head==null)
			return;
		while(cur!=null) {
			nxt=cur.next;
			cur.next=pre;
			pre=cur;
			cur=nxt;
			
		}
		head=pre;
	}

	public static void main(String[] args) {
		_1LinkedList list = new _1LinkedList();
		list.insert(new ListNode(10));
		list.insert(new ListNode(50));
		list.insert(new ListNode(60));
		list.insert(new ListNode(70));
		list.insert(new ListNode(80));
		list.insert(new ListNode(90));
		System.out.println("Initial node");
		LinkedListUtils.printNode(head);
		//1.Insert node at the front
		list.insertAtFront(new ListNode(20));
		System.out.println("Node 20 added at the front");
		LinkedListUtils.printNode(head);
		//2.Insert node at the end
		list.insertNodeAtTheEnd(new ListNode(30));
		System.out.println("Node 30 added at the End");
		LinkedListUtils.printNode(head);
		//3.Insert node
		//list.insertAtGivenPosition(new ListNode(5),2);//index start from zero
		list.insertAtGivenPUsingTwoPointers(new ListNode(5),2);
		System.out.println("Node 5 added at the 2nd index position");
		LinkedListUtils.printNode(head);
		
		//1.Delete node at front 
		list.deleteFirstNode();//index start from zero
		System.out.println("Node 20 will be deleted from first position");
		LinkedListUtils.printNode(head);
		
		//2.Delete node at last position
		list.deleteLastNode();//index start from zero
		System.out.println("Node 30 will be deleted from last position");
		LinkedListUtils.printNode(head);

		//3.Delete node for a given key
		list.deleteNode(5);//index start from zero
		System.out.println("Node 5 will be deleted");
		LinkedListUtils.printNode(head);
		
		//3.Delete node for a given position
		list.deleteNodeAtGivenPos(2);//index start from zero
		//list.deleteNodeAtGivenP(9);
		System.out.println("Node 60 will be deleted in index position 2");
		LinkedListUtils.printNode(head);
		
		System.out.println("Size of the list "+ LinkedListUtils.size(head));
		
		System.out.println("Key found "+ list.search(50));
		
		list.swapNodes(10, 80);
		LinkedListUtils.printNode(head);
		
		System.out.println("Get Nth node "+ list.getNth(2));
		
		System.out.println("Middle Node data " + list.printMiddle());
		
		System.out.println( "Nth node from End " + list.getNthNodeFromEND(4));
		
		//Delete list
		/*list.printNode();
		list.deleteList();
		System.out.println("List deleted");
		list.printNode();*/
		
		list.insert(new ListNode(10));
		LinkedListUtils.printNode(head);
		System.out.println("Number of occurrence of (10) is :" + list.countNoOfOccurrence(10) );
		LinkedListUtils.printNode(head);
		System.out.println("Reversed list");
		list.reverse();
		LinkedListUtils.printNode(head);
	}

}
