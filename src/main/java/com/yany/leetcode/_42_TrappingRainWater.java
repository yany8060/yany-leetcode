package com.yany.leetcode;

/**
 * @author yanyong on 2020/3/9
 */
public class _42_TrappingRainWater {

    public static void main(String[] args) {
        int[] height = new int[]{2, 0, 2};
        System.out.println(new _42_TrappingRainWater().trap(height));
    }

    public int trap(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            if (max < height[i]) {
                max = height[i];
            }
        }
        int tmp = 0;
        for (int i = 0; i < max; i++) {
            int l = -1, r = -1;
            for (int j = 0; j < height.length; j++) {
                if (height[j] > 0 && (j - l <= 1 || l == -1)) {
                    l = j;
                } else if (height[j] > 0 && l >= 0) {
                    tmp += j - l - 1;
                    l = j;
                }
                if (height[j] > 0) {
                    height[j] = height[j] - 1;
                }
            }
        }
        return tmp;

    }
}
