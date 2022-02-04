package com.yany.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yanyong on 2018/11/27
 */
public class _3_LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        new _3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring3("abcabcbb");

//        LinkedList<String> linkedList = new LinkedList<>(Arrays.<String>asList("cc"));
//        System.out.println(linkedList.getFirst());

    }

    /**
     * 初步想法，重头遍历组成集合，找到最大的集合
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int n = subLength(s, i, s.length());
            max = Math.max(max, n);
        }
        System.out.println(max);
        return max;

    }

    public int subLength(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            if (set.contains(s.charAt(i))) {
                return set.size();
            } else {
                set.add(s.charAt(i));
            }
        }
        return set.size();
    }

    /**
     * 滑动窗口：两个索引（i,j）执行窗口的开始开始和结尾。
     * 1。索引j向右滑动，向窗口添加数据，直到出现重复字符停止，这时j-i 是这个阶段最大子串的长度；
     * 2. 然后索引i向左收缩窗口，直到索引j执行向的重复字符不再重复，这时可进行下一阶段的查找
     * 3. 重复1 ，2 直到 i或者j等于字符串长度停止，提取出最大长度
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0;
        int max = 0;
        while (i < s.length() && j < s.length()) {

            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                max = Math.max(max, (j - i));
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return max;

    }

    public int lengthOfLongestSubstring3(String s) {
        int l = 0, r = 0, max = 0;
        Set<Character> tmp = new HashSet<>();
        char[] arr = s.toCharArray();
        for (; r < arr.length; r++) {
            if (!tmp.contains(arr[r])) {
                tmp.add(arr[r]);
                max = Math.max(max, r - l);
                continue;
            }

            while (tmp.size() != 0) {
                if (!tmp.contains(arr[r])) {
                    break;
                }
                tmp.remove(arr[l]);
                l++;
            }
            tmp.add(arr[r]);
            max = Math.max(max, r - l);
        }


        return max;
    }

}
