package com.manu.Array;

import java.math.BigInteger;

public class Test4 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);
        l2.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next .next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next.next.next = new ListNode(1);
        System.out.println(new Solution().addTwoNumbers(l1,l2));
    }
}

class Solution {
    ListNode head;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String str1 = "";
        String str2 = "";
        while (l1 != null) {
            str1 = l1.val + str1;
            l1 = l1.next;
        }
        while (l2 != null) {
            str2 = l2.val + str2;
            l2 = l2.next;
        }
        System.out.println(str1);
        System.out.println(str2);
        int intVal = Integer.valueOf(str1) + Integer.valueOf(str2);

        BigInteger intValB = new BigInteger(str1).add(new BigInteger(str2));
        String str = intValB.toString();
        System.out.println(str);
        //ListNode newNode = new ListNode(Integer.valueOf(String.valueOf(str.charAt(str.length()-1))));
        //ListNode curr = new ListNode();
        for (int i = str.length()-1; i >= 0; i--) {
            add(new ListNode(Integer.valueOf(String.valueOf(str.charAt(i)))));
        }

        return head;
    }
    public void add(ListNode newNode) {
        if(head == null) {
            head=newNode;
        }
        ListNode cur=head;
        ListNode pre=null;

        while(cur!=null) {
            pre=cur;
            cur=cur.next;
        }
        pre.next=newNode;
        pre.next.next = null;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}