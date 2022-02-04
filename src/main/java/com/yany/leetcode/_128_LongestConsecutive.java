package com.yany.leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class _128_LongestConsecutive {
    public static void main(String[] args) {
        int[] arr = {00, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(arr));

    }


    public static int longestConsecutive(int[] nums) {
        Set<Integer> tmp = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            tmp.add(nums[i]);
        }

        int max = 0;
        for (Integer a : tmp) {
            if (!tmp.contains(a - 1)) {// 代码开头
                int len = 0;
                while (tmp.contains(a)) {
                    a++;
                    len++;
                }
                max = Math.max(max, len);
            }
        }
        return max;
    }

    public int longestConsecutive2(int[] nums) {
        int[] tmp = new int[Integer.MAX_VALUE];
        for (int n : nums) {
            tmp[n] = 1;
        }
        int l = 0, r = 0, max = 0;
        for (int i = 0; i < tmp.length; i++) {
            if (nums[i] == 1) {
                l = i;
                r = i;
            }
            while (i < tmp.length && tmp[i] == 1) {
                i++;
                r++;
            }
            if (l != r) {
                max = Math.max(max, r - l);
            }

        }

        return max;
    }

}
