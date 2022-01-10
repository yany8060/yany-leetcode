package com.yany.leetcode;

import java.util.Arrays;

public class _560_SubarraySum {

    public int subarraySum(int[] nums, int k) {
        Arrays.sort(nums);
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    num++;
                }
            }
        }
        return num;
    }


}
