package com.yany.leetcode;

/**
 * 动态规划法
 * dp[i] = max(dp[i-1],0) + num[i]
 *
 * @author yanyong on 2020/2/4
 */
public class _53_MaxSubArray {

    public static void main(String[] args) {
        //new _53_MaxSubArray().maxSubArray();
    }

    public int maxSubArray(int[] nums) {

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + nums[i] : nums[i];

            res = Math.max(res, dp[i]);

        }
        return res;
    }

}
