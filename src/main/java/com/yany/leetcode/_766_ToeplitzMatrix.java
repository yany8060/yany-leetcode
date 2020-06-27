package com.yany.leetcode;

/**
 * @author yanyong on 2020/5/6
 */
public class _766_ToeplitzMatrix {

    public boolean isToeplitzMatrix(int[][] matrix) {
        int y = matrix.length;
        int x = matrix[0].length;

        for (int i = 0; i < x; i++) {
            if (!isTop(matrix, 0, i)) {
                return false;
            }
        }
        for (int i = 0; i < y; i++) {
            if (!isTop(matrix, i, 0)) {
                return false;
            }
        }
        return true;
    }

    public boolean isTop(int[][] matrix, int m, int n) {
        int tmp = matrix[m][n];
        int y = matrix.length;
        int x = matrix[0].length;
        while (m < y && n < x) {
            if (tmp != matrix[m][n]) {
                return false;
            }
            m++;
            n++;
        }
        return true;
    }

}
