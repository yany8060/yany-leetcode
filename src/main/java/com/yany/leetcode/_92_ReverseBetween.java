package com.yany.leetcode;

import com.yany.model.ListNode;

import java.util.HashMap;
import java.util.Map;

public class _92_ReverseBetween {


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(4);
        ListNode d = new ListNode(5);
        head.next = a;
        a.next = b;
        b.next = c;
        c.next = d;

        System.out.println();

        reverseBetween(head, 2, 4);


    }

    /**
     * 头插法逆置链表
     *
     * @param head
     * @param left
     * @param right
     * @return ListNode
     */
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode pre = dummyHead;

        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;

        for (int i = left; i < right; i++) {
            ListNode tmp = cur.next;

            cur.next = tmp.next;
            tmp.next = pre.next;
            pre.next = tmp;
        }


        return dummyHead.next;
    }
}
