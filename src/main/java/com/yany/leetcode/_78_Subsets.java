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
        new _78_Subsets().subsets2(nums);
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

    public List<List<Integer>> subsets2(int[] nums) {
        List<Integer> tmp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        result.add(tmp);

        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> tmp1 = new ArrayList<>(result);
            add(tmp1, nums[i]);
            result.addAll(tmp1);
        }
        return result;

    }

    public void add(List<List<Integer>> lst, int num) {
        for (int i = 0; i < lst.size(); i++) {
            lst.get(i).add(num);
        }
    }


}
