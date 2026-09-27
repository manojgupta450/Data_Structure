package MergeList;

public class MergeNSortedList {
	
	static ListNode mergeKList(ListNode []arr,int last){
		while (last != 0)
	    {
	        int i = 0, j = last;
	        while (i < j)
	        {
	            arr[i] = SortedMerge(arr[i], arr[j]);
	            i++; j--;
	            if (i >= j)
	                last = j;
	        }
	    }
	 
	    return arr[0];
	}
	
	private static ListNode SortedMerge(ListNode a, ListNode b) {
		ListNode result = null;
	    if (a == null)
	        return (b);
	    else if(b == null)
	        return (a);
	    if(a.data <= b.data){
	        result = a;
	        result.next = SortedMerge(a.next, b);
	    }else{
	        result = b;
	        result.next = SortedMerge(a, b.next);
	    }
	 
	    return result;
	}
	static void printList(ListNode node)
	{
	    while (node != null)
	    {
	        System.out.print(node.data+ " ");
	        node = node.next;
	    }
	}
	
	public static void main(String[] args) {
		int k=4;
		ListNode [] arr=new ListNode[k];
		
		arr[0]=new ListNode(1);
		arr[0].next=new ListNode(3);
		arr[0].next.next=new ListNode(5);
		arr[0].next.next.next=new ListNode(8);
		arr[0].next.next.next.next=new ListNode(23);
		
		arr[1]=new ListNode(2);
		arr[1].next=new ListNode(4);
		arr[1].next.next=new ListNode(7);
		arr[1].next.next.next=new ListNode(10);
		arr[1].next.next.next.next=new ListNode(13);
		
		arr[2]=new ListNode(6);
		arr[2].next=new ListNode(9);
		arr[2].next.next=new ListNode(11);
		arr[2].next.next.next=new ListNode(14);
		arr[2].next.next.next.next=new ListNode(15);
		
		arr[3]=new ListNode(12);
		arr[3].next=new ListNode(16);
		arr[3].next.next=new ListNode(19);
		arr[3].next.next.next=new ListNode(20);
		arr[3].next.next.next.next=new ListNode(22);
		
		ListNode head=mergeKList(arr,k-1);
		printList(head);
		

	}

}
