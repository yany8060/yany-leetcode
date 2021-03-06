package com.yany.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Input:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * @author yanyong on 2020/2/12
 */
public class _54_SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };

        int[][] matrix2 = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},

        };

        int[][] matrix3 = new int[][]{
                {1},
                {2},
                {3},

        };
        System.out.println(new _54_SpiralMatrix().spiralOrder(matrix3));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<>();
        if (matrix.length == 0) {
            return order;
        }

        int x = matrix[0].length - 1;
        int y = matrix.length - 1;

        for (int i = 0, j = 0; ; ) {
            addOrder(matrix, x, y, i, j, order);
            i++;
            j++;
            x = x - 2;
            y = y - 2;
            if (x < 0 || y < 0) {
                break;
            }
        }


        return order;
    }

    public void addOrder(int[][] matrix, int x, int y, int p, int q, List<Integer> order) {
        for (int i = 0; i <= x; i++) {
            order.add(matrix[q][p + i]);
        }

        for (int i = 1; i <= y; i++) {
            order.add(matrix[q + i][p + x]);
        }

        if (y <= 0 || x <= 0) {
            return;
        }

        for (int i = (p + x) - 1; i >= p; i--) {
            order.add(matrix[q + y][i]);
        }


        for (int i = (q + y) - 1; i >= q + 1; i--) {
            order.add(matrix[i][p]);
        }

    }

    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null) {
            return list;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int start = 0;
        while (start * 2 < m && start * 2 < n) {
            saveOneCircle(matrix, start, list);
            start++;
        }

        return list;
    }

    private void saveOneCircle(int[][] matrix, int start, List<Integer> list) {
        int m = matrix.length - start;
        int n = matrix[0].length - start;

        for (int i = start; i < n; i++) {
            list.add(matrix[start][i]);
        }


        if ((m - 1) > start) {
            for (int j = start; j < m; j++) {
                list.add(matrix[j][n - 1]);
            }
        }

        if ((n - 1) > start) {
            for (int i = n - 1; i >= start; i++) {
                list.add(matrix[m - 1][i]);
            }
        }
        if ((m - 2) > start) {
            for (int j = m - 2; j > start; j++) {
                list.add(matrix[j][start]);
            }
        }


    }


}
