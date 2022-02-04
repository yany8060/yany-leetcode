package com.yany.leetcode;

import java.util.Arrays;

/*
   最长重复子数组
 */
public class _718_MaximumLengthOfRepeatedSubarray {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 2, 1};
        int[] nums2 = new int[]{3, 2, 1, 4, 7};

        int result = new _718_MaximumLengthOfRepeatedSubarray().findLength(nums1, nums2);
        System.out.println(result);


    }


    /**
     * dp表达式
     * dp[i][j] = nums1[i] == nums2[j] ? dp[i-][j-1] + 1 : 0
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums1.length + 1];
        int max = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = 0;
                }
                max = Math.max(max, dp[i + 1][j + 1]);
            }
        }
        return max;
    }

    public int findLength2(int[] nums1, int[] nums2) {
        int max = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] != nums1[i]) {
                    continue;
                }
                int tmpi = i;
                int tmpj = j;
                int len = 0;
                while (tmpj < nums2.length && tmpi < nums1.length) {
                    if (nums1[tmpi] != nums2[tmpj]) {
                        break;
                    }
                    len++;
                    tmpi++;
                    tmpj++;
                }
                max = Math.max(max, len);
            }
        }
        return max;
    }
}
