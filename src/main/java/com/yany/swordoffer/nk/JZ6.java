package com.yany.swordoffer.nk;

import com.yany.model.ListNode;

import java.util.ArrayList;

public class JZ6 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);

        n1.next = n2;
        n2.next = n3;

        ArrayList<Integer> a = new JZ6().printListFromTailToHead(n1);
        System.out.println(a);
    }

    /**
     * 描述
     * 输入一个链表的头节点，按链表从尾到头的顺序返回每个节点的值（用数组返回）。
     * <p>
     * 如输入{1,2,3}的链表如下图:
     * <p>
     * 返回一个数组为[3,2,1]
     * <p>
     * 0 <= 链表长度 <= 10000
     *
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ListNode pre = new ListNode(0);
        while (listNode != null) {
            ListNode tmp = pre.next;
            ListNode n = listNode.next;

            pre.next = listNode;
//            pre.next.next = tmp;
            listNode.next = tmp;

            listNode = n;
        }

        ArrayList<Integer> result = new ArrayList<>();
        while (pre.next != null) {
            result.add(pre.next.val);
            pre = pre.next;
        }
        return result;
    }


    /*
       1. 额外空间 堆栈
       2. 链表逆置
     */
}
