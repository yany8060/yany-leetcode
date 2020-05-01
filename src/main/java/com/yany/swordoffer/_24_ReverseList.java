package com.yany.swordoffer;

import com.yany.model.ListNode;

/**
 * @author yanyong on 2020/3/26
 */
public class _24_ReverseList {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        ListNode node = new _24_ReverseList().reverseList(n1);
        System.out.println();
    }

    public ListNode reverseList(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }

        ListNode head = new ListNode(-1);
        head.next = pHead;
        ListNode node = pHead;
        while (node != null) {
            ListNode tmp = node.next;

            node.next = head.next;
            head.next = node;

            node = tmp;
        }
        return head.next;
    }


}
