package com.yany.leetcode;

/**
 * 动态规范法
 * <p>
 * f(n) = f(n-1) + f(n-2)
 *
 * @author yanyong on 2020/2/4
 */
public class _70_ClimbStairs {
    public static void main(String[] args) {
        new _70_ClimbStairs().climbStairs(3);
    }

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

}
