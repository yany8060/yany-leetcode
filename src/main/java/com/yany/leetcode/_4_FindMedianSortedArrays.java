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
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{1};
        System.out.println(new _4_FindMedianSortedArrays().findMedianSortedArrays2(nums1, nums2));
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

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int tmpl = 0, tmpr = 0;
        int n = 0, i = 0, j = 0;
        while (i < nums1.length || j < nums2.length) {
            if (len % 2 == 0 && n == len / 2 + 1) {
                return (tmpl + tmpr) / 2.0;
            }
            if (len % 2 != 0 && n == len / 2 + 1) {
                return tmpr;
            }


            if (j >= nums2.length || (i < nums1.length && nums1[i] <= nums2[j])) {
                tmpl = tmpr;
                tmpr = nums1[i];
                i++;
                n++;
                continue;
            }
            if (i >= nums1.length || (j < nums2.length && nums1[i] > nums2[j])) {
                tmpl = tmpr;
                tmpr = nums2[j];
                j++;
                n++;
                continue;
            }

        }

        if (len % 2 == 0 && n == len / 2 + 1) {
            return (tmpl + tmpr) / 2.0;
        }
        if (len % 2 != 0 && n == len / 2 + 1) {
            return tmpr;
        }
        return -1;
    }
}
