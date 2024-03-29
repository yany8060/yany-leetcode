package com.yany.leetcode;

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
public class _15_3Sum {
    public static void main(String[] args) {
        // -4 -1 -1 0 1 2
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
//        int[] nums = new int[]{0, 0, 0};
        List<List<Integer>> retList = threeSum2(nums);

        System.out.println(retList.size());
        Arrays.sort(nums);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if (nums == null || len < 3) return ans;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int L = i + 1;
            int R = nums.length - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]) L++; // 去重
                    while (L < R && nums[R] == nums[R - 1]) R--; // 去重
                    L++;
                    R--;
                } else if (sum > 0) {
                    R--;
                } else {
                    L++;
                }
            }
        }
        return ans;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int n = i + 1, m = nums.length - 1;
            while (n < m) {
                if (nums[n] + nums[m] + nums[i] == 0) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[m]);
                    tmp.add(nums[n]);
                    result.add(tmp);
                    m--;
                    n++;
                    continue;
                }


                if (nums[n] + nums[m] + nums[i] > 0) {
                    m--;
                } else {
                    n++;
                }
            }

            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return result;
    }


}
