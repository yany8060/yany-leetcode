package com.yany.swordoffer;

import com.yany.model.ListNode;

/**
 * @author yanyong on 2020/2/24
 */
public class FindKthToTail {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k == 0)
            return null;
        ListNode lp = head, rp = head;

        for (int i = 0; i < k - 1; i++) {
            rp = rp.next;
            if (rp == null) {
                return null;
            }
        }

        while (rp.next != null) {
            rp = rp.next;
            lp = lp.next;
        }

        return lp;

    }



}
