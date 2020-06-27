package com.yany.leetcode;

/**
 * @author yanyong on 2020/6/1
 */
public class _75_SortColors {

    public void sortColors(int[] nums) {
        int p0 = 0, p2 = nums.length - 1, cur = 0;
        while (cur <= p2) {
            if (nums[cur] == 0) {
                swap(nums, p0++, cur++);

            } else if (nums[cur] == 2) {
                swap(nums, p2--, cur);
            } else {
                cur++;
            }
        }

    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
