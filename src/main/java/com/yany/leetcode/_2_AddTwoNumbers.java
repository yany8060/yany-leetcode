package com.yany.leetcode;

import com.yany.leetcode.model.ListNode;

/**
 * @author yanyong on 2018/11/26
 */
public class _2_AddTwoNumbers {
    public static void main(String[] args) {
        ListNode d = new ListNode(1);
        ListNode cd = d;
        cd.next = new ListNode(8);

//        ListNode dx = addTwoNumbers(d, new ListNode(9));

        ListNode dx = addTwoNumbers(new ListNode(5), new ListNode(5));
        System.out.println("");
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode d = new ListNode(0);
        // 类似指针形式，curr变但是d不变
        ListNode curr = d;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            int sum = a + b + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        // 最后一位 判断进1
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return d.next;
    }


}
