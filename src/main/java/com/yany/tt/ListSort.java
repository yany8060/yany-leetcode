package com.yany.tt;

import com.yany.model.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yanyong on 2020/6/3
 */
public class ListSort {

    public static void main(String[] args) {
        ListNode a = null;
        ListNode b = null;
        test(a, b);

        System.out.println(a.val);
        System.out.println(b.val);
    }


    public static void test(ListNode a, ListNode b) {

        a = new ListNode(1);
        b = new ListNode(2);

    }

    public ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode tmp = new ListNode(0);
        ListNode head = tmp;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                tmp.next = l2;
                l2 = l2.next;
            } else {
                tmp.next = l1;
                l1 = l1.next;
            }
            tmp = tmp.next;
        }

        if (l1 == null) {
            tmp.next = l2;
        }

        if (l2 == null) {
            tmp.next = l1;
        }
        return head.next;
    }

}
