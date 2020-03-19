package com.yany.leetcode;

/**
 * 最长公共前缀
 *
 * @author yanyong on 2020/2/10
 */
public class _14_LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(new _14_LongestCommonPrefix().longestCommonPrefix(null));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuffer prefix = new StringBuffer("");
        for (int j = 0; ; j++) {
            char tmp = '\0';
            for (int i = 0; i < strs.length; i++) {
                if (j >= strs[i].length()) {
                    return prefix.toString();
                }
                if (tmp == '\0') {
                    tmp = strs[i].charAt(j);
                } else if (tmp != strs[i].charAt(j)) {
                    return prefix.toString();
                }
            }
            prefix.append(tmp);
        }
    }


}
