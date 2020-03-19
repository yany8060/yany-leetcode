package com.yany.leetcode;

/**
 * 字符串相乘
 * <p>
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * @author yanyong on 2020/2/11
 */
public class _43_MultiplyStrings {
    public static void main(String[] args) {
        System.out.println(new _43_MultiplyStrings().multiply("123", "456"));
    }

    public String multiply(String num1, String num2) {
        char[] value = new char[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i >= 0; i--) {
            int a = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int b = num2.charAt(j) - '0';
                value[i + j + 1] += a * b;
            }
        }

        int carry = 0;
        for (int i = value.length - 1; i >= 0; i--) {
            value[i] += carry;
            carry = value[i] / 10;
            value[i] %= 10;
        }


        int beginIndex = 0;
        while (beginIndex < value.length - 1 && value[beginIndex] == 0) {
            beginIndex++;
        }
        for (int i = beginIndex; i < value.length; i++) {
            value[i] += '0';
        }
        return new String(value, beginIndex, value.length - beginIndex);
    }

}
