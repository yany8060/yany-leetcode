package com.yany.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * url https://leetcode.com/problems/3sum/
 * <p>
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * The solution set must not contain duplicate triplets.
 *
 * @author yanyong on 2019/5/13
 */
public class _3Sum_15 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            for (int j = i + 1; j < nums.length; i++) {
                int b = nums[j];
                int n = 0 - (a + b);

            }


        }

        return null;
    }
}
