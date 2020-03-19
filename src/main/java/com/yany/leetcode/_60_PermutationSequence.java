package com.yany.leetcode;

/**
 * @author yanyong on 2020/3/19
 */
public class _60_PermutationSequence {
    public static void main(String[] args) {
        System.out.println(new _60_PermutationSequence().getPermutation(4, 9));
    }

    String tmp = "";

    public String getPermutation(int n, int k) {
        boolean[] visited = new boolean[n];

        permutation(n, 0, k, visited, "");
        return tmp;
    }

    public int permutation(int n, int dep, int k, boolean[] visited, String s) {
        if (dep == n) {
            k--;
            if (k == 0) {
                tmp = new String(s);
            }
            return k;
        }

        if (k == 0) {
            return k;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i - 1]) {
                continue;
            }

            visited[i - 1] = true;
            s = s + i;
            k = permutation(n, dep + 1, k, visited, s);

            visited[i - 1] = false;
            s = s.substring(0, s.length() - 1);
        }

        return k;

    }


}
