package com.yany.leetcode.easy;

/**
 * @author yanyong on 2019/3/25
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String a = "adf";
        System.out.println(a.substring(0, 1));

        String[] strs = new String[]{"flower", "flow", "flow"};

        System.out.println(longestCommonPrefix(strs));

    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = "";
        int min = strs[0].length();
        for (int i = 0; i < strs.length; i++) {
            min = Math.min(strs[i].length(), min);
        }
        for (int j = 0; j <= min; j++) {
            for (int i = 0; i < strs.length; i++) {
                String temp = strs[i].substring(0, j);
                if (i == 0) {
                    prefix = temp;
                } else if (!prefix.equals(temp)) {
                    return prefix.substring(0, prefix.length() - 1);
                }
            }
        }
        return prefix;
    }

}
