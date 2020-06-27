package com.yany.leetcode;

import com.yany.model.ListNode;

/**
 * @author yanyong on 2020/5/12
 */
public class _61_RotateList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        //l1.next = l2;
        //l2.next = l3;

        new _61_RotateList().rotateRight(l1, 3);

    }

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null) return null;
        if (head.next == null) return head;

        // close the linked list into the ring
        ListNode old_tail = head;
        int n;
        for (n = 1; old_tail.next != null; n++)
            old_tail = old_tail.next;
        old_tail.next = head;

        ListNode new_tail = head;
        for (int i = 0; i < n - k % n - 1; i++)
            new_tail = new_tail.next;
        ListNode new_head = new_tail.next;

        // break the ring
        new_tail.next = null;

        return new_head;
    }

    public ListNode rotateRight2(ListNode head, int k) {
        if (head == null) {
            return null;
        }


        ListNode tmp = head;
        int len = 0;
        while (tmp != null) {
            len++;
            tmp = tmp.next;
        }
        if (k > len) {
            k = k % len;
        }
        if (k == len || k == 0) {
            return head;
        }

        ListNode l = head, r = head;
        for (int i = 1; i <= k; i++) {
            r = r.next;
        }

        ListNode lP = new ListNode(-1);
        ListNode rP = new ListNode(-1);
        while (r != null) {
            lP = l;
            rP = r;
            l = l.next;
            r = r.next;
        }
        lP.next = null;
        ListNode start = new ListNode(-1);
        start.next = l;
        rP.next = head;

        return start.next;
    }

}
