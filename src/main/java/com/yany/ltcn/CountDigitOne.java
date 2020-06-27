package com.yany.ltcn;

/**
 * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 *
 * @author yanyong on 2020/5/6
 */
public class CountDigitOne {
    public static void main(String[] args) {
        System.out.println(new CountDigitOne().countDigitOne(1000));
    }

    public int countDigitOne(int n) {
        if (n <= 0) {
            return 0;
        }
        return xxx(n);
    }

    private int wei(int n) {
        int count = 0;
        int ten = 1;
        for (int i = 0; i < n; i++) {
            count = 9 * count + ten;
            ten = ten * 10;
        }

        return count;
    }


    private int xxx(int n) {
        if (n < 10) {
            if (n >= 1) {
                return 1;
            }
            return 0;
        }
        String num = String.valueOf(n);
        int len = num.length() - 1;
        int start = Integer.parseInt(num.substring(0, 1));
        int weiT = (int) Math.pow(10, len);

        if (n % weiT == 0 && start == 1) {
            return start * wei(len) + (xxx(n / 10));
        } else if (start == 1) {
            return start * wei(len) + (xxx(n % weiT)) + n - weiT + 1;
        } else {
            return start * wei(len) + (xxx(n % weiT)) + weiT;
        }
    }

}
