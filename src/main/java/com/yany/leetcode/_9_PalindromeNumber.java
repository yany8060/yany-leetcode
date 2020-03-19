package com.yany.leetcode;

/**
 * @author yanyong on 2020/3/9
 */
public class _9_PalindromeNumber {

    public static void main(String[] args) {
        System.out.println(new _9_PalindromeNumber().isPalindrome(121));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int tmp = 0, ori = x;
        while (x / 10 != 0) {
            tmp = 10 * tmp + x % 10;
            x = x / 10;
        }
        tmp = 10 * tmp + x % 10;
        if (tmp == ori) {
            return true;
        }
        return false;
    }

}
