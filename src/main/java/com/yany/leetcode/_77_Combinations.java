package com.yany.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yanyong on 2020/5/2
 */
public class _77_Combinations {

    public static void main(String[] args) {
        new _77_Combinations().combine(4, 2);
    }

    public List<List<Integer>> combine(int n, int k) {
        backtrack(1, n, k, new ArrayList<>());
        return result;
    }

    List<List<Integer>> result = new ArrayList<>();

    public void backtrack(int index, int n, int k, List<Integer> list) {
        if (k <= 0) {
            result.add(new ArrayList<>(list));
            return;

        }

        for (int i = index; i <= n; i++) {
            list.add(i);
            backtrack(++i, n, --k, list);
            k++;
            i--;
            list.remove(list.size() - 1);
        }

    }


}
