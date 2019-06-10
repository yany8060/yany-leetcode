package com.yany.leetcode.medium;

/**
 * You are given coins of different denominations and a total amount of money.
 * Write a function to compute the number of combinations that make up that amount.
 * You may assume that you have infinite number of each kind of coin.*
 * <p>
 * <p>
 * Input: amount = 5, coins = [1, 2, 5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 *
 * @author yanyong on 2019/3/3
 */
public class CoinChange2 {

    public static void main(String[] args) {

    }


    public static int change(int amount, int[] coins) {
        int n = 0;
        int dp[][] = new int[coins.length][amount + 1];

        for (int i = 0; i < coins.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j < amount; j++) {
                int k = j / coins[i];
                for (int a = 0; a < k; a++) {
                    if (dp[i - 1][j - a * coins[i]] == 5) {
                        n++;
                    }
                }
            }
        }

        return n;
    }
}
