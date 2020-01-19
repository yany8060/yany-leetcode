package com.yany.leetcode;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/submissions/
 * @author yanyong on 2020/1/9
 */
public class _122_MaxProfit {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }

}
