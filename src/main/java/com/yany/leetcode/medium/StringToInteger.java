package com.yany.leetcode.medium;

/**
 * @author yanyong on 2019/4/8
 */
public class StringToInteger {
    public static void main(String[] args) {
        System.out.println(myAtoi("++419+3 with words"));
    }

    public static int myAtoi(String str) {
        int n = 0;
        if (str == null) {
            return 0;
        }

        boolean isStart = false;
        boolean isfushu = false;
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == ' ' && !isStart) {
                continue;
            }
            if (ch[i] == '+' && !isStart) {
                continue;
            }

            if (!isStart && ch[i] != '-' && (ch[i] < '0' || ch[i] > '9')) {
                return 0;
            }


            if (ch[i] == '-' && !isStart) {
                isStart = true;
                isfushu = true;
                continue;
            }

            if (ch[i] >= '0' && ch[i] <= '9') {
                int t = Integer.valueOf(ch[i] + "");
                if (isfushu) {
                    int tmp = 0 - (Integer.MIN_VALUE / 10);
                    if (tmp < n) {
                        return Integer.MIN_VALUE;
                    }
                    if (tmp == n && (0 - Integer.MIN_VALUE % 10) <= t) {
                        return Integer.MIN_VALUE;
                    }
                } else {
                    int tmp = Integer.MAX_VALUE / 10;
                    if (tmp < n) {
                        return Integer.MAX_VALUE;
                    }
                    if (tmp == n && Integer.MAX_VALUE % 10 > t) {
                        return Integer.MAX_VALUE;
                    }
                }
                n = n * 10 + t;
                isStart = true;
            } else if (isStart) {
                break;
            }
        }
        if (isfushu) {
            return 0 - n;
        } else {
            return n;
        }
    }
}
