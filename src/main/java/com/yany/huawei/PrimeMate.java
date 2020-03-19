package com.yany.huawei;

import java.util.Scanner;

/**
 * @author yanyong on 2020/2/27
 */
public class PrimeMate {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        String n = scanner.nextLine();
//        String s = scanner.nextLine();
//
//        String[] _nums = s.split(" ");
//
//        int[] num = new int[_nums.length];
//        for (int i = 0; i < _nums.length; i++) {
//            num[i] = Integer.valueOf(_nums[i]);
//        }
        int[] num = new int[]{2, 5, 6, 13};
        primeMate(4, num);

    }

    public static void primeMate(int n, int[] nums) {
        boolean[][] b = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            int tmp = nums[i];
            for (int j = i + 1; j < n; j++) {
                b[i][j] = isPrime(tmp + nums[j]);
            }
        }

        int x = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (b[i][j]) {
                    x++;
                }
            }

        }

        System.out.println(x);
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }


}
