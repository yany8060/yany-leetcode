package com.yany.leetcode;

/**
 * @author yanyong on 2020/3/3
 */
public class _6_ZigZagConversion {

    public static void main(String[] args) {
        String a = "LDREOEIIECIHNTSG";
        String b = "LDREOEIIECIHNTSG";

        System.out.println(new _6_ZigZagConversion().convert("A", 1));
    }

    public String convert(String s, int numRows) {
        StringBuffer sb = new StringBuffer("");
        int n = 2 * (numRows - 1);
        if (n == 0) {
            return s;
        }


        for (int i = 0; i < numRows; i++) {
            int a = i, b = n - i;
            int len = s.length();
            while (a < len) {
                sb.append(s.charAt(a));
                if (a != b && i != 0 && b < len) {
                    sb.append(s.charAt(b));
                }
                a = a + n;
                b = b + n;
            }
        }


        return sb.toString();
    }
}
