package com.yany.leetcode;

import java.util.*;

public class _18_4Sum {
    public static void main(String[] args) {
        new _18_4Sum().fourSum(new int[]{-3, -1, 0, 2, 4, 5}, 2);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length <= 3) {
            return lists;
        }


        Arrays.sort(nums);

        Set<String> resultSet = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int tg = target - nums[i];
            _3Sum(nums, i + 1, nums.length - 1, tg, resultSet);
        }

        for (String result : resultSet) {
            List<Integer> list = new ArrayList<>();
            for (String num : result.split("_")) {
                list.add(Integer.parseInt(num));
            }
            lists.add(list);
        }
        return lists;
    }

    public void _3Sum(int[] nums, int begin, int end, int target, Set<String> resultSet) {
        String result = nums[begin - 1] + "_";
        for (int i = begin; i < end - 1; i++) {
            int tg = target - nums[i];
            int L = i + 1, R = end;
            while (L < R) {
                if (nums[L] + nums[R] > tg) {
                    R--;
                } else if (nums[L] + nums[R] < tg) {
                    L++;
                } else {
                    resultSet.add(result + nums[i] + "_" + nums[L] + "_" + nums[R]);
                    L++;
                    R--;
                }
            }
        }
    }
}
