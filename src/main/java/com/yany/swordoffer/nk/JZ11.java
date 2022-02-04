package com.yany.swordoffer.nk;

public class JZ11 {
    public static void main(String[] args) {
        System.out.println(new JZ11().minNumberInRotateArray2(new int[]{1, 0, 1, 1, 1}));
    }

    public int minNumberInRotateArray(int[] array) {
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (max <= array[i]) {
                max = array[i];
            } else {
                return array[i];
            }
        }
        if (max > array[0]) {
            return array[0];
        }

        return max;
    }

    public int minNumberInRotateArray2(int[] array) {
        return find(array, 0, array.length - 1);
    }

    public int find(int[] array, int i, int j) {
        if (i == j) {
            return array[i];
        }
        int mid = (i + j) / 2;
        if (array[mid] == array[j]) {
            return find(array, i, j - 1);
        }

        if (array[mid] > array[j]) {
            return find(array, mid + 1, j);
        }
        return find(array, i, mid);
    }
}
