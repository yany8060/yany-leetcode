package com.yany.leetcode;

import com.yany.leetcode.model.ListNode;

/**
 * 两数相加
 * <p>
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
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
