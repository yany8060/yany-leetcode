package com.yany.leetcode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yanyong on 2018/12/5
 */
public class _5_LongestPalindrome {

    public String longestPalindrome(String s) {

        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));

            if (s.contains(convert(list))) {
                list.addLast(s.charAt(i));
            } else {
                list.removeFirst();
            }
        }

        return "";
    }

    public String convert(List<Character> x) {
        StringBuffer sb = new StringBuffer();
        for (int i = x.size() - 1; i >= 0; i--) {
            sb.append(x.get(i));
        }
        return sb.toString();
    }

}
