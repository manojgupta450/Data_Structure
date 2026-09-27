package SingleLinkedList;

public class _8SwapTwoNodesInLinkedList {
		ListNode head;
	
	//Add ndoe in a list
	public void add(ListNode newNode) {
		if(head==null) {
			head=newNode;
		}
		ListNode cur=head;
		ListNode pre=null;
		
		while(cur!=null) {
			pre=cur;
			cur=cur.next;
		}
		pre.next=newNode;
	}
	
	public void swapNode(int key1,int key2) {
		ListNode cur1=head,cur2=head;
		ListNode pre1=null,pre2=null;
		
		if(head==null)
			return;
		while(cur1!=null && cur1.data!=key1) {
			pre1=cur1;
			cur1=cur1.next;
		}
		while(cur2!=null && cur2.data!=key2) {
			pre2=cur2;
			cur2=cur2.next;
		}
		if(cur1==null || cur2==null)
			return;
		
		
		//if key1 is not in head
		if(pre1!=null)
		pre1.next=cur2;
		else
			head=cur2;
		
		//if key2 is not in head
		if(pre2!=null)
		pre2.next=cur1;
		else
			head=cur1;
		
		ListNode temp=cur1.next;
		cur1.next=cur2.next;
		cur2.next=temp;
		
	}
	
	public void printNode() {
		ListNode cur=head;
		while(cur!=null) {
			System.out.print(cur.data+ " --> ");
			cur=cur.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		_8SwapTwoNodesInLinkedList list=new _8SwapTwoNodesInLinkedList();
		list.head=new ListNode(10);
		list.add(new ListNode(50));
		list.add(new ListNode(60));
		list.add(new ListNode(70));
		list.add(new ListNode(80));
		list.add(new ListNode(90));
		
		list.printNode();
		list.swapNode(50,80);
		list.printNode();
	}

}
