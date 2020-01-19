package com.yany.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yanyong on 2019/7/15
 */
public class _89_GrayCode {

    public static void main(String[] args) {
        System.out.println(1 << 2);
    }

    public List<Integer> grayCode(int n) {
        if (n == 0) {
            return new ArrayList<Integer>() {{
                add(0);
            }};
        }
        int m = 1 << n;

        int[] a = new int[m];



        return null;
    }

}
