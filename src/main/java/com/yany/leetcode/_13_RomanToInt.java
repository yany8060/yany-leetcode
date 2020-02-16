package com.yany.leetcode;

/**
 * @author yanyong on 2020/2/3
 */
public class _13_RomanToInt {
    public static void main(String[] args) {
        System.out.println(new _13_RomanToInt().romanToInt("LVIII"));
    }

    public int romanToInt(String s) {
        int num = 0;
        char[] r = s.toCharArray();
        for (int i = r.length - 1; i >= 0; i--) {
            if ('I' == r[i]) {
                num += 1;
            }
            if ('V' == r[i]) {
                if ((i - 1) >= 0 && 'I' == r[i - 1]) {
                    num += 4;
                    i--;
                } else {
                    num += 5;
                }
            }
            if ('X' == r[i]) {
                if ((i - 1) >= 0 && 'I' == r[i - 1]) {
                    num += 9;
                    i--;
                } else {
                    num += 10;
                }
            }

            if ('L' == r[i]) {
                if ((i - 1) >= 0 && 'X' == r[i - 1]) {
                    num += 40;
                    i--;
                } else {
                    num += 50;
                }
            }

            if ('C' == r[i]) {
                if ((i - 1) >= 0 && 'X' == r[i - 1]) {
                    num += 90;
                    i--;
                } else {
                    num += 100;
                }
            }

            if ('D' == r[i]) {
                if ((i - 1) >= 0 && 'C' == r[i - 1]) {
                    num += 400;
                    i--;
                } else {
                    num += 500;
                }
            }


            if ('M' == r[i]) {
                if ((i - 1) >= 0 && 'C' == r[i - 1]) {
                    num += 900;
                    i--;
                } else {
                    num += 1000;
                }
            }
        }

        return num;

    }

}
