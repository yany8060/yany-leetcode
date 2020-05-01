package com.yany.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yanyong on 2020/4/30
 */
public class _120_Triangle {

    public static void main(String[] args) {
        List<Integer> one = new ArrayList<Integer>() {{
            add(2);
        }};
        List<Integer> two = new ArrayList<Integer>() {{
            add(3);
            add(4);
        }};

        List<Integer> three = new ArrayList<Integer>() {{
            add(6);
            add(5);
            add(7);
        }};

        List<Integer> four = new ArrayList<Integer>() {{
            add(4);
            add(1);
            add(8);
            add(3);
        }};

        List<List<Integer>> lists = new ArrayList<>();
        lists.add(one);
        lists.add(two);
        lists.add(three);
        lists.add(four);

        System.out.println(new _120_Triangle().minimumTotal(lists));

    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null) {
            return 0;
        }

        int n = triangle.size();
        int m = triangle.get(n - 1).size();

        int[][] dp = new int[n][m];

        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = triangle.get(i).get(j) + dp[i - 1][j];
                } else if (j == i) {
                    dp[i][j] = triangle.get(i).get(j) + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                }
            }
        }

        Arrays.sort(dp[n - 1]);
        return dp[n - 1][0];
    }

}
