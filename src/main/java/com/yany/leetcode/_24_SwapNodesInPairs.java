package com.yany.leetcode;

import com.yany.leetcode.model.ListNode;

public class _24_SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode retNode = new ListNode(0);
        retNode.next = head;


        ListNode hNode = new ListNode(0);
        ListNode first = head;
        ListNode second = head.next;
        hNode.next = first;


        while (second != null) {
            hNode.next = second;
            ListNode tmp = second.next;
            second.next = first;
            first.next = tmp;

            hNode = second;
            first = first.next.next;
            second = second.next.next;
        }
        return retNode.next;
    }
}
