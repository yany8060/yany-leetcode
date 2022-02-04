package com.yany.leetcode;

public class _416_ {
    public static void main(String[] args) {
        boolean a = new _416_().canPartition(new int[]{1, 5, 11, 6});
        System.out.println(a);
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        return canPartition(nums, sum / 2);
    }

    // dp[i][j] = dp[i-1][j] or dp[i-1][j-nums[i]]
    public boolean canPartition(int[] nums, int target) {
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 0; j <= target; j++) {
                if (j == nums[i - 1]) {
                    dp[i][j] = true;
                    continue;
                }
                if (j > nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] | dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[nums.length][target];
    }
}
