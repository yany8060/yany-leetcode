package com.yany.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _139_WordBreak {

    public static void main(String[] args) {

    }

    /**
     * dp[i] = d[j] && isContains(s.substring(i,j))
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak1(String s, List<String> wordDict) {
        Set<String> key = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String tmp = s.substring(i, j);
                dp[j + 1] = dp[i + 1] && key.contains(tmp);
            }

        }
        return dp[s.length()];
    }

    public boolean wordBreak2(String s, List<String> wordDict) {
        Set<String> key = new HashSet<>(wordDict);
        return isSplit(s, 0, key);
    }

    public boolean isSplit(String s, int n, Set<String> key) {
        if (n == s.length()) {
            return true;
        }
        for (int i = n; i < s.length(); i++) {
            String tmp = s.substring(n, i + 1);
            System.out.println(tmp);
            if (key.contains(tmp) && isSplit(s, i + 1, key)) {
                return true;
            }
        }

        return false;
    }
}
