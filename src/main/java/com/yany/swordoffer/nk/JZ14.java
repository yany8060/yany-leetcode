package com.yany.swordoffer.nk;

public class JZ14 {

    public static void main(String[] args) {
        new JZ14().cutRope(8);
    }

    // f(n) = max(f(i)*f(n-i))
    public int cutRope(int target) {
        if (target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }
        int[] dp = new int[target + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= target; i++) {
            int max = 0;
            for (int j = 1; j <= i; j++) {
                max = Math.max(dp[j] * dp[i - j], max);
            }
            dp[i] = max;

        }
        return dp[target];
    }
}
