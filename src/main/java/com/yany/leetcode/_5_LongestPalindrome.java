package com.yany.leetcode;


/**
 * 最长回文字符串
 * 动态规范法：
 * <p>
 * dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i+1][j-1])
 *
 * @author yanyong on 2018/12/5
 */
public class _5_LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(new _5_LongestPalindrome().longestPalindrome2(""));


        String s = "abcdefg";

        System.out.println(s.substring(1, 3));
    }

    public String longestPalindrome(String s) {
        String res = null;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

                if (dp[i][j] && (res == null || res.length() < (j - i + 1))) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    public String longestPalindrome2(String s) {
        String res = "";
        int n = s.length();
        boolean[][] dp = new boolean[n][n];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (i - j < 3 || dp[i - 1][j + 1]);

                if (dp[i][j] && (res == null || res.length() < (i - j + 1))) {
                    res = s.substring(j, i + 1);
                }
            }
        }

        return res;
    }


}
