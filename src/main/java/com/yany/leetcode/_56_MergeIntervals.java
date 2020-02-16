package com.yany.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yanyong on 2020/2/16
 */
public class _56_MergeIntervals {
    public static void main(String[] args) {
        int[][] dp = {
                {1, 2},
                {2, 6},
                {0, 0},
        };
        new _56_MergeIntervals().merge(dp);
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        int[] xl = new int[intervals.length];
        int[] yl = new int[intervals.length];
        for (int i = 0; i < intervals.length; ++i) {
            xl[i] = intervals[i][0];
            yl[i] = intervals[i][1];
        }
        Arrays.sort(xl);
        Arrays.sort(yl);

        List<Integer> tl = new ArrayList<>();
        int x = xl[0];
        int y = yl[0];
        for (int i = 1; i < intervals.length; i++) {
            if (y < xl[i]) {
                // xxx
                tl.add(x);
                tl.add(y);

                x = xl[i];
                y = yl[i];
            } else {
                y = yl[i];
            }
        }
        tl.add(x);
        tl.add(y);

        int[][] mIntervals = new int[tl.size() / 2][2];
        for (int i = 0; i < tl.size() / 2; i++) {
            mIntervals[i][0] = tl.get(i * 2);
            mIntervals[i][1] = tl.get(i * 2 + 1);
        }

        return mIntervals;
    }

}
