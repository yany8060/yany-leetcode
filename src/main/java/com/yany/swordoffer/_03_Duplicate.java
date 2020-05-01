package com.yany.swordoffer;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 *
 * @author yanyong on 2020/4/16
 */
public class _03_Duplicate {

    public boolean duplicate(int target, int[][] array) {
        if (array.length == 0 || array[0].length == 0)
            return false;
        int m = array[0].length - 1;
        int n = 0;
        int temp = array[n][m];

        while (target != temp) {
            if (n < array.length && m >= 0) {
                if (target > temp) {
                    m--;
                } else {
                    n++;
                }
                temp = array[n][m];
            } else {
                return false;
            }

        }
        return false;
    }
}
