package com.yany.leetcode;

import com.yany.model.ListNode;

/**
 * @author yanyong on 2020/6/10
 */
public class _21_MergeTwoLists {


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode tmp = new ListNode(-1);
        ListNode head = tmp;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tmp.next = l1;
                l1 = l1.next;
            } else {
                tmp.next = l2;
                l2 = l2.next;
            }
            tmp = tmp.next;
        }
        if (l1 != null) {
            tmp.next = l1;
        }
        if (l2 != null) {
            tmp.next = l2;
        }
        return head.next;
    }

}
