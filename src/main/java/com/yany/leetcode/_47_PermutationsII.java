package com.yany.leetcode;

import java.util.*;

/**
 * @author yanyong on 2020/3/18
 */
public class _47_PermutationsII {

    public static void main(String[] args) {
        int[] nums = {1, 1, 3};
        new _47_PermutationsII().permuteUnique(nums);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;

        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        // 排序（升序或者降序都可以），排序是剪枝的前提
        Arrays.sort(nums);

        boolean[] visited = new boolean[len];
        List<Integer> path = new ArrayList<>();
        //dfs(nums, len, 0, path, visited, res);
        Set<String> set = new HashSet<>();
        dfs2(nums, len, 0, path, visited, res, set);
        return res;
    }

    public void dfs(int[] nums, int len, int depth, List<Integer> path
            , boolean[] visited, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (visited[i]) {
                continue;
            }

            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }

            visited[i] = true;
            path.add(nums[i]);
            dfs(nums, len, depth + 1, path, visited, res);

            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }

    public void dfs2(int[] nums, int len, int depth, List<Integer> path
            , boolean[] visited, List<List<Integer>> res, Set<String> set) {
        if (depth == len) {
            if (set.contains(path.toString())) {
                return;
            }
            set.add(path.toString());
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            path.add(nums[i]);
            dfs2(nums, len, depth + 1, path, visited, res, set);

            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }

}
