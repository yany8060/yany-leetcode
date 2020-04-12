package com.yany.swordoffer;

public class _48_LongestSubstringWithoutDuplication {
    public static void main(String[] args) {
        System.out.println(new _48_LongestSubstringWithoutDuplication().longestSubstringWithoutDuplication("arabcaczfyyr"));
    }

    public int longestSubstringWithoutDuplication(String str) {
        int r = 0, curLen = 0, maxLen = 0;
        String tmp = "";
        while (r < str.length()) {
            if (!tmp.contains(String.valueOf(str.charAt(r)))) {
                tmp = tmp + str.charAt(r);
                r++;
                curLen++;
            } else {
                tmp = tmp.substring(1);
                maxLen = Math.max(curLen, maxLen);
                curLen--;
            }
        }
        return maxLen = Math.max(curLen, maxLen);
    }

}
