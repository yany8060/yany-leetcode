package com.yany.leetcode;

import com.yany.leetcode.model.ListNode;

public class _143_ReorderList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        new _143_ReorderList().reorderList(l1);
    }

    public void reorderList(ListNode head) {
        if(head == null) {
            return;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode h = slow.next;

        slow.next = null;
        h = reverseList(h);

        ListNode tHd = head;
        while (tHd != null && h != null) {
            ListNode tmp = tHd.next;
            ListNode tmph = h.next;
            tHd.next = h;
            h.next = tmp;

            h = tmph;
            tHd = tmp;
        }

    }

    public ListNode reverseList(ListNode head) {
        ListNode thead = new ListNode(0);

        while (head != null) {
            ListNode tmp = head.next;
            ListNode ntmp = thead.next;

            thead.next = head;
            head.next = ntmp;
            head = tmp;
        }
        return thead.next;
    }

}
