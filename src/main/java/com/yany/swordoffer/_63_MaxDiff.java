package com.yany.swordoffer;

public class _63_MaxDiff {
    public static void main(String[] args) {
        int[] a = new int[]{9, 11, 8, 5, 20, 7, 12, 16, 14, 17};
        System.out.println(new _63_MaxDiff().maxDiff(a));
    }


    public int maxDiff(int[] numbers) {
        int i = 0, j = 0;
        int max = Integer.MIN_VALUE;
        int currentValue = 0;

        while (i < numbers.length && j < numbers.length) {
            currentValue = numbers[j] - numbers[i];
            if (currentValue >= 0) {
                if (max < currentValue) {
                    max = currentValue;
                }
                j++;
            } else {
                i++;
            }
        }

        return max;
    }
}
