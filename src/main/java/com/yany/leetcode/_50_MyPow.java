package com.yany.leetcode;

/**
 * @author yanyong on 2020/2/20
 */
public class _50_MyPow {

    public static void main(String[] args) {
        int i = 5 / 2;
        System.out.println(new _50_MyPow().myPow(2.00000, 10));
    }

    public double myPow(double x, int n) {
        System.out.println(x);
        if (n == 0 || x == 1) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n < 0) {
            return 1 / (myPow(x, -(n + 1)) * x);
        }

        if (n % 2 == 0) {
            return myPow(x * x, n / 2);
        } else {
            return myPow(x * x, n / 2) * x;
        }
    }

}
