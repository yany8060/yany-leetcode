package com.yany.swordoffer;

import java.util.Stack;

public class _31_IsPopOrder {
    public static void main(String[] args) {
        int[] pushA = new int[]{1, 2, 3, 4, 5};
        int[] popA = new int[]{4, 5, 3, 2, 2};
        new _31_IsPopOrder().IsPopOrder(pushA, popA);
    }

    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || popA == null) {
            return false;
        }
        if (pushA.length != popA.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0, j = 0; j < popA.length; ) {
            if (i < pushA.length && pushA[i] == popA[j]) {
                j++;
                i++;
                continue;
            }
            if (!stack.empty()) {
                int tmp = stack.pop();
                if (tmp == popA[j]) {
                    j++;
                    continue;
                }
                stack.push(tmp);
                if (i == pushA.length) {
                    break;
                }
            }
            stack.push(pushA[i]);
            i++;
        }
        return stack.empty();
    }

}
