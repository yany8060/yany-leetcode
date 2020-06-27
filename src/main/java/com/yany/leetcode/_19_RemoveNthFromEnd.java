package com.yany.leetcode;

import com.yany.model.ListNode;

/**
 * @author yanyong on 2020/6/10
 */
public class _19_RemoveNthFromEnd {


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmp = new ListNode(-1);
        tmp.next = head;

        ListNode tail = head, before = head, parent = tmp;
        for (int i = 1; i < n; i++) {
            tail = tail.next;
        }
        while (tail.next != null) {
            tail = tail.next;
            before = before.next;
            parent = parent.next;
        }

        if (parent.next != null) {
            parent.next = parent.next.next;
        }
        return tmp.next;
    }

}
