package com.yany.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yanyong on 2020/6/10
 */
public class _22_GenerateParentheses {

    public static void main(String[] args) {
        new _22_GenerateParentheses().generateParenthesis(3);
    }

    List<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backTrace("", n, n, n);
        return list;
    }

    public void backTrace(String s, int left, int right, int n) {
        if (left == 0 && right == 0) {
            list.add(s);
        }
        if (left > 0 && (left - right) < n) {
            backTrace(s + "(", left - 1, right, n);
        }
        if (right > 0 && left < right) {
            backTrace(s + ")", left, right - 1, n);
        }
    }


}
