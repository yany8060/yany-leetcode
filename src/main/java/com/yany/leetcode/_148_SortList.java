package com.yany.leetcode;

import com.yany.model.ListNode;

public class _148_SortList {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(3);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        new _148_SortList().sortList(n1);
    }

    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode hNode = new ListNode(0);
        hNode.next = head;
        while (head.next != null) {
            ListNode n = head.next;
            if (n.val < head.val) {
                ListNode ptmp = hNode;
                ListNode tmp = ptmp.next;
                while (n.val > tmp.val) {
                    ptmp = tmp;
                    tmp = tmp.next;
                }

                head.next = n.next;
                ptmp.next = n;
                n.next = tmp;
            } else {
                head = head.next;
            }
        }
        return hNode.next;
    }

    public ListNode mergeSortList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);

        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }

        h.next = left == null ? right : left;
        return res.next;
    }

}
