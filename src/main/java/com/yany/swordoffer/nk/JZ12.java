package com.yany.swordoffer.nk;

public class JZ12 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param matrix char字符型二维数组
     * @param word   string字符串
     * @return bool布尔型
     */
    public boolean hasPath(char[][] matrix, String word) {
        // write code here
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == word.charAt(0) && find(matrix, i, j, word, 1, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean find(char[][] matrix, int i, int j, String word, int num, boolean[][] visited) {
        visited[i][j] = true;
        if (num == word.length()) {
            return true;
        }
        char target = word.charAt(num);
        // 上
        if (i - 1 >= 0 && matrix[i - 1][j] == target && !visited[i - 1][j]) {
            if (find(matrix, i - 1, j, word, num + 1, visited)) {
                return true;
            }
        }
        // 下
        if (i + 1 < matrix.length && matrix[i + 1][j] == target && !visited[i + 1][j]) {
            if (find(matrix, i + 1, j, word, num + 1, visited)) {
                return true;
            }
        }
        // 左
        if (j - 1 >= 0 && matrix[i][j - 1] == target && !visited[i][j - 1]) {
            if (find(matrix, i, j - 1, word, num + 1, visited)) {
                return true;
            }
        }
        // 右
        if (j + 1 < matrix[0].length && matrix[i][j + 1] == target && !visited[i][j + 1]) {
            if (find(matrix, i, j + 1, word, num + 1, visited)) {
                return true;
            }
        }

        visited[i][j] = false;
        return false;
    }

}
