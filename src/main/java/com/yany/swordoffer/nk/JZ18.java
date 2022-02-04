package com.yany.swordoffer.nk;

import com.yany.model.ListNode;

public class JZ18 {
    public ListNode deleteNode (ListNode head, int val) {
        // write code here
        if(head.val == val) {
            return head.next;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode cur = head;
        while(cur != null) {
            if(cur.val == val) {
                pre.next = pre.next.next;
            }
            cur = cur.next;
            pre = pre.next;
        }
        return head;
    }
}
