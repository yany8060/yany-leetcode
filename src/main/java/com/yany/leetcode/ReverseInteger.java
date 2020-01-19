package com.yany.leetcode;

/**
 * @author yanyong on 2019/4/8
 */
public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse(120));
    }


    public static int reverse(int x) {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;

        Long r = 0L;
        while (Math.abs(x) > 0) {
            int tmp = x % 10;
            r = r * 10 + tmp;
            x = x / 10;
            if (r > max || r < min) {
                return 0;
            }
        }

        return r.intValue();
    }
}
