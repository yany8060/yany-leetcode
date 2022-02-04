package com.yany.leetcode;

/**
 * @author yanyong on 2020/3/9
 */
public class _42_TrappingRainWater {

    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new _42_TrappingRainWater().trap2(height));
    }


    public int trap2(int[] height) {
        int i = 0, j = 0, result = 0;
        while (i <= j && j < height.length) {
            if (i < j && height[i] <= height[j]) {
                result += calContaner(height, i, j);
                i = j++;
                continue;
            }
            j++;
        }
        return result;
    }

    public int calContaner(int[] height, int l, int r) {
        int len = Math.min(height[l], height[r]);
        System.out.println(len);

        if (len == 0) {
            return 0;
        }
        int result = 0;
        while (l < r - 1) {
            result += len - height[++l];
            System.out.println(result);
        }
        return result;
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
