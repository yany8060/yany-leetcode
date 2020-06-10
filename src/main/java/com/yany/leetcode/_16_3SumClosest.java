package com.yany.leetcode;

import java.util.Arrays;

/**
 * @author yanyong on 2020/6/9
 */
public class _16_3SumClosest {


    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int tmp = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(sum - target) < Math.abs(tmp - target)) {
                    tmp = sum;
                }
                if (sum > target)
                    end--;
                else if (sum < target)
                    start++;
                else
                    return tmp;
            }
        }

        return tmp;
    }


}
