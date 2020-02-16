package com.yany.leetcode;

import com.yany.leetcode.model.ListNode;


/**
 * 链表 分链操作
 *
 * @author yanyong on 2020/2/5
 */
public class _86_PartitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode sm = new ListNode(0);
        ListNode bg = new ListNode(0);
        ListNode smH = sm, bgH = bg;
        while (head != null) {
            if (head.val < x) {
                sm.next = head;
                sm = sm.next;
            } else {
                bg.next = head;
                bg = bg.next;
            }

            head = head.next;
        }

        sm.next = bgH.next;
        bg.next = null;
        return smH.next;
    }

    public void insert(ListNode sign, ListNode preSign, ListNode node, ListNode preNode) {
        if (preSign != null) {
            preSign.next = node;
        }
        preNode.next = node.next;
        node.next = sign;
    }

}
