package com.yany.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯算法
 *
 * @author yanyong on 2020/3/19
 */
public class _78_Subsets {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        new _78_Subsets().subsets(nums);
    }

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        backtrack(nums, 0, res, item);
        return res;

    }

    public void backtrack(int[] nums, int len, List<List<Integer>> res, List<Integer> item) {

        res.add(new ArrayList<>(item));

        for (int i = len; i < nums.length; i++) {
            item.add(nums[i]);
            System.out.println(i + " " + len + " " + item);
            backtrack(nums, i + 1, res, item);
            item.remove(item.size() - 1);
        }

    }


}
