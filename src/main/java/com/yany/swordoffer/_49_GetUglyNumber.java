package com.yany.swordoffer;

public class _49_GetUglyNumber {

    public int GetUglyNumber(int index) {
        if (index < 0) {
            return 0;
        }

        int[] ug = new int[index];
        ug[0] = 1;
        int ug2 = 0, ug3 = 0, ug5 = 0;
        int count = 1;
        int curUg = 1;

        while (count < index) {
            curUg = min(2 * ug[ug2], 3 * ug[ug3], 5 * ug[ug5]);
            ug[count] = curUg;

            while (2 * ug[ug2] <= curUg) {
                ug2++;
            }
            while (3 * ug[ug3] <= curUg) {
                ug3++;
            }
            while (5 * ug[ug5] <= curUg) {
                ug5++;
            }

            count++;
        }

        return ug[index - 1];
    }

    public int min(int a, int b, int c) {
        int temp = a > b ? b : a;
        return temp > c ? c : temp;
    }

}
