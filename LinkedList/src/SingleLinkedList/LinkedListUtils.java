package SingleLinkedList;

public class LinkedListUtils {

    static ListNode head, current;

    public static void printNode(ListNode head) {
        ListNode cur = head;

        while(cur != null) {
            System.out.print(cur.data + " -> ");
            cur = cur.next;
        }

        System.out.println();
    }

    //Size of the List
    public static int size(ListNode head) {
        int count = 0;
        ListNode cur = head;

        while(cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }
}
