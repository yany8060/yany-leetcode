package com.yany.leetcode;

/**
 * TODO
 */
public class _2167_minimumTime {
    public static void main(String[] args) {
        new _2167_minimumTime().minimumTime("1100101");
    }

    public int minimumTime(String s) {
        int n = 0;
        int m = s.length() - 1;

        int t = 0;
        // 先去掉首尾 1
        char[] tmp = s.toCharArray();
        for (; n < s.length(); n++) {
            if (tmp[n] != '1') {
                break;
            }
            t++;
        }
        for (; m >= 0; m--) {
            if (tmp[m] != '1') {
                break;
            }
            t++;
        }

        //
        int r = 0;
        int tl = 0;
        for (int i = n; i < m; i++) {
            if (tmp[i] == '1') {
                r += 2;
                tl = i - n + 1;
            }
        }
        int tr = 0;
        for (int i = m; i > n; i--) {
            if (tmp[i] == '1') {
                tr = m - i + 1;
            }
        }
        t += Math.min(r, Math.min(tr, tl));
        return t;
    }
}
