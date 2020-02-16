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
}
