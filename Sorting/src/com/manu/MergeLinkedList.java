package com.manu;

public class MergeLinkedList {
	static Node head;
	
	public static void main(String[] args) {
		  Node node1 = new Node(10);
		  Node node2 = new Node(1);
		  Node node3 = new Node(-2);
		  Node node4 = new Node(8);
		  Node node5 = new Node(9);
		  Node node6 = new Node(10);
		  Node node7 = new Node(1);
		 
		  node1.next=node2;
		  node2.next=node3;
		  node3.next=node4;
		  node4.next=node5;
		  node5.next=node6;
		  node6.next=node7;
		  head = node1;
		   
		  Node sortedStartNode = merge_sort(head);
		  printLinkList(sortedStartNode);
	}

	private static void printLinkList(Node sortedStartNode) {
		
		
	}

	//The main function
	public static Node merge_sort(Node head) {
	    if(head == null || head.next == null) { return head; }
	    Node middle = getMiddle(head);      //get the middle of the list
	    Node nextOfMiddle = middle.next; middle.next = null;   //split the list into two halfs

	    return merge(merge_sort(head),merge_sort(nextOfMiddle));  //recurse on that
	}

	//Merge subroutine to merge two sorted lists
	public static Node merge(Node a, Node b) {
	    Node dummyHead= new Node(), curr = dummyHead;
	    while(a !=null && b!= null) {
	        if(a.data <= b.data) { curr.next = a; a = a.next; }
	        else { curr.next = b; b = b.next; }
	        curr = curr.next;
	    }
	    curr.next = (a == null) ? b : a;
	    return dummyHead.next;
	}

	//Finding the middle element of the list for splitting
	public static Node getMiddle(Node head) {
	    if(head == null) { return head; }
	    Node slow, fast; slow = fast = head;
	    while(fast.next != null && fast.next.next != null) {
	        slow = slow.next; fast = fast.next.next;
	    }
	    return slow;
	}
}
