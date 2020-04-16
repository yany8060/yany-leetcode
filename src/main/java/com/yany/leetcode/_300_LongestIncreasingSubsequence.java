package com.yany.leetcode;

/**
 * @author yanyong on 2020/4/16
 */
public class _300_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        System.out.println(new _300_LongestIncreasingSubsequence().lengthOfLIS(new int[]{4, 10, 5, 2, 3, 8, 9}));
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = Integer.MIN_VALUE;

        for (int i = 1; i < nums.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }

            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

}
