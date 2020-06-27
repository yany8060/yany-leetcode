package com.yany.leetcode;

/**
 * @author yanyong on 2020/6/10
 */
public class _26_RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        removeDuplicates(nums);
    }


    public static int removeDuplicates(int[] nums) {
        int index = 0, tail = 0;
        while (tail < nums.length) {
            if (nums[index] == nums[tail]) {
                tail++;
                continue;
            }

            index++;
            int tmp = nums[index];
            nums[index] = nums[tail];
            nums[tail] = tmp;
            tail++;
        }
        return index + 1;
    }

}
