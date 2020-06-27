package com.yany.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yanyong on 2019/7/15
 */
public class _89_GrayCode {

    public static void main(String[] args) {
        System.out.println(1 << 1);

        new _89_GrayCode().grayCode2(3);
    }

    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>() {{
            add(0);
        }};
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--)
                res.add(head + res.get(j));
            head <<= 1;
        }
        return res;
    }

    public List<Integer> grayCode2(int n) {
        if (n == 0) {
            return new ArrayList<Integer>() {{
                add(0);
            }};
        }
        if (n == 1) {
            return new ArrayList<Integer>() {{
                add(0);
                add(1);
            }};
        }

        List<Integer> list = grayCode2(n - 1);
        List<Integer> ret = new ArrayList<>(list);
        int m = 1 << (n - 1);
        for (int i = list.size() - 1; i >= 0; i--) {
            ret.add(m + list.get(i));
        }
        return ret;
    }

}
