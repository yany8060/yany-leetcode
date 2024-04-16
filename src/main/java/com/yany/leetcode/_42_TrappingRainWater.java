package com.yany.leetcode;

/**
 * @author yanyong on 2020/3/9
 */
public class _42_TrappingRainWater {

    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
//        System.out.println(new _42_TrappingRainWater().trap2(height));

//        height = new int[]{4, 2, 0, 3, 2, 5};
        System.out.println(new _42_TrappingRainWater().trap3(height));
    }

    public int trap4(int[] height) {
        int l = 0, r = height.length - 1;
        int lmax = 0, rmax = 0;
        int result = 0;
        while (l < r) {
            lmax = Math.max(height[l], lmax);
            rmax = Math.max(height[r], rmax);
            if (height[l] < height[r]) { // 效果一样
                //if (lmax < rmax) {     // 效果一样
                result += lmax - height[l];
                l++;
            } else {
                result += rmax - height[r];
                r--;
            }
        }
        return result;
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

    // 超时了
    public int trap3(int[] height) {
        int l = 0;
        int len = height.length;

        // 第一个非0的开始
        while (l < len && height[l] == 0) {
            l++;
        }
        int result = 0;
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            max = Math.max(max, height[i]);
        }

        for (int i = 0; i < max; i++) {
            result += mj2(height);

            int subNum = 0;
            for (int j = 0; j < height.length; j++) {
                if (height[j] == 0) {
                    continue;
                }
                height[j]--;
                subNum++;
            }
            if (subNum == 1) {
                break;
            }
        }

        return result;
    }

    public int mj2(int[] height) {
        int l = 0, r = 0;
        int result = 0;
        while (l < height.length && r < height.length) {
            while (l < height.length && height[l] == 0) {
                l++;
            }
            r = l + 1;
            while (r < height.length && height[r] == 0) {
                r++;
            }
            if (r - l > 1 && r < height.length) {
                result += r - l - 1;
            }
            l = r;
        }
        return result;
    }
}
