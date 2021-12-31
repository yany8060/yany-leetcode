package com.yany.swordoffer;

public class JZ1 {
    /**
     * 在一个二维数组array中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * [
     * [1,2,8,9],
     * [2,4,9,12],
     * [4,7,10,13],
     * [6,8,11,15]
     * ]
     * 给定 target = 7，返回 true。
     * <p>
     * 给定 target = 3，返回 false。
     * <p>
     * 0 <= array.length <= 500
     * 0 <= array[0].length <= 500
     */
    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};

        boolean result = new JZ1().Find(1, nums);
        System.out.println(result);
    }


    public boolean Find(int target, int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = array[i].length - 1; j >= 0; j--) {
                if (target == array[i][j]) {
                    return true;
                }
                if (target > array[i][j]) {
                    break;
                }
            }
        }
        return false;
    }

}
