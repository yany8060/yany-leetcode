package com.yany.swordoffer;

/**
 * 矩阵中的路径
 *
 * @author yanyong on 2020/3/16
 */
public class _12_StringPathInMatrix {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || rows < 1 || cols < 1 || str == null) {
            return false;
        }

        boolean[] visited = new boolean[rows * cols];
        int pathLength = 0;

        // 遍历矩阵中任意一个作为起点
        for (int i = 0; i < rows; i++) {// 行
            for (int j = 0; j < cols; j++) { // 列
                if (hasPathCore(matrix, rows, cols, i, j, str, pathLength, visited)) {
                    return true;
                }

            }
        }

        return false;
    }

    public boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col, char[] str, int pathLength, boolean[] visited) {
        if (pathLength == str.length) {
            return true;
        }

        boolean hasPath = false;
        if (row >= 0 && row < rows
                && col >= 0 && col < cols
                && matrix[row * cols + col] == str[pathLength]
                && !visited[row * cols + col]) {
            pathLength++;
            visited[row * cols + col] = true;

            hasPath = hasPathCore(matrix, rows, cols, row, col - 1, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row - 1, col, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row, col + 1, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row + 1, col, str, pathLength, visited)

            ;

            if (!hasPath) {
                pathLength--;
                visited[row * cols + col] = false;
            }
        }


        return hasPath;
    }


    public static void main(String[] args) {
        char[] matrix = new char[]{'A', 'B', 'C', 'E', 'S', 'F', 'C', 'S', 'A', 'D', 'E', 'E'};
        char[] str = new char[]{'A', 'B', 'C', 'C', 'E', 'D'};
        _12_StringPathInMatrix solution = new _12_StringPathInMatrix();
        System.out.println("result " + solution.hasPath(matrix, 3, 4, str));

    }
}
