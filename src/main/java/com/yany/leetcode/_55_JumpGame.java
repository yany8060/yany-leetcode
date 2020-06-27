package com.yany.leetcode;

/**
 * @author yanyong on 2020/2/11
 */
public class _55_JumpGame {
    public static void main(String[] args) {
        int[] num = new int[]{2, 3, 1, 1, 4};
        System.out.println(new _55_JumpGame().canJump(num));
    }

    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(nums[i] + i, max);
        }
        return true;
    }

    public boolean canJump2(int[] nums) {
        int len = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (len <= (nums[i] + i)) {
                len = i;
            }
        }
        return len == 0;
    }

    public boolean canJump3(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[nums.length - 1] = true;

        for (int i = nums.length - 2; i >= 0; i--) {
            int val = nums[i];

            for (int j = 1; j <= val; j++) {
                if (i + j < nums.length && dp[i + j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }


}
