package com.yany.leetcode;

/**
 * @author yanyong on 2020/1/7
 */
public class _121_MaxProfit {

    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (min > prices[i]) {
                min = prices[i];
            }

            if (maxProfit < (prices[i] - min)) {
                maxProfit = prices[i] - min;
            }
        }

        return maxProfit;
    }


}
