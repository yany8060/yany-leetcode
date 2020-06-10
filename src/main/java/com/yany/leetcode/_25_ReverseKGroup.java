package com.yany.leetcode;

import com.yany.model.ListNode;

/**
 * @author yanyong on 2020/6/10
 */
public class _25_ReverseKGroup {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        reverseKGroup(n1, 3);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode tail = new ListNode(-1);
        ListNode _tail = tail;
        while (head != null) {
            while (tail.next != null) {
                tail = tail.next;
            }
            head = reverseList(head, k, tail);
        }
        return _tail.next;
    }

    public static ListNode reverseList(ListNode head, int k, ListNode tail) {
        ListNode tmp = new ListNode(-1);

        ListNode headLen = head;
        for (int i = 0; i < k; i++) {
            if (headLen != null) {
                headLen = headLen.next;
            } else {
                tail.next = head;
                return null;
            }
        }

        while (head != null && k > 0) {
            ListNode nt = tmp.next;
            ListNode hdn = head.next;
            tmp.next = head;
            head.next = nt;
            head = hdn;
            k--;
        }
        tail.next = tmp.next;

        return head;
    }

}
