package com.yany.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Median of Two Sorted Arrays
 *
 * @author yanyong on 2020/3/3
 */
public class _4_FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        System.out.println(new _4_FindMedianSortedArrays().findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> num = new ArrayList<>();

        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                num.add(nums1[i]);
                i++;
            } else {
                num.add(nums2[j]);
                j++;
            }
        }

        while (i < nums1.length) {
            num.add(nums1[i]);
            i++;
        }
        while (j < nums2.length) {
            num.add(nums2[j]);
            j++;
        }

        if (num.size() % 2 == 0) {
            return (num.get(num.size() / 2 - 1) + num.get(num.size() / 2)) / 2.0;
        } else {
            return num.get(num.size() / 2);
        }


    }
}
