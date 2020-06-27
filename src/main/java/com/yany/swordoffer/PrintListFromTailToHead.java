package com.yany.swordoffer;

import com.yany.model.ListNode;

import java.util.ArrayList;

/**
 * @author yanyong on 2020/2/24
 */
public class PrintListFromTailToHead {

    public ArrayList<Integer> PrintListFromTailToHead(ListNode listNode) {
        ListNode head = new ListNode(-1);

        while (listNode != null) {
            ListNode tmp = listNode.next;
            listNode.next = head.next;

            head.next = listNode;
            listNode = tmp;
        }

        ArrayList<Integer> list = new ArrayList<>();

        head = head.next;
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        return list;
    }
}
