package com.yany.leetcode;

/**
 * @author yanyong on 2020/2/4
 */
public class _64_MinPathSum {

    public static void main(String[] args) {
        int[][] dp = {
                {1, 2, 5},
                {3, 2, 1},
        };

        new _64_MinPathSum().minPathSum(dp);
    }


    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (j == 0) {
                    dp[j][i] = dp[j][i - 1] + grid[j][i];
                } else if (i == 0) {
                    dp[j][i] = dp[j - 1][i] + grid[j][i];
                } else {
                    dp[j][i] += grid[j][i] + Math.min(dp[j - 1][i], dp[j][i - 1]);
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
