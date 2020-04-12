package com.yany.swordoffer;

public class _60_PrintProAbility {

    public void PrintProAbility(int number) {
        if (number < 1) {
            return;
        }

        int g_maxValue = 6;

        int[][] probabilities = new int[2][];
        probabilities[0] = new int[number * g_maxValue + 1];
        probabilities[1] = new int[number * g_maxValue + 1];

        for (int i = 1; i <= g_maxValue; i++) {
            probabilities[0][i] = 1;
        }
        int flag = 0;

        for (int k = 2; k <= number; k++) {
            for (int i = 0; i < k; i++) {
                probabilities[1 - flag][i] = 0;
            }

            for (int s = k; s <= k * g_maxValue; s++) {
                probabilities[1 - flag][s] = 0;
                for (int i = 1; i <= s && i <= g_maxValue; i++) {
                    probabilities[1 - flag][s] += probabilities[flag][s - i];
                }
            }

        }

        double total = Math.pow(g_maxValue, number);
        for (int i = number; i <= g_maxValue * number; i++) {
            double ratio = (double) probabilities[flag][i] / total;
            System.out.println(i);
            System.out.println(ratio);
        }

    }


}
