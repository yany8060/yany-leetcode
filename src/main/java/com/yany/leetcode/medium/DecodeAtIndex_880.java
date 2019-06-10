package com.yany.leetcode.medium;

import java.awt.*;

/**
 * https://leetcode.com/problems/decoded-string-at-index/
 *
 * @author yanyong on 2019/6/4
 */
public class DecodeAtIndex_880 {


    public static void main(String[] args) {
        System.out.println(addString("abc", 3));

//        System.out.println(decodeAtIndex2("y959q969u3hb22odq595", 222280369));
//        System.out.println(decodeAtIndex2("ha22", 5));
        System.out.println(decodeAtIndex2("leet2code3", 10));
    }

    public static String decodeAtIndex2(String S, int K) {
        char[] s = S.toCharArray();
        int count = 0;
        int i = 0;
        for (; i < s.length; i++) {
            if (s[i] < '2' || s[i] > '9') {
                count++;
                if (count >= K) {
                    break;
                } else {
                    continue;
                }
            }

            count *= (s[i] - '0');
            if (count >= K) {
                break;
            }
        }

        while (true) {
            if (s[i] >= '0' && s[i] <= '9' && K != count) {
                K %= count / (s[i] - '0');
                count /= (s[i] - '0');
            } else if (K == i) {
                return "" + s[i];
            }
            i--;
        }
    }

    public static String decodeAtIndex(String S, int K) {
        char[] s = S.toCharArray();
        StringBuffer sb = new StringBuffer();
        int count = 0;

        for (int i = 0; i < s.length; i++) {
            if (s[i] < '2' || s[i] > '9') {
                count++;
                sb.append(s[i]);
                if (sb.length() == K) {
                    return String.valueOf(s[i]);
                }
                continue;
            }

            String temp = sb.toString();

            for (int j = 0; j < Integer.valueOf(String.valueOf(s[i])) - 1; j++) {
                sb.append(temp);
                if (sb.length() >= K) {
                    return String.valueOf(sb.charAt(K - 1));
                }
            }
        }

        return "";
    }

    public static String addString(String s, int n) {
        String temp = s;
        for (int i = 0; i < n; i++) {
            s += temp;
        }
        return s;
    }


}
