package com.yany.leetcode;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _2165_smallestNumber {
    public static void main(String[] args) {
        new _2165_smallestNumber().smallestNumber(-7605);
    }

    public long smallestNumber(long num) {
        List<Long> tmp = new ArrayList<>();
        boolean f = num > 0;
        while (num != 0) {
            tmp.add(num % 10L);
            num = num / 10L;
        }

        Collections.sort(tmp);

        if (f) {
            int zeorNums = 0;
            for (Long t : tmp) {
                if (t == 0) {
                    zeorNums++;
                    continue;
                }
                num = 10 * num + t;
                while (zeorNums > 0) {
                    num = 10L * num;
                    zeorNums--;
                }
            }
            return num;
        } else {
            for (int i = 0; i < tmp.size(); i++) {
                num = 10L * num + tmp.get(i);
            }
            return num;
        }
    }
}
