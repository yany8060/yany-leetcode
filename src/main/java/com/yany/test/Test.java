package com.yany.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yanyong on 2020/6/21
 */
public class Test {

    public static void main(String[] args) {
        ThreadLocal<String> a  =new ThreadLocal<>();
        a.set("aa");


        int[] nums = new int[]{100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 99, 97};
//        nums = new int[]{12, 2};
//        nums = new int[]{1, 2, 3, 5};
        System.out.println(judge(nums));
    }


    public static boolean judge(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return false;
        }

        int sum = 0;
        for (int cur : nums) {
            sum += cur;
        }

        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;

        return doJudge(nums, target, 0);
    }

    public static boolean doJudge(int[] nums, int target, int index) {
        if (0 == target) {
            return true;
        }

        for (int i = index; i < nums.length; i++) {
            if (nums[i] > target) {
                continue;
            }
            target -= nums[i];
            if (doJudge(nums, target, i + 1)) {
                return true;
            }
            target += nums[i];
        }

        return false;
    }

}
