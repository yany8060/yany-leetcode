package com.yany.leetcode;

import com.yany.model.ListNode;

/**
 * @author yanyong on 2020/6/10
 */
public class _24_SwapNodesInPairs {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        swapPairs2(n1);
    }


    public static ListNode swapPairs2(ListNode head) {

        ListNode tail = new ListNode(-1);
        tail.next = head;
        ListNode _tail = tail;
        while (head != null && head.next != null) {
            ListNode tmp = head.next.next;
            tail.next = head.next;
            head.next = null;

            tail = tail.next;
            tail.next = head;

            tail = tail.next;
            head = tmp;
        }
        if (head != null) {
            tail.next = head;
        }

        return _tail.next;

    }

    public ListNode swapPairs(ListNode head) {
        ListNode n = new ListNode(-1);
        ListNode _n = n;
        ListNode m = new ListNode(-1);
        ListNode _m = m;
        while (head != null && head.next != null) {
            n.next = head;
            m.next = head.next;

            n = n.next;
            m = m.next;

            head = head.next.next;
        }
        ListNode tmp = new ListNode(-1);
        ListNode _tmp = tmp;
        while (_n.next != null && _m.next != null) {
            tmp.next = _m.next;
            tmp = tmp.next;
            tmp.next = _n.next;

            tmp = tmp.next;
            _n = _n.next;
            _m = _m.next;
        }

        if (head != null) {
            tmp.next = head;
        }
        return _tmp.next;
    }

}
