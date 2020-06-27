package com.yany.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yanyong on 2020/6/9
 */
public class _17_LetterCombinations {

    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    List<String> list = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return list;
        }
        backtrack("", digits);
        return list;
    }


    public void backtrack(String combination, String next_digits) {
        if (next_digits == null || next_digits.length() == 0) {
            list.add(combination);
            return;
        }
        char[] ch = phone.get(next_digits.substring(0, 1)).toCharArray();
        for (int i = 0; i < ch.length; i++) {
            backtrack(combination + ch[i], next_digits.substring(1));
        }
    }


}
