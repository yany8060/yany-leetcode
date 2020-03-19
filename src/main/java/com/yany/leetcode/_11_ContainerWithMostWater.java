package com.yany.leetcode;

/**
 * @author yanyong on 2020/3/9
 */
public class _11_ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new _11_ContainerWithMostWater().maxArea(height));
    }

    public int maxArea(int[] height) {
        int area = 0;

        int i = 0, j = height.length - 1;
        while (i < j) {
            int x = j - i;
            int y;
            if (height[i] > height[j]) {
                y = height[j];
                j--;
            } else {
                y = height[i];
                i++;
            }
            area = Math.max(x * y, area);
        }
        return area;
    }
}
