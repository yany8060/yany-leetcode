package com.yany.leetcode;

/**
 * @author yanyong on 2020/3/5
 */
public class _10_RegularExpressionMatching {

    public static void main(String[] args) {
        System.out.println(new _10_RegularExpressionMatching().isMatch("aaab", "a*ab"));
    }

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;//dp[i][j] 表示 s 的前 i 个是否能被 p 的前 j 个匹配
        for (int i = 0; i < p.length(); i++) { // here's the p's length, not s's
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true; // here's y axis should be i+1
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {//如果是任意元素 或者是对于元素匹配
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {//如果前一个元素不匹配 且不为任意元素
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                            /*
                            dp[i][j] = dp[i-1][j] // 多个字符匹配的情况
                            or dp[i][j] = dp[i][j-1] // 单个字符匹配的情况
                            or dp[i][j] = dp[i][j-2] // 没有匹配的情况
                             */

                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public boolean isMatch2(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        int j = 0;
        char tmp = '0';

        boolean[] r = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (j >= p.length()) {
                break;
            }
            char c = s.charAt(i);
            if (c == p.charAt(j)) {
                r[i] = true;
                tmp = p.charAt(j);
                j++;
                continue;
            }

            if ('.' != p.charAt(j) && '*' != p.charAt(j)) {
                if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                    j = j + 2;
                    i--;
                    continue;
                }
                break;
            }

            if (p.charAt(j) == '.') {
                tmp = p.charAt(j);
                r[i] = true;
                j++;
                continue;
            }

            if (p.charAt(j) == '*') {
                if (tmp == '.' || tmp == c) {
                    r[i] = true;
                } else {
                    tmp = p.charAt(j);
                    j++;
                    i--;
                }
            }
        }

        for (int i = 0; i < r.length; i++) {
            if (!r[i]) {
                return false;
            }
        }
        if ('*' == p.charAt(p.length() - 1)) {
            j++;
        }

        if (j != p.length()) {
            return false;
        }
        return true;
    }


}
