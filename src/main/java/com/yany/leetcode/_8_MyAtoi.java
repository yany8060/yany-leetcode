package com.yany.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author yanyong on 2020/2/20
 */
public class _8_MyAtoi {

    public static void main(String[] args) {
        System.out.println(new _8_MyAtoi().myAtoi("-2147483647"));
    }

    public int myAtoi(String str) {

        if (str == null) {
            return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }


        boolean isF = false;
        int i = 0;
        if (str.charAt(0) == '-') {
            i = 1;
            isF = true;
        } else if (str.charAt(0) == '+') {
            i = 1;
        }

        boolean isEnd = false, isStart = false;

        List<Integer> s = new ArrayList<>();
        for (; i < str.length(); i++) {
            if (isEnd) {
                break;
            }
            if (!isStart && str.charAt(i) == '0') {
                continue;
            }

            if ((str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
                isStart = true;
                s.add(str.charAt(i) - '0');
            } else {
                isEnd = true;
            }


            if (s.size() > String.valueOf(Integer.MIN_VALUE).length()) {
                return isF ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

        }


        long num = 0, j = 1;
        for (i = s.size() - 1; i >= 0; i--) {
            num += s.get(i) * j;
            j = j * 10;

            if (isF && -num <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else if (!isF && num >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
        }

        if (isF) {
            return 0 - Integer.valueOf(num + "");
        } else {
            return Integer.valueOf(num + "");
        }

    }

}
