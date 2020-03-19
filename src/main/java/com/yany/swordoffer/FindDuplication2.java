package com.yany.swordoffer;

/**
 * @author yanyong on 2020/3/14
 */
public class FindDuplication2 {
    public int getDuplicate(int[] arr) {
        int start = 1, end = arr.length - 1;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            int count = getCount(arr, start, mid);
            if (start == end) {
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }
            if (count > (mid - start + 1)) {
                //说明有重复元素
                end = mid;
            } else {
                //相反
                //因为 数组中肯定有重复的元素,不上一半就在这
                start = mid + 1;
            }
        }
        return -1;
    }

    //计算数组中start-end 中出现的次数
    private int getCount(int[] arr, int start, int end) {
        if (arr == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= start && arr[i] <= end) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 5, 4, 3, 2, 6, 7};
        int dup = new FindDuplication2().getDuplicate(a);
        System.out.println("重复数字为：" + dup);
    }
}
