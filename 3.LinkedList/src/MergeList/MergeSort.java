package MergeList;

public class MergeSort {
	Node head = null;

	Node sortedMerge(Node a, Node b) {
	Node result = null;
     if (a == null)
         return b;
     if (b == null)
         return a;
     /* Pick either a or b, and recur */
     if (a.data <= b.data) {
         result = a;
         result.next = sortedMerge(a.next, b);
     } 
     else{
         result = b;
         result.next = sortedMerge(a, b.next);
     }
     return result;

 }

	Node mergeSort(Node h) {
     if (h == null || h.next == null){
         return h;
     }

     Node middle = getMiddle(h);
     Node nextofmiddle = middle.next;

     middle.next = null;

     Node left = mergeSort(h);

     // Apply mergeSort on right list
     Node right = mergeSort(nextofmiddle);

     // Merge the left and right lists
     Node sortedlist = sortedMerge(left, right);
     return sortedlist;
 }

	Node getMiddle(Node h) {
     if (h == null)
         return h;
     Node fastptr = h.next;
     Node slowptr = h;
     while (fastptr != null){
         fastptr = fastptr.next;
         if(fastptr!=null){
             slowptr = slowptr.next;
             fastptr=fastptr.next;
         }
     }
     return slowptr;
 }

/* void push(int new_data) {
     Node new_node = new Node(new_data);
     new_node.next = head;
     head = new_node;
 }
*/
 void printList(Node headref) {
     while (headref != null) {
         System.out.print(headref.data + " ");
         headref = headref.next;
     }
 }
  
 public static void main(String[] args) {

     MergeSort li = new MergeSort();
     li.head=new Node(1);
     li.head.next=new Node(15);
     li.head.next.next=new Node(10);
     li.head.next.next.next=new Node(5);
     li.head.next.next.next.next=new Node(20);
     li.head.next.next.next.next.next=new Node(3);
     li.head.next.next.next.next.next.next=new Node(2);
     System.out.println("Linked List without sorting is :");
     li.printList(li.head);
     li.head = li.mergeSort(li.head);
     System.out.print("\n Sorted Linked List is: \n");
     li.printList(li.head);
 }
}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}
 