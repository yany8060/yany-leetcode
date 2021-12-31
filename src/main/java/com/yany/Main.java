package com.yany;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        int[] arr = new int[]{1,1,1};
        System.out.println(subarraySum(arr,2));
    }

    public static int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length<2){
            return nums[0]==k? 1:0;
        }
        Arrays.sort(nums);
        int left=0, right=1, res = 0;
        while(left<nums.length){
            if(nums[left]>k){
                break;
            }
            int temp = nums[left];
            right = left+1;
            while(right<nums.length){
                if(temp==k){
                    res++;
                    if(left == right){
                        left++;
                    }else{
                        left = right+1;
                    }
                    break;
                }
                temp += right;
                if(temp>k){
                    left++;
                    break;
                }
            }
        }
        return res;
    }
}